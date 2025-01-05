package com.example.BookMyShow_Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookMyShow_Backend.Enums.SeatType;
import com.example.BookMyShow_Backend.Repository.ShowRepository;
import com.example.BookMyShow_Backend.Repository.ShowSeatRepository;
import com.example.BookMyShow_Backend.Repository.TicketRepository;
import com.example.BookMyShow_Backend.Repository.UserRepository;
import com.example.BookMyShow_Backend.Requests.BookTicketRequest;
import com.example.BookMyShow_Backend.Responses.TicketResponse;
import com.example.BookMyShow_Backend.entity.Show;
import com.example.BookMyShow_Backend.entity.ShowSeat;
import com.example.BookMyShow_Backend.entity.Ticket;
import com.example.BookMyShow_Backend.entity.User;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String bookTicket(BookTicketRequest bookTicketRequest) {
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        // MARK THOSE SEATS AS BOOKED
        Integer totalAmount = 0;
        List<ShowSeat> showSeats = show.getShowSeatList();

        for(ShowSeat showSeat : showSeats){
            String seatNo = showSeat.getSeatNo();
            if(bookTicketRequest.getRequestedSeats().contains(seatNo)){
                showSeat.setIsBooked(Boolean.TRUE);

                if(showSeat.getSeatType().equals(SeatType.CLASSIC)){
                    totalAmount = totalAmount + 100;
                }else{
                    totalAmount = totalAmount + 150;
                }
            }
        }

        // create a ticket object and save it in the database
        Ticket ticket = Ticket.builder()
                .bookedSeats(bookTicketRequest.getRequestedSeats().toString())
                .movieName(show.getMovie().getMovieName())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .theatreName(show.getTheater().getTheaterName())
                .totalAmount(totalAmount)
                .show(show)
                .user(user)
                .build();

        showSeatRepository.saveAll(showSeats);
        ticket = ticketRepository.save(ticket);
        return ticket.getTicketId();
    }

    public TicketResponse getTicketDetails(String ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).get();
        return TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .movieName(ticket.getMovieName())
                .showDate(ticket.getShowDate())
                .showTime(ticket.getShowTime())
                .theaterName(ticket.getTheatreName())
                .totalAmount(ticket.getTotalAmount())
                .build();
    }
}
