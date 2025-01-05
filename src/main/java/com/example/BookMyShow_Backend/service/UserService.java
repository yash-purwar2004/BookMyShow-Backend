package com.example.BookMyShow_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.BookMyShow_Backend.Repository.UserRepository;
import com.example.BookMyShow_Backend.entity.User;

@Service
public class UserService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(User user) {
        User client = User.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();

        
                SimpleMailMessage mailmessage = new SimpleMailMessage();
                mailmessage.setTo(client.getEmail());
                mailmessage.setSubject("Welcome to BookMyShow");
                mailmessage.setFrom("yashpurwar.251198@gmail.com");
                String body = "Hi " + client.getName()+" !" +
                "Welcome to Book My Show Application, Enjoy WELCOME10 to get !0% off on tickets";
                mailmessage.setText(body);

                javaMailSender.send(mailmessage);

                user = userRepository.save(client);

        
        return "User has been saved to the Db with userId "+ client.getUserId();
    }
}
