package com.anirudh.MovieTTBSystem.Service;

import com.anirudh.MovieTTBSystem.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

}
