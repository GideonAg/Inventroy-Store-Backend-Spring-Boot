package com.gideon.springsecurity.service;

import java.util.List;

import com.gideon.springsecurity.entity.ProductEntity;
import com.gideon.springsecurity.model.ProductModel;

import jakarta.validation.Valid;

public interface ProductService {

  String saveProduct(@Valid ProductModel productModel);

  List<ProductEntity> getAllProducts();

  String deleteProduct(Long id);

  List<ProductEntity> getProductsByName(String name);

  String updateProduct(Long id, ProductModel productModel);
}
