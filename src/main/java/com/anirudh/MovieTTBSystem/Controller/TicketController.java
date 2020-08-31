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




    @PostMapping("/bookTicket")
    String bookTicket(@RequestBody User user){
        Ticket ticket = user.getTicket();
        LocalTime n = ticket.getStartTime();
        List<Ticket> tickets = ticketService.getAllTickets();
        int count = 0;
        for(Ticket item : tickets){
            if(item.getStartTime() != null) {
                if (item.getStartTime().equals(n)) {
                    count++;
                }
            }
        }
        if(count < 20){
            ticketService.createUser(user);
            return "Ticket id booked " + user;
        }
        else{

            return "Sorry, There are no Tickets available for " + n + " time.";
        }
    }
    @PutMapping("/tickets/{ticket_id}")
    Ticket updateTiming(@RequestBody int ticketId, LocalTime startTime, LocalTime endTime){
        return ticketService.updateTiming(ticketId, startTime, endTime);
    }


    @GetMapping("tickets/{startTime}")
    public List<Ticket> ticketsByTime(LocalTime startTime){
        return ticketService.getAllTicketsByTime(startTime);
    }

    @DeleteMapping("/tickets/{ticketId}")
    String deleteTicket(@PathVariable("ticketId") int id){

        ticketService.deleteTicketById(id);
        return "Ticket " + id + " deleted";
    }

    @GetMapping("/tickets/{ticketId}")
    User getUserByTicket(@PathVariable int id){

        return ticketService.getUserByTicket(id);
    }



}
