package com.example.Backend._3.Irmaos.ports.output;

import com.example.Backend._3.Irmaos.entity.Produto;

public interface UpdateProdutoOutputPort {

    void updateProdutoById(Produto produto, String id);

}
