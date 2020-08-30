package com.anirudh.MovieTTBSystem.Controller;

import com.anirudh.MovieTTBSystem.Model.Ticket;
import com.anirudh.MovieTTBSystem.Model.User;
import com.anirudh.MovieTTBSystem.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @DeleteMapping("/tickets/{ticketId}")
    void deleteTicket(@PathVariable("ticketId") int id){

        ticketService.deleteTicketById(id);
    }

    @GetMapping("/tickets/{ticketId}")
    User getUserByTicket(@PathVariable int id){

        return ticketService.getUserByTicket(id);
    }

    @PostMapping("/tickets")
    Ticket createTicket(@RequestBody Ticket ticket){

        return ticketService.createTicket(ticket);
    }

    @GetMapping("/tickets/{ticketId}/Show/{Start}")
    List<Ticket> GetTicketsForParticularTime(@PathVariable LocalTime Start){
        return ticketService.findTicketsByShowStart(Start);
    }
}
