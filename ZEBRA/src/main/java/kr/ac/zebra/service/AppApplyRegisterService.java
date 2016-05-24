package kr.ac.zebra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.AppApplyDAO;
import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

@Service
public class AppApplyRegisterService {
	private AppApplyDAO appApplyDAO;

	@Autowired
	public void setApplyDAO(AppApplyDAO appApplyDAO) {
		this.appApplyDAO = appApplyDAO;

	}

	public AppApply getApply(String barcode) {
		System.out.println("AppApply Service");

		AppApply apply = appApplyDAO.getApply(barcode);

		if (apply == null) {

			return null;
		} else {

			return apply;
		}
	}

}
