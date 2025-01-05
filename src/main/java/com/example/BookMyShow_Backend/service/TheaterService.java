package com.example.BookMyShow_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookMyShow_Backend.Repository.TheaterRepository;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
}
