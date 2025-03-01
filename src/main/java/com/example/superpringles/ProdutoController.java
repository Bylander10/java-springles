package com.example.superpringles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    //Listar todos os produtos
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepositorio.findAll();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoRepositorio.findById(id).orElse(null);
    }

    // Adicionar produto
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return produtoRepositorio.save(produto);
    }

    //Atualizar produto
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        produtoAtualizado.setId(id);
        return produtoRepositorio.save(produtoAtualizado);
    }

    // Remover produto
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        produtoRepositorio.deleteById(id);
    }
}
