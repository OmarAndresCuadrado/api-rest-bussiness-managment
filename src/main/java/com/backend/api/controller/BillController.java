package com.backend.api.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.api.models.BillModel;
import com.backend.api.serviceInterface.BillServiceInterface;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class BillController {

	@Autowired
	private BillServiceInterface billService;

	@GetMapping("/bill")
	public List<BillModel> listOfBills() {
		return billService.listOfBills();
	}

	@GetMapping("/bill/{id}")
	public BillModel findByIdBill(@PathVariable Long id) {
		return billService.findByIdBill(id);
	}

	@PostMapping("/bill")
	public BillModel saveBill(@RequestBody BillModel billEntity) {

		billEntity.getItems().forEach((resp) -> {
			Double totalProductAmount = resp.getProduct().getAmount();
			Double productAmountOfBill = Double.valueOf(resp.getAmount());
			Double newAmountForProduct = (totalProductAmount - productAmountOfBill);
			System.out.println("nuevo valor " + newAmountForProduct);
			// Hacer un servicio para un update
			billService.reduceItemsAmountById(newAmountForProduct, resp.getProduct().getId());
		});
		return billService.saveBill(billEntity);
	}

	@PutMapping("/bill/{id}")
	public BillModel updateBill(@RequestBody BillModel billEntity, @PathVariable Long id) {
		BillModel billDatabase = null;
		billDatabase = billService.findByIdBill(id);
		return billService.saveBill(billDatabase);
	}

	@DeleteMapping("/bill/{id}")
	public void deleteBill(@PathVariable Long id) {
		billService.deleteBill(id);
	}

	@GetMapping("/bill-client/{clientId}/{billId}")
	public BillModel findBillByIdAndClientId(@PathVariable Long clientId, @PathVariable Long billId) {
		return billService.findBillByIdAndClientId(clientId, billId);
	}

	@GetMapping(value = "/export/pdf/{clientId}/{billId}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> createPdfOfBill(@PathVariable Long clientId, @PathVariable Long billId) {
		BillModel billFound = billService.findBillByIdAndClientId(clientId, billId);
		ByteArrayInputStream bais = billService.pdfOfBills(billFound);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=billFound.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bais));
	}
	
	
	@PostMapping("/cliente/upload/documentouno")
	public void uploadDocumentUno(@RequestParam("files") MultipartFile files) {
		
				
				
	}
	
}
