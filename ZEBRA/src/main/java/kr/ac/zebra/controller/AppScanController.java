package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.ProductService;
import kr.ac.zebra.service.ReviewService;

@Controller
public class AppScanController {

	private ProductService productService;
	private ReviewService reviewService;

	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/appScan")
	public String showScanInfo(HttpServletRequest request) {

		System.out.println("AppScan");
		System.out.println(request.getParameter("barcode"));

		Product product = productService.getProduct(request.getParameter("barcode"));

		List<Review> reviews = reviewService.getReviews(request.getParameter("barcode"));

		if (product == null) {
			AppApply apply = productService.getApply(request.getParameter("barcode"));

			if (apply == null) {

				request.setAttribute("product", apply);
			} else {

				request.setAttribute("product", "exist");
			}
		} else {
			request.setAttribute("product", product);
		}

		request.setAttribute("reviews", reviews);

		return "appScan";
	}
}
