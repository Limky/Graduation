package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.AppReviewService;
import kr.ac.zebra.service.AppProductService;

@Controller
public class AppReviewController {

	private AppReviewService reviewService;
	private AppProductService productService;

	@Autowired
	public void setReviewService(AppReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@Autowired
	public void setProductService(AppProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/appReviewRegister")
	public String showProductReviews(HttpServletRequest request) {
		System.out.println("appReviewController");

		reviewService.setReview(request.getParameter("id"), request.getParameter("barcode"),
				request.getParameter("reviewText"), Double.parseDouble(request.getParameter("starPoint")),
				request.getParameter("memberUrl"), request.getParameter("productUrl"), request.getParameter("level"));

		List<Review> reviews = reviewService.getReviews(request.getParameter("barcode"));
		Product product = productService.getProduct(request.getParameter("barcode"));
		
		System.out.println(reviews);
		//System.out.println(product);

		request.setAttribute("reviews", reviews);
		request.setAttribute("product", product);

		return "appScan";
	}

	@RequestMapping("/appShowMyReview")
	public String showMyReviews(HttpServletRequest request) {

		List<Review> myReviewList = reviewService.getReviewsById(request.getParameter("id"));
		request.setAttribute("reviews", myReviewList);

		return "appShowMyReview";
	}
}