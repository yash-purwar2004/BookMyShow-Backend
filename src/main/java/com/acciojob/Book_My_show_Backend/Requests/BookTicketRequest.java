package com.acciojob.Book_My_show_Backend.Requests;


import java.util.List;

public class BookTicketRequest {

    private List<String> requestedSeats;
    private Integer showId;
    private Integer userId;

    
    public List<String> getRequestedSeats() {
        return requestedSeats;
    }
    public void setRequestedSeats(List<String> requestedSeats) {
        this.requestedSeats = requestedSeats;
    }
    public Integer getShowId() {
        return showId;
    }
    public void setShowId(Integer showId) {
        this.showId = showId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
