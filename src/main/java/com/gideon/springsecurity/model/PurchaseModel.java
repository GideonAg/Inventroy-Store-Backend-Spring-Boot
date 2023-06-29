package com.gideon.springsecurity.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PurchaseModel {
  @Column(nullable = false)
  private Long productId;
  @Min(value = 1)
  private int quantity;
  @NotBlank(message = "first name is required")
  private String vendorFirstName;
  @NotBlank(message = "last name is required")
  private String vendorLastName;
  @Email(message = "valid email is required")
  private String vendorEmail;
}
