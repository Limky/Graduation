package kr.ac.zebra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.MemberDAO;
import kr.ac.zebra.dao.ProductDAO;
import kr.ac.zebra.dto.Member;
import kr.ac.zebra.dto.Product;

@Service("productService") // service로 bean에 등록시켜준다
public class ProductService {
	

	private ProductDAO productDAO;
	private MemberDAO memberDAO;
	@Autowired // DI 주입
	public void setProductDAO(ProductDAO productDAO,MemberDAO memberDAO) {
		this.productDAO = productDAO;
		this.memberDAO = memberDAO;

	}

	public Product getProduct(String barcode){
		
		return productDAO.getProduct(barcode);
	}
	
	
	public List<Product> getPopularProducts(String category) {
	
		return productDAO.getPopularProducts(category);
		
	}

	public List<Product> getMostReviewProducts(String category) {
		
		return productDAO.getMostReviewProducts(category);
		
	}

	public List<Product> getMostScanProducts(String category) {
		
		return productDAO.getMostScanProducts(category);
		
	}


	

}
