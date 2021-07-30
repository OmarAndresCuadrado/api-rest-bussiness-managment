package com.backend.api.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.api.models.ClientModel;
import com.backend.api.respository.ClientRepository;
import com.backend.api.serviceInterface.ClientServiceInterface;

@Service
public class ClientServiceImp implements ClientServiceInterface {
	
	@Autowired
	ClientRepository clientDao;

	@Override
	public List<ClientModel> listOfClients() {
		return clientDao.findAll();
	}

	@Override
	public ClientModel findClientById(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	public ClientModel saveClient(ClientModel clientEntity) {
		return clientDao.save(clientEntity);
	}

	@Override
	public void deleteClient(Long id) {
		clientDao.deleteById(id);
		
	}

}
