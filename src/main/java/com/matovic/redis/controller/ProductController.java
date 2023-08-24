package com.matovic.redis.controller;

import com.matovic.redis.entity.Product;
import com.matovic.redis.repository.ProductDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductDao productDao;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productDao.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return productDao.findAll();
    }

    @GetMapping("{id}")
    public Product findProduct(@PathVariable Long id) {
        return productDao.findProductById(id);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productDao.deleteProduct(id);
    }
}
