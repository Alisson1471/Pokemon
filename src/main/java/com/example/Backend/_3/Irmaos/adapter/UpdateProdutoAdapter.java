package com.example.Backend._3.Irmaos.adapter;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.ports.output.UpdateProdutoOutputPort;
import com.example.Backend._3.Irmaos.repository.ProdutoRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProdutoAdapter implements UpdateProdutoOutputPort {

    @Autowired
    private ProdutoRepositoryCustom produtoRepositoryCustom;

    public void updateProdutoById(Produto produto, String id) {
        produtoRepositoryCustom.updateProdutoById(id, produto);
    }

}
