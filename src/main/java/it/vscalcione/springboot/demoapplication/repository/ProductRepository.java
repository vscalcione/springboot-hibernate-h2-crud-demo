package it.vscalcione.springboot.demoapplication.repository;

import it.vscalcione.springboot.demoapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
