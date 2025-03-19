package com.example.Backend._3.Irmaos.ports.output;

import com.example.Backend._3.Irmaos.entity.User;

public interface FetchUserOutputPort {

    User fetchUserByEmail(String email);

}
