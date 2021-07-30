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

import com.backend.api.models.OwnerModel;
import com.backend.api.serviceInterface.OwnerServiceInterface;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class OwnerController {
	
	@Autowired
	OwnerServiceInterface ownerService;
	
	@GetMapping("/owner")
	public List<OwnerModel> listOfOwners(){
		return ownerService.listOfOwners();
	}
	
	@GetMapping("/owner/{id}")
	public OwnerModel findOwnerById(@PathVariable Long id){
		return ownerService.findOwnerById(id);
	}
	
	@PostMapping("/owner")
	public OwnerModel saveOwner(@RequestBody OwnerModel ownerEntity) {
		return ownerService.saveOwner(ownerEntity);
	}
	
	@PutMapping("/owner/{id}")
	public OwnerModel updateOwner(@RequestBody OwnerModel ownerEntity, @PathVariable Long id) {
		OwnerModel ownerDatabase = null;
		ownerDatabase = ownerService.findOwnerById(id);
		ownerDatabase.setAddress(ownerEntity.getAddress());
		ownerDatabase.setEmail(ownerEntity.getEmail());
		ownerDatabase.setLastName(ownerEntity.getLastName());
		ownerDatabase.setName(ownerEntity.getName());
		ownerDatabase.setPhone(ownerEntity.getPhone());
		ownerDatabase.setUsername(ownerEntity.getUsername());
		ownerDatabase.setPassword(ownerEntity.getPassword());
		return ownerService.saveOwner(ownerDatabase);
	}
	
	@DeleteMapping("/owner/{id}")
	public void deleteOwner(@PathVariable Long id) {
		ownerService.deleteOwner(id);
	}

}
