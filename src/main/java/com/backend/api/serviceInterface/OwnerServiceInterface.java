package com.backend.api.serviceInterface;

import java.util.List;

import com.backend.api.models.OwnerModel;

public interface OwnerServiceInterface {
	
	public List<OwnerModel> listOfOwners();
	
	public OwnerModel findOwnerById(Long id);
	
	public OwnerModel saveOwner(OwnerModel ownerEntity);
	
	public void deleteOwner(Long id);

}
