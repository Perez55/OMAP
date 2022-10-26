package com.OMAP.dao;

import java.util.List;

import com.OMAP.dto.Movie;

public interface IMovieDAO {
	List<Movie> getMovies() throws Exception;
}
