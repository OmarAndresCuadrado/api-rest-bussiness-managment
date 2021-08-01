package com.backend.api.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.api.models.BusinessModel;
import com.backend.api.respository.BusinessRepository;
import com.backend.api.serviceInterface.BusinessServiceInterface;

@Service
public class BusinessServiceImp implements BusinessServiceInterface {

	@Autowired
	BusinessRepository businessDao;

	@Override
	@Transactional(readOnly = true)
	public List<BusinessModel> listOfBussiness() {
		return businessDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public BusinessModel findBusinessById(Long id) {
		return businessDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public BusinessModel saveBusiness(BusinessModel businessEntity) {
		return businessDao.save(businessEntity);
	}

	@Override
	@Transactional
	public void deleteBusiness(Long id) {
		businessDao.deleteById(id);

	}

}
