package com.hsbc.productservice.repository;

import com.hsbc.productservice.dto.AddProduct;
import com.hsbc.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.stock>0")
    public List<Product> findAll();

}
