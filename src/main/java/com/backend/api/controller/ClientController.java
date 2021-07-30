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

import com.backend.api.models.ClientModel;
import com.backend.api.serviceInterface.ClientServiceInterface;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	ClientServiceInterface clientService;
	
	@GetMapping("/client")
	public List<ClientModel> listOfClients(){
		return clientService.listOfClients();
	}
	
	@GetMapping("/client/{id}")
	public ClientModel findClientById(@PathVariable Long id) {
		return clientService.findClientById(id);
	}
	
	@PostMapping("/client")
	public ClientModel saveClient(@RequestBody ClientModel clientEntity) {
		return clientService.saveClient(clientEntity);
	}
	
	@PutMapping("/client/{id}")
	public ClientModel updateClient(@RequestBody ClientModel clientEntity, @PathVariable Long id) {
		ClientModel clientDatabase = null;
		clientDatabase = clientService.findClientById(id);
		clientDatabase.setAddress(clientEntity.getAddress());
		clientDatabase.setEmail(clientEntity.getEmail());
		clientDatabase.setName(clientEntity.getName());
		clientDatabase.setLastName(clientEntity.getLastName());
		clientDatabase.setPhone(clientEntity.getPhone());
		clientDatabase.setPoints(clientEntity.getPoints());
		clientDatabase.setPrivilages(clientEntity.getPrivilages());
		return clientService.saveClient(clientDatabase);
		
	}
	
	@DeleteMapping("/client/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
	}
	

}
