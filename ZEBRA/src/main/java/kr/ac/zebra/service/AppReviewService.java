package kr.ac.zebra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.ReviewDAO;
import kr.ac.zebra.dto.AppReview;

@Service("ReviewService") // service로 bean에 등록시켜준다
public class AppReviewService {

	private ReviewDAO reviewDAO;

	@Autowired // DI 주입
	public void setReviewDAO(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}

	public List<AppReview> getReviews(String barcode) {

		return reviewDAO.getReviews(barcode);

	}

	public AppReview getReview(String barcode) {

		return reviewDAO.getReview(barcode);

	}

	public AppReview getReviewsById(String id) {

		return reviewDAO.getReviewsById(id);

	}

	public void setReview(String id, String barcode, String reviewText, double starPoint, String memberUrl,	String productUrl) {
		reviewDAO.setReview(id, barcode, reviewText, starPoint, memberUrl, productUrl);

	}
}
