package com.backend.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.api.models.BusinessModel;

public interface BusinessRepository extends JpaRepository<BusinessModel, Long> {

}
