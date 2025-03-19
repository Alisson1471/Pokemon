package com.example.Backend._3.Irmaos.repository;

import com.example.Backend._3.Irmaos.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByEmail(String email);

    @Query(value = "{ 'email': ?0 }", delete = true)
    long deleteUserByEmail(String email);

}
