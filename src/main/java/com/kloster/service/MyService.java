package com.kloster.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    private final PropertyLoaderService propertyLoader;

    public String getNome() {
        return propertyLoader.getNome();
    }

    public int getIdade() {
        return propertyLoader.getIdade();
    }
}
