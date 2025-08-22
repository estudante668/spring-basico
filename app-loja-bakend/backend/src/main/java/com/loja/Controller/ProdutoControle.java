package com.loja.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.loja.produto.Produto;
import com.loja.servico.ProdutoServicos;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoControle {

    private final ProdutoServicos produtoServicos;

    public ProdutoControle(ProdutoServicos produtoServicos) {
        this.produtoServicos = produtoServicos;
    }

    //Buscar todos produtos
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoServicos.findAll();
    }

    //Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return produtoServicos.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Criar um novo produto
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoServicos.save(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    //Atualizar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        try {
            Produto produtoExistente = produtoServicos.update(id, produtoAtualizado);
            return ResponseEntity.ok(produtoExistente);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Deletar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        try {
            produtoServicos.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

