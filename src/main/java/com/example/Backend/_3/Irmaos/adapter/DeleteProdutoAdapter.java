package com.example.Backend._3.Irmaos.adapter;

import com.example.Backend._3.Irmaos.ports.output.DeleteProdutoOutputPort;
import com.example.Backend._3.Irmaos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProdutoAdapter implements DeleteProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    public boolean deleteProdutoById(String id) {
        long deletedCount = produtoRepository.deleteProdutoById(id);
        return deletedCount > 0;
    }

}
