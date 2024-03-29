package com.kloster.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {


    private final ProdutoRepository repository;


    public List<Produto> getAll() {
        return repository.findAll();
    }

    public Produto getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto create(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Produto produto) {
        return repository.save(produto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}