package com.acciojob.Book_My_show_Backend.Requests;


import java.time.LocalDate;
import java.time.LocalTime;


public class AddShowRequest {
    private LocalDate showDate;
    private LocalTime showTime;

    private String movieName;
    private Integer theaterId;
    public LocalDate getShowDate() {
        return showDate;
    }
    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }
    public LocalTime getShowTime() {
        return showTime;
    }
    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public Integer getTheaterId() {
        return theaterId;
    }
    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }
}
