package com.example.Backend._3.Irmaos.useCase;

import com.example.Backend._3.Irmaos.exception.NotFoundException;
import com.example.Backend._3.Irmaos.ports.input.DeleteProdutoInputPort;
import com.example.Backend._3.Irmaos.ports.output.DeleteProdutoOutputPort;
import com.example.Backend._3.Irmaos.ports.output.FetchProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProdutoUseCase implements DeleteProdutoInputPort {

    @Autowired
    private DeleteProdutoOutputPort deleteProdutoOutputPort;

    @Autowired
    private FetchProdutoOutputPort fetchProdutoOutputPort;

    public String deleteProdutoById(String id) {

        if (fetchProdutoOutputPort.fetchProdutoById(id) == null) {
            throw new NotFoundException("Produto com id="+id+" não foi encontrado!");
        }

        if (deleteProdutoOutputPort.deleteProdutoById(id)) {
            return "Produto com id="+id+" foi deletado com sucesso!";
        }
        return "Produto com id="+id+" não foi deletado!";
    }

}
