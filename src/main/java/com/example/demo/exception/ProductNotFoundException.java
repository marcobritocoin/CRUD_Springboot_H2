package com.example.demo.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String text) {
        super("Producto con la palabra clave "+ text + " no encontrado");
    }

    public ProductNotFoundException(Long id) {
        super("Producto con id " + id + " no encontrado");
    }
}
