package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.AppReview;
import kr.ac.zebra.service.ProductService;
import kr.ac.zebra.service.AppReviewService;

@Controller
public class AppReviewController {

	private AppReviewService appReviewService;
	private ProductService productService;

	@Autowired
	public void setReviewService(AppReviewService appReviewService) {
		this.appReviewService = appReviewService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/appReviewRegister")
	public String showProductReviews(HttpServletRequest request) {

		appReviewService.setReview(request.getParameter("id"), request.getParameter("barcode"),
				request.getParameter("reviewText"), Double.parseDouble(request.getParameter("starPoint")),
				request.getParameter("memberUrl"),request.getParameter("productUrl"));

		List<AppReview> reviews = appReviewService.getReviews(request.getParameter("barcode"));
		Product product = productService.getProduct(request.getParameter("barcode"));

		request.setAttribute("reviews", reviews);
		request.setAttribute("product", product);

		return "appScan";
	}
}