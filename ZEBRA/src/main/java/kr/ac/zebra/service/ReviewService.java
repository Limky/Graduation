package kr.ac.zebra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.ac.zebra.dao.ProductDAO;
import kr.ac.zebra.dao.ReviewDAO;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;

@Service("reviewService") // service로 bean에 등록시켜준다
public class ReviewService {
	

	private ProductDAO productDAO;
	private ReviewDAO reviewDAO;
	@Autowired // DI 주입
	public void setProductDAO(ProductDAO productDAO,ReviewDAO reviewDAO) {
		this.productDAO = productDAO;
		this.reviewDAO = reviewDAO;

	}

	public List<Review> getReviews(String barcode) {
	
		return reviewDAO.getReviews(barcode);
		
	}
	


	public List<Integer> getProductCount(String barcode) {
	
		return productDAO.getProductCount(barcode);
		
	}

	
	public List<Integer> getStarPoint(String barcode) {

		List<Integer> star = reviewDAO.getStarPoint(barcode);
		List<Integer> starAvarage = new ArrayList<Integer>();
		int sum = star.get(star.size() - 1);
		int count;

		if (sum != 0) {
			for (int i = 0; i < 6; i++) {
				count = (star.get(i) * 100) / sum;
				starAvarage.add(i, count);
				System.out.println(count);
			}
		} else {
			for (int i = 0; i < 6; i++) {
				count = 0;
				starAvarage.add(i, count);
				System.out.println(count);
			}
		}

		System.out.println(starAvarage);

		return starAvarage;
	}
	

}
