package com.backend.api.serviceImplement;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.api.models.BillModel;
import com.backend.api.respository.BillRepository;
import com.backend.api.serviceInterface.BillServiceInterface;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class BillServiceImp implements BillServiceInterface {

	@Autowired
	private BillRepository billDao;

	@Override
	@Transactional(readOnly = true)
	public List<BillModel> listOfBills() {
		return billDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public BillModel findByIdBill(Long id) {
		return billDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public BillModel saveBill(BillModel billEntity) {
		return billDao.save(billEntity);
	}

	@Override
	@Transactional
	public void deleteBill(Long id) {
		billDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public BillModel findBillByIdAndClientId(Long clientId, Long billId) {
		return billDao.findBillByIdAndClientId(clientId, billId);
	}

	@Override
	@Transactional
	public void reduceItemsAmountById(Double newAmount, Long productId) {
		billDao.reduceItemsAmountById(newAmount, productId);
	}

	@Override
	@Transactional(readOnly = true)
	public ByteArrayInputStream pdfOfBills(BillModel bill) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, out);
			document.open();

			// add text to pdf file
			Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
			Paragraph paragraphUno = new Paragraph("products List", font);
			paragraphUno.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphUno);
			document.add(Chunk.NEWLINE);
			
			// Create a table
			PdfPTable table = new PdfPTable(2); //numero de columnas de la tabla
			
			document.add(table);
			document.close();
			

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
}
