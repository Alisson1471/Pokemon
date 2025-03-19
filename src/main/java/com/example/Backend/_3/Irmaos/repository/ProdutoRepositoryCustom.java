package com.example.Backend._3.Irmaos.repository;

import com.example.Backend._3.Irmaos.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class ProdutoRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateProdutoById(String id, Produto produto) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update()
                .set("id", produto.getId()) // Adicione os campos necessários
                .set("nome", produto.getNome())
                .set("categoria", produto.getCategoria())
                .set("imagem", produto.getImagem())
                .set("descricao", produto.getDescricao())
                .set("preco", produto.getPreco());

        mongoTemplate.updateFirst(query, update, Produto.class);
    }

}
