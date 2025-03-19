package com.example.Backend._3.Irmaos.adapter;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.ports.output.CreateUserOutputPort;
import com.example.Backend._3.Irmaos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserAdapter implements CreateUserOutputPort {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User request) {
        userRepository.save(request);
    }
}
