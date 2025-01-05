package com.example.BookMyShow_Backend.entity;

import com.example.BookMyShow_Backend.Enums.SeatType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "theater_seats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer theaterId;
    private Integer seatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType; 
    
    private Theater theater;
}
