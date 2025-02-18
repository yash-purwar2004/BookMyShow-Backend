package com.acciojob.Book_My_show_Backend.controller;

import com.acciojob.Book_My_show_Backend.Requests.AddShowRequest;
import com.acciojob.Book_My_show_Backend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;
    @PostMapping("add")
    public ResponseEntity<String> addShow(@RequestBody AddShowRequest addShowRequest){

        String response = showService.addShow(addShowRequest);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
