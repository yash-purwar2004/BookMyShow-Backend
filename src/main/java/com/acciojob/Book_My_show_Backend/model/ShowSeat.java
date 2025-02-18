package com.acciojob.Book_My_show_Backend.model;

import com.acciojob.Book_My_show_Backend.Enums.SeatType;
import jakarta.persistence.*;

@Entity
@Table(name = "show_seats")
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Boolean isBooked;

    private Boolean isFoodAttached;

    @JoinColumn
    @ManyToOne
    private Show show;

    public Integer getShowSeatId() {
        return showSeatId;
    }

    public void setShowSeatId(Integer showSeatId) {
        this.showSeatId = showSeatId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Boolean isBooked) {
        this.isBooked = isBooked;
    }

    public Boolean getIsFoodAttached() {
        return isFoodAttached;
    }

    public void setIsFoodAttached(Boolean isFoodAttached) {
        this.isFoodAttached = isFoodAttached;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "ShowSeat [showSeatId=" + showSeatId + ", seatNo=" + seatNo + ", seatType=" + seatType + ", isBooked="
                + isBooked + ", isFoodAttached=" + isFoodAttached + ", show=" + show + "]";
    }
}
