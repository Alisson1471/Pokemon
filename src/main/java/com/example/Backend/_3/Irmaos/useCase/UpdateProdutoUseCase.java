package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.ports.input.UpdateProdutoInputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchProdutoOutputPort;
import com.example.Backend._3.Irmaos.ports.output.UpdateProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProdutoUseCase implements UpdateProdutoInputPort {

    @Autowired
    private UpdateProdutoOutputPort updateProdutoOutputPort;

    @Autowired
    private FetchProdutoOutputPort fetchProdutoOutputPort;

    public String updateProdutoById(Produto produto, String id) {

        Produto antes = fetchProdutoOutputPort.fetchProdutoById(id);

        updateProdutoOutputPort.updateProdutoById(produto, id);

        Produto depois = fetchProdutoOutputPort.fetchProdutoById(id);

        if (antes != depois) {
            return "Produto foi atualizado com sucesso!";
        }
        return "Produto não foi atualizado!";
    }

}
