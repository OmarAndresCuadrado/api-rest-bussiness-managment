package com.backend.api.serviceInterface;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.backend.api.models.BillModel;

public interface BillServiceInterface {

	/**
	 * 
	 * @return
	 */
	public List<BillModel> listOfBills();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public BillModel findByIdBill(Long id);

	/**
	 * 
	 * @param billEntity
	 * @return
	 */
	public BillModel saveBill(BillModel billEntity);

	/**
	 * 
	 * @param id
	 */
	public void deleteBill(Long id);

	/**
	 * 
	 * @param clientId
	 * @param billId
	 * @return
	 */
	public BillModel findBillByIdAndClientId(Long clientId, Long billId);

	/**
	 * 
	 * @param newAmount
	 * @param productId
	 */
	public void reduceItemsAmountById(Double newAmount, Long productId);

	/**
	 * 
	 * @param bill
	 * @return
	 */
	public ByteArrayInputStream pdfOfBills(BillModel bill);
}
