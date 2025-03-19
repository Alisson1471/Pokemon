package com.example.Backend._3.Irmaos.repository;

import com.example.Backend._3.Irmaos.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

    Produto findProdutoById(String id);

    Produto findProdutoByNome(String nome);

    List<Produto> findProdutosByCategoria(String categoria);

    @Query(value = "{ '_id': ?0 }", delete = true)
    long deleteProdutoById(String id);
}
