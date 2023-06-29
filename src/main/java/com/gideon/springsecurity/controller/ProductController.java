package com.gideon.springsecurity.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gideon.springsecurity.entity.ProductEntity;
import com.gideon.springsecurity.model.ProductModel;
import com.gideon.springsecurity.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("")
  public ResponseEntity<String> saveProduct(@Valid @RequestBody ProductModel productModel) {
    return ResponseEntity.status(HttpStatus.OK).body(productService.saveProduct(productModel));
  }

  @GetMapping("")
  public List<ProductEntity> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{name}")
  public List<ProductEntity> getProductsByName(@PathVariable("name") String name) {
    return productService.getProductsByName(name);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateProduct(@PathVariable("id") Long id,
      @RequestBody ProductModel productModel) {
    return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, productModel));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
  }
}
