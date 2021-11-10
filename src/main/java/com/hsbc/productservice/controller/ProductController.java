package com.hsbc.productservice.controller;

import com.hsbc.productservice.dto.ProductDetailDto;
import com.hsbc.productservice.dto.ProductTileDto;
import com.hsbc.productservice.exception.ActionFailureException;
import com.hsbc.productservice.dto.AddProduct;
import com.hsbc.productservice.service.ProductService;
import domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping()
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Response<ProductTileDto>> getAllProducts(){
        Response<ProductTileDto> response = new Response<>();
        response.setData(productService.getAllProducts());
        response.setSuccessMessage("Success");
        response.setStatusCode("Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addproduct")
    public void addProduct(@RequestBody AddProduct product) throws ActionFailureException {
        productService.addProduct(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Response<ProductDetailDto>> getProduct(@PathVariable int id){
        Response<ProductDetailDto> response = new Response<>();
        response.setData(Collections.singletonList(productService.getProduct(id)));
        response.setSuccessMessage("Success");
        response.setStatusCode("Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    @Transactional
    public void removeProduct(@PathVariable int id) throws ActionFailureException {
        productService.removeProduct(id);
    }

}