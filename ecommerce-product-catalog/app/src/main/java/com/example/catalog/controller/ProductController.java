package com.example.catalog.controller;

import com.example.catalog.model.Product;
import com.example.catalog.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Product> all() { return repo.findAll(); }

    @PostMapping
    public Product create(@RequestBody Product p) { return repo.save(p); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> one(@PathVariable Long id) {
        return repo.findById(id)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product update) {
        return repo.findById(id).map(p -> {
            p.setName(update.getName());
            p.setDescription(update.getDescription());
            p.setPrice(update.getPrice());
            p.setSku(update.getSku());
            p.setStock(update.getStock());
            return ResponseEntity.ok(repo.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repo.findById(id).map(p -> { 
            repo.delete(p); 
            return ResponseEntity.noContent().build(); 
        }).orElse(ResponseEntity.notFound().build());
    }
}
