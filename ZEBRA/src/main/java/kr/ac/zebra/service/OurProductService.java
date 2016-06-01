package kr.ac.zebra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.ac.zebra.dao.OurProductDAO;
import kr.ac.zebra.dto.Product;

@Service("ourProductService") // service로 bean에 등록시켜준다
public class OurProductService {
	
	private OurProductDAO ourProductDAO;

	@Autowired // DI 주입
	public void setProductDAO(OurProductDAO ourProductDAO) {
	
		this.ourProductDAO = ourProductDAO;
	}


//-------------------------자사 상품--------------------------
	
	public List<Product> getOurAllProducts(String companyName) {
		
		return ourProductDAO.getOurAllProducts(companyName);
		
	}
	
	public List<Product> getOurPopularityProducts(String companyName) {
		
		return ourProductDAO.getOurPopularityProducts(companyName);
		
	}
	
	public List<Product> getOurMostReviewProducts(String companyName) {
		
		return ourProductDAO.getOurMostReviewProducts(companyName);
		
	}
	
	public List<Product> getOurMostScanProducts(String companyName) {
		
		return ourProductDAO.getOurMostScanProducts(companyName);
		
	}
	
	public List<Integer> getCompanyCount(String companyName){
		
				
		return ourProductDAO.getCompanyCount(companyName);		
		
	}
	
	
	
	

	

}
