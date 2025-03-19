package com.example.Backend._3.Irmaos.adapter;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.exception.NotFoundException;
import com.example.Backend._3.Irmaos.ports.output.FetchProdutoOutputPort;
import com.example.Backend._3.Irmaos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FetchProdutoAdapter implements FetchProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto fetchProdutoById(String id) {
        return produtoRepository.findProdutoById(id);
    }

    public Produto fetchProdutoByNome(String nome) {
        return produtoRepository.findProdutoByNome(nome);
    }

    public List<Produto> fetchProdutosByCategoria(String categoria) {
        return produtoRepository.findProdutosByCategoria(categoria);
    }

}
