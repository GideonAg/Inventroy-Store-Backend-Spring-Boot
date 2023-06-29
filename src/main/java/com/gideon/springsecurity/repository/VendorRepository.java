package com.gideon.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gideon.springsecurity.entity.VendorsEntity;

@Repository
public interface VendorRepository extends JpaRepository<VendorsEntity, Long> {

}
