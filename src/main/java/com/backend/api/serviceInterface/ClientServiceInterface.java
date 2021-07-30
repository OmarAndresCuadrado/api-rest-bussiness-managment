package com.backend.api.serviceInterface;

import java.util.List;

import com.backend.api.models.ClientModel;

public interface ClientServiceInterface {
	
	public List<ClientModel> listOfClients();
	
	public ClientModel findClientById(Long id);
	
	public ClientModel saveClient(ClientModel clientEntity);
	
	public void deleteClient(Long id);

}
