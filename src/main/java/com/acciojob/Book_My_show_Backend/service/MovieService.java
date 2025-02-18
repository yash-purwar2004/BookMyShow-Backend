package com.acciojob.Book_My_show_Backend.service;

import com.acciojob.Book_My_show_Backend.Repository.MovieRepository;
import com.acciojob.Book_My_show_Backend.Requests.AddMovieRequest;
import com.acciojob.Book_My_show_Backend.Requests.UpdateMovieRequest;
import com.acciojob.Book_My_show_Backend.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest movieRequest){

        Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setDuration(movieRequest.getDuration());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setRating(movieRequest.getRating());
        movie.setReleaseDate(movieRequest.getReleaseDate());

        movie = movieRepository.save(movie);
        return "Movie has been added to the DB with movieId "+movie.getMovieId();
    }

    public String updateMovie(UpdateMovieRequest updateMovieRequest){
        //Get the movie entity by name
        Movie movie = movieRepository.findMovieByMovieName(updateMovieRequest.getMovieName());

        //Update the new attributes
        movie.setLanguage(updateMovieRequest.getNewLanguage());
        movie.setRating(updateMovieRequest.getNewRating());

        //save it to the DB:
        movieRepository.save(movie);
        return "Movie Attributes have been updated";
    }


}
