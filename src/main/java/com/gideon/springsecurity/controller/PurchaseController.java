package com.gideon.springsecurity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gideon.springsecurity.entity.PurchaseEntity;
import com.gideon.springsecurity.model.PurchaseModel;
import com.gideon.springsecurity.service.PurchaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

  private final PurchaseService purchaseService;

  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @PostMapping("")
  public ResponseEntity<String> savePurchase(@Valid @RequestBody PurchaseModel purchaseModel) {
    return ResponseEntity.ok().body(purchaseService.savePurchase(purchaseModel));
  }

  @GetMapping("")
  public List<PurchaseEntity> getAllPurchase() {
    return purchaseService.getAllPurchase();
  }
}
