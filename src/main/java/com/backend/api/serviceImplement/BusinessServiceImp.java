package com.backend.api.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.api.models.BusinessModel;
import com.backend.api.respository.BusinessRepository;
import com.backend.api.serviceInterface.BusinessServiceInterface;

@Service
public class BusinessServiceImp implements BusinessServiceInterface {

	@Autowired
	BusinessRepository businessDao;

	@Override
	public List<BusinessModel> listOfBussiness() {
		return businessDao.findAll();
	}

	@Override
	public BusinessModel findBusinessById(Long id) {
		return businessDao.findById(id).orElse(null);
	}

	@Override
	public BusinessModel saveBusiness(BusinessModel businessEntity) {
		return businessDao.save(businessEntity);
	}

	@Override
	public void deleteBusiness(Long id) {
		businessDao.deleteById(id);

	}

}
