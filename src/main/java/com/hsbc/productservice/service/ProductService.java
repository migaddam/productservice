package com.hsbc.productservice.service;

import com.hsbc.productservice.dto.ProductDetailDto;
import com.hsbc.productservice.dto.ProductTileDto;
import com.hsbc.productservice.exception.ActionFailureException;
import com.hsbc.productservice.dto.AddProduct;
import com.hsbc.productservice.model.Product;
import com.hsbc.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @CachePut(value = "getAllProduct")
    public List<ProductTileDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().
                map((product -> new ProductTileDto(product.getId(), product.getName(), product.getPricePerUnit(), product.getImageUrl(), product.getOriginalPricePerUnit())))
                .collect(Collectors.toList());
    }

    @Cacheable(value = "getProduct",key = "#id")
    public ProductDetailDto getProduct(int id){
        Product product = productRepository.findById(id).orElse(null);
        if(product==null) return null;
        return new ProductDetailDto(product.getId(), product.getName(), product.getDescription(), product.getPricePerUnit(), product.getImageUrl(), product.getOriginalPricePerUnit());
    }

    public void addProduct(AddProduct product) throws ActionFailureException {
        Product p = new Product();
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setCreatedBy(product.getCreatedBy());
        p.setImageUrl(product.getImageUrl());
        p.setModifiedBy(product.getModifiedBy());
        p.setOriginalPricePerUnit(product.getOriginalPricePerUnit());
        p.setStock(product.getStock());
        p.setPricePerUnit(product.getPricePerUnit());
        p.setOriginalStock(product.getOriginalStock());

        try {
            productRepository.save(p);
        } catch (Exception e) {
            throw new ActionFailureException(e.getMessage());
        }
    }

    public void removeProduct(int id) throws ActionFailureException {
        try {
            productRepository.deleteById(id);
        }catch (Exception e){
            throw new ActionFailureException(e.getMessage());
        }
    }
}
