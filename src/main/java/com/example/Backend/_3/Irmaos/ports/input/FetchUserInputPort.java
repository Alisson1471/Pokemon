package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.User;

import java.util.List;

public interface FetchUserInputPort {


    User fetchUserByEmail(String email, String password);

    List<User.ProdutoCarrinho> listProdutos(String id);

}
