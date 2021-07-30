package com.backend.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.api.models.OwnerModel;

public interface OwnerRepository extends JpaRepository<OwnerModel, Long> {
}
