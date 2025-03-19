package com.example.Backend._3.Irmaos.ports.output;

import com.example.Backend._3.Irmaos.entity.User;

public interface UpdateUserOutputPort {

    void updateUserById(User user, String id);

    void updateUserByEmail(User user, String email);

}
