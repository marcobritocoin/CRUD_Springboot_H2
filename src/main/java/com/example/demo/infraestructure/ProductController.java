package com.example.demo.infraestructure;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.application.ProductRepository;
import com.example.demo.domain.Product;
import com.example.demo.exception.ProductNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController()
@RequestMapping("/products")
public class ProductController {

    @Autowired // Instancia precargada que se inyecta en el codigo para no hacer NEW CLASS
    public ProductRepository productRepository;

    // GET para obtener
    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // Busqueda por ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    // Busqueda por NOMBRE
    @GetMapping("/name")
    public List<Product> getProductsByName(@RequestParam String name){
        List<Product> products = productRepository.findByNameContaining(name);
        if(products.isEmpty()){
            throw new ProductNotFoundException(name);
        }
        return productRepository.findByNameContaining(name);
    }

    // POST para crear/insertar
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // PUT para actualizar
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);
    }

    // DELETE para eliminar
    @DeleteMapping("/{id}")
    public Map<String, String> deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(product);

        // Responder con un JSON
        Map<String, String> response = new HashMap<>();
        response.put("message", "Producto eliminado: " + id);
        return response;
    }
}
