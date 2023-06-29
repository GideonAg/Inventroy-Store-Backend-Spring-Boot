package com.gideon.springsecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class ProductEntity {

  @Id
  @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
  private Long id;
  @NotBlank(message = "Product name is required")
  private String name;
  @Min(value = 0, message = "Price of product can not be negative")
  private int quantity;
  @Min(value = 0, message = "Price of product can not be negative")
  private int price;
}
