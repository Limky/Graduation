package kr.ac.zebra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.ProductDAO;
import kr.ac.zebra.dto.Product;

@Service
public class AppProductSearchService {
	
	private ProductDAO productDAO;
	
	@Autowired
	public void setProductDAO(ProductDAO productDAO){
		this.productDAO = productDAO;
	}
	
	public List<Product> getProductSearch(String keyword){
		System.out.println("service");
		
		return productDAO.getSearchProduct(keyword);
	}

}
