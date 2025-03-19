package com.example.Backend._3.Irmaos.controller;

import com.example.Backend._3.Irmaos.entity.Produto;
import com.example.Backend._3.Irmaos.ports.input.CreateProdutoInputPort;
import com.example.Backend._3.Irmaos.ports.input.DeleteProdutoInputPort;
import com.example.Backend._3.Irmaos.ports.input.FetchProdutoInputPort;
import com.example.Backend._3.Irmaos.ports.input.UpdateProdutoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://10.10.10.230", "http://10.10.11.19", "http://172.28.16.1", "http://localhost:5173", "http://localhost:5174"})
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private CreateProdutoInputPort createProdutoInputPort;

    @Autowired
    private FetchProdutoInputPort fetchProdutoInputPort;

    @Autowired
    private DeleteProdutoInputPort deleteProdutoInputPort;

    @Autowired
    private UpdateProdutoInputPort updateProdutoInputPort;

    @PostMapping("/create_produto")
    public ResponseEntity<String> createProduto(@RequestBody Produto request) {
        return createProdutoInputPort.createProduto(request);
    }

    @GetMapping("/find_produto_id")
    public Produto fetchProdutoById(@RequestParam String id) {
        return fetchProdutoInputPort.fetchProdutoById(id);
    }

    @GetMapping("/find_produto_nome")
    public Produto fetchProdutoByNome(@RequestParam String nome) {
        return fetchProdutoInputPort.fetchProdutoByNome(nome);
    }

    @GetMapping("/find_categoria")
    public List<Produto> fetchCategoria(@RequestParam String categoria) {
        return fetchProdutoInputPort.fetchProdutosByCategoria(categoria);
    }

    @DeleteMapping("/delete_produto_id")
    public String deleteProdutoById(@RequestParam String id) {
        return deleteProdutoInputPort.deleteProdutoById(id);
    }

    @PutMapping("/update_produto_id")
    public String updateProdutoById(@RequestBody Produto produto, @RequestParam String id) {
        return updateProdutoInputPort.updateProdutoById(produto, id);
    }

}
