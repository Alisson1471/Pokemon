package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface FetchProdutoInputPort {

    Produto fetchProdutoById(String id);

    Produto fetchProdutoByNome(String nome);

    List<Produto> fetchProdutosByCategoria(String categoria);

}
