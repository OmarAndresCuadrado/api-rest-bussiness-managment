package com.backend.api.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.api.models.ClientModel;
import com.backend.api.respository.ClientRepository;
import com.backend.api.serviceInterface.ClientServiceInterface;

@Service
public class ClientServiceImp implements ClientServiceInterface {
	
	@Autowired
	ClientRepository clientDao;

	@Override
	@Transactional(readOnly = true)
	public List<ClientModel> listOfClients() {
		return clientDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ClientModel findClientById(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ClientModel saveClient(ClientModel clientEntity) {
		return clientDao.save(clientEntity);
	}

	@Override
	@Transactional
	public void deleteClient(Long id) {
		clientDao.deleteById(id);
		
	}

}
