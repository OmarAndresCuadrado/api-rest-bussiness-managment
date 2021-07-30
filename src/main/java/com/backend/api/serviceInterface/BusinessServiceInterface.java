package com.backend.api.serviceInterface;

import java.util.List;

import com.backend.api.models.BusinessModel;

public interface BusinessServiceInterface {
	
	public List<BusinessModel> listOfBussiness();
	
	public BusinessModel findBusinessById(Long id);
	
	public BusinessModel saveBusiness(BusinessModel businessEntity);
	
	public void deleteBusiness(Long id);

}
