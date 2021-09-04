package it.vscalcione.springboot.demoapplication.service;

import it.vscalcione.springboot.demoapplication.exception.ResourceNotFoundException;
import it.vscalcione.springboot.demoapplication.model.Product;
import it.vscalcione.springboot.demoapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Long id = product.getId();
        Optional<Product> productToUpdate = this.productRepository.findById(id);
        if (productToUpdate.isPresent()) {
            Product updatedProduct = productToUpdate.get();
            updatedProduct.setId(product.getId());
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            productRepository.save(updatedProduct);
            return updatedProduct;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isPresent())
            return product.get();
        else
            throw new ResourceNotFoundException("Record not found with id: " + id);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productToDelete = this.productRepository.findById(id);
        if (productToDelete.isPresent())
            this.productRepository.delete(productToDelete.get());
        else
            throw new ResourceNotFoundException("Record not found with id: " + id);
    }
}
