package com.example.BookMyShow_Backend.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tickets")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private String ticketId;
    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theatreName;
    private Integer totalAmount;

    // This annotation indicates a many-to-one relationship between two entities.
    // In this case, many Ticket instances can be associated with one Show instance.
    // For example, multiple tickets can belong to the same show (i.e., multiple people can book tickets for the same show) 

    @JoinColumn
    @ManyToOne
    private Show show;
    

    // This annotation specifies a many-to-one relationship between two entities.
    // In this case, many Ticket instances can be associated with a single User instance.
    // For example, a single user can book multiple tickets.

    // By default, JPA will create a column named user_id in the Ticket table (you can customize the column name using @JoinColumn(name = "custom_column_name")).
    @JoinColumn 
    @ManyToOne
    private User user;
}
