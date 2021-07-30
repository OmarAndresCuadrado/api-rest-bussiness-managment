package com.backend.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.api.models.ClientModel;



public interface ClientRepository extends JpaRepository<ClientModel, Long> {

}
