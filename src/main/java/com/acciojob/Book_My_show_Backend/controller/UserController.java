package com.acciojob.Book_My_show_Backend.controller;

import com.acciojob.Book_My_show_Backend.Requests.AddUserRequest;
import com.acciojob.Book_My_show_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("addUser")
    public String addUser(@RequestBody AddUserRequest addUserRequest){

        return userService.addUser(addUserRequest);
    }

}
