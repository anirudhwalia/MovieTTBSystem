package com.anirudh.MovieTTBSystem.Model;



import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.time.LocalTime;

@Entity(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private int ticketId;
    @Column(name = "Is_Booked")
    private boolean isBooked;
    @Column(name = "available_seats")
    private int available_Seats;
    @Column(name = "Is_Expired")
    private boolean isExpired;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "show_id")
    private Show show;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getAvailable_Seats() {
        return available_Seats;
    }

    public void setAvailable_Seats(int available_Seats) {
        this.available_Seats = available_Seats;
    }

    Ticket(boolean isBooked, int available_Seats, boolean isExpired){

        this.isBooked = isBooked;
        this.isExpired = isExpired;
    }
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
