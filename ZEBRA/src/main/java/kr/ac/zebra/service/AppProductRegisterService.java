package kr.ac.zebra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.AppApplyDAO;

@Service
public class AppProductRegisterService {
	
	private AppApplyDAO appApplyDAO;
	
	@Autowired
	public void setAppApplyDAO(AppApplyDAO appApplyDAO){
		this.appApplyDAO = appApplyDAO;
	}
	
	public Boolean insertProduct(String id, String barcode, String productName){
		 return appApplyDAO.insertProduct(id, barcode, productName);
	}

}
