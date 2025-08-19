package com.loja.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.loja.dominio.produto.Produto;
import com.loja.dominio.repositorio.ProdutoRepositorio;
import com.loja.dto.ProdutosDTO;
import com.loja.execption.ProdutoNotFoundException;

@Service
public class ProdutoServico {

    private final ProdutoRepositorio produtoRepositorio;

    //instanciando repositrio para ultilizar seus metodos
    public ProdutoServico(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }


    
    public ProdutosDTO criarProduto(ProdutosDTO produtoDTO) {
        //transformar entidade produtoDTO em produtos
        Produto produto = toEntity(produtoDTO);
        produto = produtoRepositorio.save(produto);
        return toDTO(produto);
    }

    public ProdutosDTO salvar(ProdutosDTO produtoDTO) {
        Produto produto = toEntity(produtoDTO);
        produto = produtoRepositorio.save(produto);
        return toDTO(produto);
}
   
 public Optional<ProdutosDTO> listarPorId(Long id) {
    return produtoRepositorio.findById(id).map(this::toDTO);
}

    public List<ProdutosDTO> listarTodos() {
        return produtoRepositorio.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProdutosDTO atualizarProduto(Long id, ProdutosDTO produtoDTO) {
        Produto produto = produtoRepositorio.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setDescription(produtoDTO.getDescricao());
        produto = produtoRepositorio.save(produto);
        return toDTO(produto);
    }
    
    public void deletarProduto(Long id) {
        produtoRepositorio.deleteById(id);
    }

    private ProdutosDTO toDTO(Produto produto) {
        return new ProdutosDTO(produto.getId(), produto.getNome(), produto.getPreco(), produto.getDescription());
    }

    private Produto toEntity(ProdutosDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setDescription(produtoDTO.getDescricao());
        return produto;
    }
}

