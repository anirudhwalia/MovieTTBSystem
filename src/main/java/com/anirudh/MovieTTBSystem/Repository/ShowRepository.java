package com.anirudh.MovieTTBSystem.Repository;

import com.anirudh.MovieTTBSystem.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface ShowRepository extends JpaRepository {

    public List<Ticket> findByShowStart(LocalTime StartTime);
}
