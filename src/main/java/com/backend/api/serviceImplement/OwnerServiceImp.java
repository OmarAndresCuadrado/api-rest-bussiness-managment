package com.backend.api.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.api.models.OwnerModel;
import com.backend.api.respository.OwnerRepository;
import com.backend.api.serviceInterface.OwnerServiceInterface;

@Service
public class OwnerServiceImp implements OwnerServiceInterface {

	@Autowired
	OwnerRepository ownerDao;

	@Override
	@Transactional(readOnly = true)
	public List<OwnerModel> listOfOwners() {
		return ownerDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public OwnerModel findOwnerById(Long id) {
		return ownerDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public OwnerModel saveOwner(OwnerModel ownerEntity) {
		return ownerDao.save(ownerEntity);
	}

	@Override
	@Transactional
	public void deleteOwner(Long id) {
		ownerDao.deleteById(id);

	}

}
