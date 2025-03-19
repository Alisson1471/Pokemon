package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.ports.input.UpdateUserInputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchProdutoOutputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchUserOutputPort;
import com.example.Backend._3.Irmaos.ports.output.UpdateUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateUserUseCase implements UpdateUserInputPort {

    @Autowired
    private UpdateUserOutputPort updateUserOutputPort;

    @Autowired
    private FetchUserOutputPort fetchUserOutputPort;

    @Autowired
    private FetchProdutoOutputPort fetchProdutoOutputPort;

    public String updateUserByEmail(User user, String email) {

        User antes = fetchUserOutputPort.fetchUserByEmail(email);

        updateUserOutputPort.updateUserByEmail(user, email);

        User depois = fetchUserOutputPort.fetchUserByEmail(email);

        if (antes != depois) {
            return "Produto foi atualizado com sucesso!";
        }
        return "Produto não foi atualizado!";
    }

    public String updateCarrinhoFromUserByEmail(String user_email, List<User.ProdutoCarrinho> carrinho) {

        User user_antes = fetchUserOutputPort.fetchUserByEmail(user_email);

        user_antes.setCarrinho(carrinho);

        updateUserOutputPort.updateUserById(user_antes, user_email);

        User user_depois = fetchUserOutputPort.fetchUserByEmail(user_email);

        if (user_antes.getCarrinho() != user_depois.getCarrinho()) {
            return "Produto foi atualizado com sucesso!";
        }
        return "Produto não foi atualizado!";

    }

    public String makePurchase(String email, Double valor) {

        User antes = fetchUserOutputPort.fetchUserByEmail(email);

        if (antes.getCartao().getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }

        antes.getCartao().setSaldo(antes.getCartao().getSaldo() - valor);

        updateUserOutputPort.updateUserById(antes, email);

        User depois = fetchUserOutputPort.fetchUserByEmail(email);

        if (!antes.getCartao().getSaldo().equals(depois.getCartao().getSaldo())) {
            return "Produto foi atualizado com sucesso!";
        }
        return "Produto não foi atualizado!";
    }

}
