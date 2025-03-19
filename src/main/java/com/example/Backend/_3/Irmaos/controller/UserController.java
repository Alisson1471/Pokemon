package com.example.Backend._3.Irmaos.controller;

import com.example.Backend._3.Irmaos.entity.User;
import com.example.Backend._3.Irmaos.entity.request.RequestLogin;
import com.example.Backend._3.Irmaos.ports.input.CreateUserInputPort;
import com.example.Backend._3.Irmaos.ports.input.DeleteUserInputPort;
import com.example.Backend._3.Irmaos.ports.input.FetchUserInputPort;
import com.example.Backend._3.Irmaos.ports.input.UpdateUserInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"http://10.10.10.230", "http://10.10.11.19", "http://172.28.16.1", "http://localhost:5173", "http://localhost:5174"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FetchUserInputPort fetchUserInputPort;

    @Autowired
    private CreateUserInputPort createUserInputPort;

    @Autowired
    private UpdateUserInputPort updateUserInputPort;

    @Autowired
    private DeleteUserInputPort deleteUserInputPort;

    //CRUD

    @PostMapping("/login")
    public User fetchUserByEmail(@RequestBody RequestLogin request) {
        return fetchUserInputPort.fetchUserByEmail(request.getEmail(), request.getSenha());
    }

    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return createUserInputPort.createUser(user);
    }

    @PutMapping("/update_user_email")
    public String updateUserByEmail(@RequestBody User user, @RequestParam String email) {
        return updateUserInputPort.updateUserByEmail(user, email);
    }

    @DeleteMapping("/delete_user_email")
    public String deleteUserByEmail(@RequestParam String email) {
        return deleteUserInputPort.deleteUserByEmail(email);
    }

    // Funções do Cliente no Site

    @PutMapping("/update_carrinho")
    public String updateCarrinho(@RequestParam String user_email, @RequestParam List<User.ProdutoCarrinho> carrinho) {
        return updateUserInputPort.updateCarrinhoFromUserByEmail(user_email, carrinho);
    }

    @GetMapping("/list_carrinho_email")
    public List<User.ProdutoCarrinho> listProdutosCarrinho(@RequestParam String email) {
        return fetchUserInputPort.listProdutos(email);
    }

    @PutMapping("/make_purchase")
    public String makePurchase(@RequestParam String email, @RequestParam Double valor) {
        return updateUserInputPort.makePurchase(email, valor);
    }

}
