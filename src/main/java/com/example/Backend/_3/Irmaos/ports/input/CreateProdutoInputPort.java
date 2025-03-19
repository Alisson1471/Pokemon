package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.Produto;
import org.springframework.http.ResponseEntity;

public interface CreateProdutoInputPort {

    ResponseEntity<String> createProduto(Produto request);

}
