package com.backend.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.api.models.BusinessModel;
import com.backend.api.serviceInterface.BusinessServiceInterface;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class BusinessController {

	@Autowired
	BusinessServiceInterface businessService;

	@GetMapping("/business")
	public List<BusinessModel> listOfBusiness() {
		return businessService.listOfBussiness();
	}

	@GetMapping("/business/{id}")
	public BusinessModel findBusinessById(@PathVariable Long id) {
		return businessService.findBusinessById(id);
	}

	@PostMapping("/business")
	public BusinessModel saveBusiness(@RequestBody BusinessModel businessEntity) {
		return businessService.saveBusiness(businessEntity);
	}
	
	@PutMapping("/business/{id}")
	public BusinessModel updateBusiness(@RequestBody BusinessModel businessEntity, @PathVariable Long id) {
		BusinessModel businessDatabase = null;
		businessDatabase = businessService.findBusinessById(id);
		businessDatabase.setName(businessEntity.getName());
		businessDatabase.setPhone(businessEntity.getPhone());
		businessDatabase.setAddress(businessEntity.getAddress());
		return businessService.saveBusiness(businessDatabase);
	}
	
	@DeleteMapping("/business/{id}")
	public void deleteBusiness(@PathVariable Long id) {
		businessService.deleteBusiness(id);
	}
	
}
