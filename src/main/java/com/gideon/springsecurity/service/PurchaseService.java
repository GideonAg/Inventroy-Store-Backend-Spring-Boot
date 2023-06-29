package com.gideon.springsecurity.service;

import java.util.List;

import com.gideon.springsecurity.entity.PurchaseEntity;
import com.gideon.springsecurity.model.PurchaseModel;

public interface PurchaseService {

  String savePurchase(PurchaseModel purchaseModel);

  List<PurchaseEntity> getAllPurchase();

}
