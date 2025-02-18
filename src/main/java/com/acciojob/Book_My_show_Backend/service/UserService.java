package com.acciojob.Book_My_show_Backend.service;

import com.acciojob.Book_My_show_Backend.Repository.UserRepository;
import com.acciojob.Book_My_show_Backend.Requests.AddUserRequest;
import com.acciojob.Book_My_show_Backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;
    public String addUser(AddUserRequest userRequest){

        User user = new User();
        user.setAge(userRequest.getAge());
        user.setEmailId(userRequest.getEmailId());
        user.setName(userRequest.getName());
        user.setMobileNo(userRequest.getMobileNo());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userRequest.getEmailId()); // This is the email id of the receiver
        mailMessage.setFrom("fetchhappy8080@gmail.com"); // This is the email id of the sender
        mailMessage.setSubject("Welcome to Book My Show Application ");

        String body = "Hi " +userRequest.getName()+" !" +
                "Welcome to Book My Show Application, Enjoy WELCOME10 to get 10% off on tickets";

        mailMessage.setText(body);

        javaMailSender.send(mailMessage);

        user = userRepository.save(user);
        return "User has been saved to the Db with userId "+user.getUserId();
    }
}
