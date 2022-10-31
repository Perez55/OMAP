package com.OMAP;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.OMAP.dao.IMovieDAO;
import com.OMAP.dto.Movie;

@Controller
public class MoviesController {
	// Instantiate movie object and create new ArrayList to contain them
	@Autowired
	IMovieDAO moviedao;
	List<Movie> allMovies = new ArrayList<Movie>();
	List<Movie> testMovies = new ArrayList<Movie>();
	int number = 46;
	
	// Create movie objects from JSON data
	@PostConstruct
	private void loadData() {
		try {
			allMovies = moviedao.getMovies();
			testMovies = allMovies.subList(63, 70); // filtering the array for these elements just to test display
		} 
		// Any Exception will be caught and returned to the user in the ouput
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Mapping for localhost:8080/
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	// Mapping for localhost:8080/list
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("testListMovies", testMovies);
		return "list-movies";		
	}

	// Error handling for any other URL
	@GetMapping(value="/error")
	public String error() {
		return "error";
	}
}