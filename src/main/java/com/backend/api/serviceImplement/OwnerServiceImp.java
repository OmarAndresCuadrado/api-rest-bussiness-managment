package com.backend.api.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.api.models.OwnerModel;
import com.backend.api.respository.OwnerRepository;
import com.backend.api.serviceInterface.OwnerServiceInterface;

@Service
public class OwnerServiceImp implements OwnerServiceInterface {

	@Autowired
	OwnerRepository ownerDao;

	@Override
	public List<OwnerModel> listOfOwners() {
		return ownerDao.findAll();
	}

	@Override
	public OwnerModel findOwnerById(Long id) {
		return ownerDao.findById(id).orElse(null);
	}

	@Override
	public OwnerModel saveOwner(OwnerModel ownerEntity) {
		return ownerDao.save(ownerEntity);
	}

	@Override
	public void deleteOwner(Long id) {
		ownerDao.deleteById(id);

	}

}
