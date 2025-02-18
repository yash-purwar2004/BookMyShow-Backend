package com.acciojob.Book_My_show_Backend.Requests;

import com.acciojob.Book_My_show_Backend.Enums.Language;

public class UpdateMovieRequest {
    private String movieName;
    private Language newLanguage;
    private Double newRating;
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public Language getNewLanguage() {
        return newLanguage;
    }
    public void setNewLanguage(Language newLanguage) {
        this.newLanguage = newLanguage;
    }
    public Double getNewRating() {
        return newRating;
    }
    public void setNewRating(Double newRating) {
        this.newRating = newRating;
    }
}
