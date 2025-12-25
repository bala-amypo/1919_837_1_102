package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    // Used in WarrantyServiceImpl.getUserWarranties()
    List<Warranty> findByUserId(Long userId);

    // Used in alert scheduler / alert service
    List<Warranty> findByExpiryDateBetween(LocalDate start, LocalDate end);

    // Used during warranty registration
    boolean existsBySerialNumber(String serialNumber);
}
