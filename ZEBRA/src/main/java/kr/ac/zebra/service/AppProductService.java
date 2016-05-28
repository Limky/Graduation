package kr.ac.zebra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.AppApplyDAO;
import kr.ac.zebra.dao.AppProductDAO;
import kr.ac.zebra.dao.ProductDAO;
import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

@Service("appProductService") // service로 bean에 등록시켜준다
public class AppProductService {

	private AppProductDAO productDAO;
	private AppApplyDAO appApplyDAO;

	@Autowired
	public void setProductDAO(AppProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Autowired
	public void setAppApplyDAO(AppApplyDAO appApplyDAO) {
		this.appApplyDAO = appApplyDAO;
	}

	public Product getProduct(String barcode) {

		System.out.println("Product Service");

		Product product = productDAO.getProduct(barcode);

		if (product == null) {

			return null;
		} else {

			return product;
		}
	}

	public Boolean insertProduct(String id, String barcode, String productName) {

		return appApplyDAO.insertProduct(id, barcode, productName);
	}

	public List<Product> getProductSearch(String keyword) {

		return productDAO.getSearchProduct(keyword);
	}

	public List<Product> getCategoryProducts(String category) {

		List<Product> categoryProducts = productDAO.getCategoryProducts(category);

		return categoryProducts;
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
	
	public Boolean isExit(String barcode){
		System.out.println("Service isExit()");
		
		return productDAO.isExit(barcode);
	}

}
