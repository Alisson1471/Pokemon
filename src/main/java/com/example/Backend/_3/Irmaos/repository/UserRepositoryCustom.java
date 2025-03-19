package com.example.Backend._3.Irmaos.repository;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateUserByEmail(String email, User user) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update()
                .set("nome", user.getNome())
                .set("sobrenome", user.getSobrenome())
                .set("email", user.getEmail())
                .set("cartao", user.getCartao());

        mongoTemplate.updateFirst(query, update, Produto.class);
    }

}
