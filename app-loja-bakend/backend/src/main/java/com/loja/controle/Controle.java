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

import com.loja.dto.ProdutosDTO;
import com.loja.servico.ProdutoServico;

@RestController
@RequestMapping("/produto")
public class Controle {

    private final ProdutoServico produtoServico;

    public Controle(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    @GetMapping
    public List<ProdutosDTO> getAll() {
        return produtoServico.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosDTO> BuscarPorId(@PathVariable Long id) {
        return produtoServico.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProdutosDTO criar(@RequestBody ProdutosDTO produtosDTO) {
        return produtoServico.salvar(produtosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosDTO> atualizar(@PathVariable Long id, @RequestBody ProdutosDTO produtosDTO) {
        return produtoServico.listarPorId(id)
                .map(existing -> {
                    produtosDTO.setId(id);
                    return ResponseEntity.ok(produtoServico.salvar(produtosDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return produtoServico.listarPorId(id)
                .map(existing -> {
                    produtoServico.deletarProduto(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
}
