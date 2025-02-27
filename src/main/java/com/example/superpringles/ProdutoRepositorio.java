package com.example.superpringles;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepositorio {

    private List<Produto> produtos = new ArrayList<>();
    private Long proximoId = 1L;

    // Metodo para listar os produtos
    public List<Produto> listarTodos() {
        return produtos;
    }

    // Metodo pra buscar produto por id
    public Produto buscarPorId(Long id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }

    // Metodo adicionar produto
    public Produto adicionar(Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
        return produto;
    }

    // Metodo atualizar produto
    public Produto atualizar(Produto produtoAtualizado) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(produtoAtualizado.getId())) {
                produto.setNome(produtoAtualizado.getNome());
                produto.setPreco(produtoAtualizado.getPreco());
                return produto;
            }
        }
        return null;
    }

    // Metodo remover produto
    public void remover(Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }
}
