package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Member;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.AppProductService;
import kr.ac.zebra.service.AppReviewService;

@Controller
public class AppReviewController {

	private AppReviewService appReviewService;
	private AppProductService appProductService;

	@Autowired
	public void setReviewService(AppReviewService reviewService) {
		this.appReviewService = reviewService;
	}

	@Autowired
	public void setProductService(AppProductService productService) {
		this.appProductService = productService;
	}

	@RequestMapping("/appReviewRegister")
	public String showProductReviews(HttpServletRequest request) {
		System.out.println("appReviewController");

		if (appReviewService.checkAvailable(request.getParameter("id"), request.getParameter("barcode"))) {

			appReviewService.setReview(request.getParameter("id"), request.getParameter("barcode"),
					request.getParameter("reviewText"), Double.parseDouble(request.getParameter("starPoint")),
					request.getParameter("memberUrl"), request.getParameter("productUrl"),
					request.getParameter("level"));

			List<Review> reviews = appReviewService.getReviews(request.getParameter("barcode"));
			Product product = appProductService.getProduct(request.getParameter("barcode"));

			request.setAttribute("reviews", reviews);
			request.setAttribute("product", product);

			return "appScan";
		} else {
			System.out.println("리뷰등록실패!");
			request.setAttribute("result", "reviewRegisterFail");
			return "appError";
		}

	}

	@RequestMapping("/appShowMyReview")
	public String showMyReviews(HttpServletRequest request) {
		
		System.out.println(request.getParameter("id"));

		List<Review> myReviewList = appReviewService.getReviewsById(request.getParameter("id"));
		request.setAttribute("reviews", myReviewList);
		
		System.out.println(myReviewList);

		return "appShowMyReview";
	}
}