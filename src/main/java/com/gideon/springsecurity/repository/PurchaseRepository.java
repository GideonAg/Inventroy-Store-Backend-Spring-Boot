package com.gideon.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gideon.springsecurity.entity.PurchaseEntity;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {

}
