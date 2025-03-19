package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.User;

import java.util.List;

public interface UpdateUserInputPort {

    String updateUserByEmail(User user, String email);

    String updateCarrinhoFromUserByEmail(String user_email, List<User.ProdutoCarrinho> carrinho);

    String makePurchase(String id, Double valor);

}
