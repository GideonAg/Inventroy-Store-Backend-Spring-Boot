package com.gideon.springsecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gideon.springsecurity.entity.VendorsEntity;
import com.gideon.springsecurity.service.VendorService;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {

  private final VendorService vendorService;

  public VendorController(VendorService vendorService) {
    this.vendorService = vendorService;
  }

  @GetMapping("")
  public List<VendorsEntity> getAllVendors() {
    return vendorService.getAllVendors();
  }
}
