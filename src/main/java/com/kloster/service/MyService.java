package com.kloster.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyService {

    private final PropertyLoader propertyLoader;

    public String getNome() {
      return propertyLoader.getNome();
    }
}
