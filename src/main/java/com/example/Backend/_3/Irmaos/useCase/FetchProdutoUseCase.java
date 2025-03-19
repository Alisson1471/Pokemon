package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.exception.NotFoundException;
import com.example.Backend._3.Irmaos.ports.input.FetchProdutoInputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchProdutoUseCase implements FetchProdutoInputPort {

    @Autowired
    private FetchProdutoOutputPort fetchProdutoOutputPort;

    public Produto fetchProdutoById(String id) {
        Produto produto = fetchProdutoOutputPort.fetchProdutoById(id);

        if (produto == null) {
            throw new NotFoundException("Produto não encontrado");
        }

        return produto;
    }

    public Produto fetchProdutoByNome(String nome) {
        Produto produto = fetchProdutoOutputPort.fetchProdutoByNome(nome);

        if (produto == null) {
            throw new NotFoundException("Produto não encontrado");
        }

        return produto;
    }

    public List<Produto> fetchProdutosByCategoria(String categoria) {
        List<Produto> produtos = fetchProdutoOutputPort.fetchProdutosByCategoria(categoria);

        if (produtos.isEmpty()) {
            throw new NotFoundException("Produtos com essa categoria não encontrados!");
        }

        return produtos;
    }

}
