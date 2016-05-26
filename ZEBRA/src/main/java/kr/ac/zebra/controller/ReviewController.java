package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.ProductService;
import kr.ac.zebra.service.ReviewService;

@Controller
public class ReviewController {
	private ReviewService reviewService;
	private ProductService productService;
	
	@Autowired // di 주입
	public void setProductService(ReviewService reviewService,ProductService productService) {
		this.reviewService = reviewService;
		this.productService = productService;
	}


	@RequestMapping(value="/review",method = RequestMethod.GET)
	public String showReviewPage(Model model, HttpSession session, HttpServletRequest request){
	
			System.out.println("리뷰 페이지 메서드 작동");
		
			String barcode = request.getParameter("barcode");
			List<Review> reviews = reviewService.getReviews(barcode);
			System.out.println(reviews);
			model.addAttribute("reviewList", reviews);
		
			Product	product =productService.getProduct(barcode);
			model.addAttribute("productInfo", product);
			
			
			return "review";
	
	}
	
	
	
	
}