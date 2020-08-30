package com.anirudh.MovieTTBSystem.Service;

import com.anirudh.MovieTTBSystem.Model.Ticket;
import com.anirudh.MovieTTBSystem.Model.User;
import com.anirudh.MovieTTBSystem.Repository.ShowRepository;
import com.anirudh.MovieTTBSystem.Repository.TicketRepository;
import com.anirudh.MovieTTBSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    public List<Ticket> findTicketsByShowStart(LocalTime Start){
        return showRepository.findByShowStart(Start);
    }
    public void deleteTicketById(int id){
        ticketRepository.deleteById(id);
    }
    public User getUserByTicket(int id){
        return userRepository.findByTicketId(id);
    }
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
