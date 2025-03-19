package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.ports.input.CreateProdutoInputPort;
import com.example.Backend._3.Irmaos.ports.output.CreateProdutoOutputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProdutoUseCase implements CreateProdutoInputPort {

    @Autowired
    private CreateProdutoOutputPort createProdutoOutputPort;

    @Autowired
    private FetchProdutoOutputPort fetchProdutoOutputPort;

    public ResponseEntity<String> createProduto(Produto request) {
        if (fetchProdutoOutputPort.fetchProdutoByNome(request.getNome()) != null) {
            return ResponseEntity.status(409).body("Produto já existente!");
        }

        createProdutoOutputPort.createProduto(request);
        return ResponseEntity.status(201).body("Produto criado com sucesso!");
    }

}
