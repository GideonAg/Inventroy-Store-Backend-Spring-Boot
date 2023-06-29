package com.gideon.springsecurity.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gideon.springsecurity.entity.ProductEntity;
import com.gideon.springsecurity.entity.PurchaseEntity;
import com.gideon.springsecurity.entity.Vendor;
import com.gideon.springsecurity.entity.VendorsEntity;
import com.gideon.springsecurity.model.PurchaseModel;
import com.gideon.springsecurity.repository.ProductRepository;
import com.gideon.springsecurity.repository.PurchaseRepository;
import com.gideon.springsecurity.repository.VendorRepository;
import com.gideon.springsecurity.service.PurchaseService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

  private final PurchaseRepository purchaseRepository;
  private final VendorRepository vendorRepository;
  private final ProductRepository productRepository;

  public PurchaseServiceImpl(PurchaseRepository purchaseRepository,
      VendorRepository vendorRepository,
      ProductRepository productRepository) {
    this.purchaseRepository = purchaseRepository;
    this.vendorRepository = vendorRepository;
    this.productRepository = productRepository;
  }

  @Override
  public String savePurchase(PurchaseModel purchaseModel) {
    Optional<ProductEntity> product = productRepository.findById(purchaseModel.getProductId());
    if (product.isPresent()) {
      if (purchaseModel.getQuantity() > product.get().getQuantity())
        return "insufficent product in stock";

      product.get().setQuantity(product.get().getQuantity() - purchaseModel.getQuantity());
      productRepository.save(product.get());

      VendorsEntity vendorsEntity = VendorsEntity.builder().firstName(purchaseModel.getVendorFirstName())
          .lastName(purchaseModel.getVendorLastName())
          .email(purchaseModel.getVendorEmail())
          .build();
      vendorRepository.save(vendorsEntity);

      Vendor vendor = new Vendor(purchaseModel.getVendorEmail(), purchaseModel.getVendorFirstName());

      PurchaseEntity purchaseEntity = PurchaseEntity.builder()
          .productName(product.get().getName())
          .quantity(purchaseModel.getQuantity())
          .cost(purchaseModel.getQuantity() * product.get().getPrice())
          .vendor(vendor)
          .build();
      purchaseRepository.save(purchaseEntity);
      return "product purchase was successfull";
    }

    return "invalid product id";
  }

  @Override
  public List<PurchaseEntity> getAllPurchase() {
    return purchaseRepository.findAll(Sort.by("productName"));
  }

}
