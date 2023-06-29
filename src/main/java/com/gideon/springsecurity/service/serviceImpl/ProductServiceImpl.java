package com.gideon.springsecurity.service.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gideon.springsecurity.entity.ProductEntity;
import com.gideon.springsecurity.model.ProductModel;
import com.gideon.springsecurity.repository.ProductRepository;
import com.gideon.springsecurity.service.ProductService;

import jakarta.validation.Valid;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public String saveProduct(@Valid ProductModel productModel) {
    ProductEntity product = ProductEntity.builder().name(productModel.getName()).price(productModel.getPrice())
        .quantity(productModel.getQuantity()).build();

    productRepository.save(product);
    return "success";
  }

  @Override
  public List<ProductEntity> getAllProducts() {
    return productRepository.findAll(Sort.by("name"));
  }

  @Override
  public String deleteProduct(Long id) {
    Optional<ProductEntity> product = productRepository.findById(id);
    if (product.isPresent()) {
      productRepository.delete(product.get());
      return "deleted successfuly";
    }
    return "no product with id: " + id;
  }

  @Override
  public List<ProductEntity> getProductsByName(String name) {
    return productRepository.findByNameContaining(name);
  }

  @Override
  public String updateProduct(Long id, ProductModel productModel) {
    Optional<ProductEntity> product = productRepository.findById(id);

    if (product.isPresent()) {
      if (Objects.nonNull(productModel.getName()) && !"".equalsIgnoreCase(productModel.getName())) {
        product.get().setName(productModel.getName());
      }
      if (productModel.getPrice() >= 0) {
        product.get().setPrice(productModel.getPrice());
      }
      if (productModel.getQuantity() >= 0) {
        product.get().setQuantity(productModel.getQuantity());
      }

      productRepository.save(product.get());
      return "product updated";
    }

    return "invalid product id: " + id;
  }

}
