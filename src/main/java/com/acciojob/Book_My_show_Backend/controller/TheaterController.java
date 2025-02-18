package com.acciojob.Book_My_show_Backend.controller;

import com.acciojob.Book_My_show_Backend.Requests.AddTheaterRequest;
import com.acciojob.Book_My_show_Backend.Requests.AddTheaterSeatsRequest;
import com.acciojob.Book_My_show_Backend.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;
    @PostMapping("addTheater")
    public ResponseEntity<String> addTheater(@RequestBody AddTheaterRequest addTheaterRequest){

        String response = theaterService.addTheater(addTheaterRequest);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PutMapping("associateSeats")
    public ResponseEntity<String> associateSeats(@RequestBody AddTheaterSeatsRequest addTheaterSeatsRequest){
        String response = theaterService.associateSeats(addTheaterSeatsRequest);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
