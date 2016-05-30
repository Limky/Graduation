package kr.ac.zebra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.AppApplyDAO;
import kr.ac.zebra.dao.ProductDAO;
import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

@Service("managementService") // service로 bean에 등록시켜준다
public class ManagementService {
	
	private AppApplyDAO appApplyDAO;
	private ProductDAO productDAO;

	@Autowired // DI 주입
	public void setProductDAO(AppApplyDAO appApplyDAO,ProductDAO productDAO) {
	
		this.appApplyDAO = appApplyDAO;
		this.productDAO = productDAO;
	}


//-------------------------자사 상품--------------------------
	
	public List<AppApply> getApplys() {
		
		return appApplyDAO.getApplys();
		
	}
	
public boolean insertProduct(Product product) {
		
		
		if(productDAO.insert(product)){
			
			return true;
	
		}else{
					
			return false;
		}
		
				
	}
	

}
