package com.gideon.springsecurity.service.serviceImpl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import com.gideon.springsecurity.entity.VendorsEntity;
import com.gideon.springsecurity.repository.VendorRepository;
import com.gideon.springsecurity.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

  private final VendorRepository vendorRepository;

  public VendorServiceImpl(VendorRepository vendorRepository) {
    this.vendorRepository = vendorRepository;
  }

  @Override
  public List<VendorsEntity> getAllVendors() {
    return vendorRepository.findAll(Sort.by("firstName"));
  }
}
