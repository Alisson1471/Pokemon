package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.User;
import org.springframework.http.ResponseEntity;

public interface CreateUserInputPort {

    ResponseEntity<String> createUser(User request);

}
