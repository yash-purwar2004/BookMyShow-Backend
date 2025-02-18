package com.acciojob.Book_My_show_Backend.Repository;

import com.acciojob.Book_My_show_Backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}
