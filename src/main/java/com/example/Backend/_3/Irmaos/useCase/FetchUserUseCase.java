package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.exception.FailPasswordException;
import com.example.Backend._3.Irmaos.exception.NotFoundException;
import com.example.Backend._3.Irmaos.ports.input.FetchUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchUserUseCase implements FetchUserInputPort {

    @Autowired
    private FetchUserOutputPort fetchUserOutputPort;

    public User fetchUserByEmail(String email, String password) {
        User user = fetchUserOutputPort.fetchUserByEmail(email);

        if (user == null) {
            throw new NotFoundException("Usuário não encontrado!");
        }

        if (!user.getSenha().equals(password)) {
            throw new FailPasswordException("Senha incorreta");
        }

        return user;
    }

    public List<User.ProdutoCarrinho> listProdutos(String email) {
        User user = fetchUserOutputPort.fetchUserByEmail(email);

        if (user.getCarrinho() != null) {
            throw new NullPointerException("Campo de carrinho vazio!");
        }

        return user.getCarrinho();

    }

}
