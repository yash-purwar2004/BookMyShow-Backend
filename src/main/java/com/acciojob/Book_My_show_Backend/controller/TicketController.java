package com.acciojob.Book_My_show_Backend.controller;

import com.acciojob.Book_My_show_Backend.Requests.BookTicketRequest;
import com.acciojob.Book_My_show_Backend.Responses.TicketResponse;
import com.acciojob.Book_My_show_Backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @PostMapping("bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        return ticketService.bookTicket(bookTicketRequest);
    }

    @GetMapping("generateTicket")
    public TicketResponse generateTicket(@RequestParam("ticketId")String ticketId){
        return ticketService.generateTicket(ticketId);
    }
}
