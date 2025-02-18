package com.acciojob.Book_My_show_Backend.Requests;


public class AddTheaterSeatsRequest {
    //DTO (data transfer objects) are custom classes helping you take inputs from client
    private Integer theaterId;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
    public Integer getTheaterId() {
        return theaterId;
    }
    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }
    public Integer getNoOfClassicSeats() {
        return noOfClassicSeats;
    }
    public void setNoOfClassicSeats(Integer noOfClassicSeats) {
        this.noOfClassicSeats = noOfClassicSeats;
    }
    public Integer getNoOfPremiumSeats() {
        return noOfPremiumSeats;
    }
    public void setNoOfPremiumSeats(Integer noOfPremiumSeats) {
        this.noOfPremiumSeats = noOfPremiumSeats;
    }
}
