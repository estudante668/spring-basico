package com.loja.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.dominio.produto.Produto;
import com.loja.servico.ProdutoServico;

@RestController
@RequestMapping("/produto")
public class Controle {

    private final ProdutoServico produtoServico;

    public Controle(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    @GetMapping
    public List<Produto> getAll() {
        return produtoServico.listaTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoServico.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoServico.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoServico.findById(id)
                .map(existing -> {
                    produto.setId(id);
                    return ResponseEntity.ok(produtoServico.save(produto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return produtoServico.findById(id)
                .map(existing -> {
                    produtoServico.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
}
