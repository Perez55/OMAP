package com.OMAP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoviesController {
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}


}
