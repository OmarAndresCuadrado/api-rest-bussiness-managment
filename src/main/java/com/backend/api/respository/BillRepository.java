package com.backend.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.backend.api.models.BillModel;

public interface BillRepository extends JpaRepository<BillModel, Long> {
	
	@Query(value = "select * from bills where (bills.client_id = ?1 and bills.id = ?2)", nativeQuery = true)
	public BillModel findBillByIdAndClientId(Long clientId, Long billId);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update products set products.amount = ?1 where id = ?2", nativeQuery = true)
	public void reduceItemsAmountById(Double newAmount, Long productId);


}
