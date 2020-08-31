package com.anirudh.MovieTTBSystem.Model;

import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "phone")
    private String phone;
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    User(){
    }
     User(String phone, String name, Ticket ticket) {
         this.phone = phone;
         this.name = name;
        this.ticket = ticket;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}