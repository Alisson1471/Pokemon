package com.example.Backend._3.Irmaos.adapter;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.ports.output.CreateProdutoOutputPort;
import com.example.Backend._3.Irmaos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProdutoAdapter implements CreateProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void createProduto(Produto request) {
        produtoRepository.save(request);
    }

}
