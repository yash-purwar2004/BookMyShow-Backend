package com.acciojob.Book_My_show_Backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private String name;

    private String address;

    private Integer noOfScreens;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNoOfScreens() {
        return noOfScreens;
    }

    public void setNoOfScreens(Integer noOfScreens) {
        this.noOfScreens = noOfScreens;
    }

    public List<TheaterSeat> getTheaterSeatList() {
        return theaterSeatList;
    }

    public void setTheaterSeatList(List<TheaterSeat> theaterSeatList) {
        this.theaterSeatList = theaterSeatList;
    }

    @Override
    public String toString() {
        return "Theater [theaterId=" + theaterId + ", name=" + name + ", address=" + address + ", noOfScreens="
                + noOfScreens + ", theaterSeatList=" + theaterSeatList + "]";
    }
}
