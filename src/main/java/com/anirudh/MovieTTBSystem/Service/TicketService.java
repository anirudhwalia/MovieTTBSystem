package com.anirudh.MovieTTBSystem.Service;

import com.anirudh.MovieTTBSystem.Model.Ticket;
import com.anirudh.MovieTTBSystem.Model.User;
import com.anirudh.MovieTTBSystem.Repository.TicketRepository;
import com.anirudh.MovieTTBSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<Ticket> getAllTickets(){ return ticketRepository.findAll(); }
    public void deleteTicketById(int id){
        ticketRepository.deleteById(id);
    }
    public User getUserByTicket(int id){
        return userRepository.findByTicketTicketId(id);
    }
    public Ticket updateTiming(int id, LocalTime startTime, LocalTime endTime){
        Ticket existingTicket = ticketRepository.findById(id).orElse(null);
        existingTicket.setStartTime(startTime);
        existingTicket.setEndTime(endTime);
        return ticketRepository.save(existingTicket);
    }

    public List<Ticket> getAllTicketsByTime(LocalTime startTime) {
        return ticketRepository.findAllByStartTime(startTime);
    }
}
