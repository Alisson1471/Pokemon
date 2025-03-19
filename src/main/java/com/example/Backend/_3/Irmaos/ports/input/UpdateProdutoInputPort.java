package com.example.Backend._3.Irmaos.ports.input;

import com.example.Backend._3.Irmaos.entity.Produto;

public interface UpdateProdutoInputPort {

    String updateProdutoById(Produto produto, String id);

}
