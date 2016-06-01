package kr.ac.zebra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.AppApplyDAO;
import kr.ac.zebra.dao.ApplyDAO;
import kr.ac.zebra.dao.MemberDAO;
import kr.ac.zebra.dao.ProductDAO;
import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

@Service("managementService") // service로 bean에 등록시켜준다
public class ManagementService {

	private ApplyDAO ApplyDAO;
	private ProductDAO productDAO;
	private MemberDAO MemberDAO;

	@Autowired // DI 주입
	public void setProductDAO(ApplyDAO ApplyDAO, ProductDAO productDAO, MemberDAO MemberDAO) {

		this.ApplyDAO = ApplyDAO;
		this.productDAO = productDAO;
		this.MemberDAO=MemberDAO;
	}

	// -------------------------자사 상품--------------------------

	public List<AppApply> getApplys() {

		return ApplyDAO.getApplys();

	}

	public boolean insertProduct(Product product) {

		if (productDAO.insert(product)) {

			return true;

		} else {

			return false;
		}

	}
	
	public boolean increasePoint(String id) {

		if(MemberDAO.increaseMemberPoint(id)) return true;
			
		return false;

	}
	
	
	public boolean decreasePoint(String id) {

		if(MemberDAO.decreaseMemberPoint(id)) return true;
			
		return false;

	}
	
	public boolean DeleteApplyTb(String barcode) {

		if(ApplyDAO.DeleteApplyTb(barcode)) return true;
			
		return false;

	}
	

}
