package it.vscalcione.springboot.demoapplication.service;

import it.vscalcione.springboot.demoapplication.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);
}
