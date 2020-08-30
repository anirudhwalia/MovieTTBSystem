package com.anirudh.MovieTTBSystem.Model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "show_id")
    int showId;
    @Column(name = "start_time")
    LocalTime Start;
    @Column(name = "end_time")
    LocalTime End;
    @Column(name = "movie_name")
    String movieName;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ticketId")
    private Ticket ticket;

    public Show(LocalTime start, LocalTime end, String movieName, Ticket ticket) {
        Start = start;
        End = end;
        this.movieName = movieName;
        this.ticket = ticket;
    }

    public LocalTime getStart() {
        return Start;
    }

    public void setStart(LocalTime start) {
        Start = start;
    }

    public LocalTime getEnd() {
        return End;
    }

    public void setEnd(LocalTime end) {
        End = end;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
