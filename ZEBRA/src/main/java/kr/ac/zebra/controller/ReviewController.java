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
import kr.ac.zebra.service.AppReviewService;
import kr.ac.zebra.service.ProductService;
import kr.ac.zebra.service.ReviewService;

@Controller
public class ReviewController {
	private ReviewService reviewService;
	private ProductService productService;
	private AppReviewService appReviewService;
	
	@Autowired // di 주입
	public void setProductService(ReviewService reviewService,ProductService productService,AppReviewService appReviewService) {
		this.reviewService = reviewService;
		this.productService = productService;
		this.appReviewService = appReviewService;
	}


	@RequestMapping(value="/review",method = RequestMethod.GET)
	public String showReviewPage(Model model, HttpSession session, HttpServletRequest request){
	
			System.out.println("리뷰 페이지 메서드 작동");
		
			String barcode = request.getParameter("barcode");
			List<Review> reviews = reviewService.getReviews(barcode);
			request.setAttribute("reviewListRequ", reviews);
			model.addAttribute("reviewList", reviews);
		
			Product	product =productService.getProduct(barcode);
			model.addAttribute("productInfo", product);
			request.setAttribute("starPoint", (double)product.getStarPoint());
			List<Product> relatedProducts =productService.getPopularProducts((String)product.getCategory());
			model.addAttribute("relatedProducts", relatedProducts);
			request.setAttribute("relatedProductsRequ", relatedProducts);
			
			request.setAttribute("reviewsList", reviews);
			
		
			  List<Integer> star = appReviewService.getStarPoint(barcode);
			  model.addAttribute("star4Rating", star.get(4));
			  model.addAttribute("star3Rating", star.get(3));
			  model.addAttribute("star2Rating", star.get(2));
			  model.addAttribute("star1Rating", star.get(1));
			  model.addAttribute("star0Rating", star.get(0));
			 
			 
			 System.out.println(star);
			 
			return "review";
	
	}
	
	
	
	
}