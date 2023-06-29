package com.gideon.springsecurity.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseEntity {
  @Id
  @SequenceGenerator(name = "purchase_sequence", sequenceName = "purchase_sequence", allocationSize = 1)
  @GeneratedValue(generator = "purchase_sequence", strategy = GenerationType.SEQUENCE)
  private Long id;
  private String productName;
  private int quantity;
  private int cost;

  @Embedded
  private Vendor vendor;
}
