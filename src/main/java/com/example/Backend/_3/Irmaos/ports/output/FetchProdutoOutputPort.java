package com.example.Backend._3.Irmaos.ports.output;

import com.example.Backend._3.Irmaos.entity.Produto;

import java.util.List;

public interface FetchProdutoOutputPort {

    Produto fetchProdutoById(String id);

    Produto fetchProdutoByNome(String nome);

    List<Produto> fetchProdutosByCategoria(String categoria);

}
