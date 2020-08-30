package com.anirudh.MovieTTBSystem.Repository;

import com.anirudh.MovieTTBSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByTicketId(int ticketId);
}
