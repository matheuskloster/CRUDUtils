package com.kloster.produto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoDtoService;

    @GetMapping
    public List<Produto> getAll() {
        return produtoDtoService.getAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id) {
        return produtoDtoService.getById(id);
    }

    @PostMapping
    public Produto create(@RequestBody Produto produtoDto) {
        return produtoDtoService.create(produtoDto);
    }

    @PutMapping
    public Produto update(@RequestBody Produto produtoDto) {
        return produtoDtoService.update(produtoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoDtoService.delete(id);
    }
}