package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.ProductService;

@Controller
public class ProductController {

	private ProductService productService;

	@Autowired // di ¡÷¿‘
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/PopularProduct")
	public String showPopularProductPage(Model model, HttpSession session, HttpServletRequest request) {

		List<Product> popularProduct = productService.getPopularProducts();
		model.addAttribute("popularProductModel", popularProduct);

		return "PopularProduct";

	}

	@RequestMapping("/MostReview")
	public String showMostReviewPage(Model model, HttpSession session, HttpServletRequest request) {

		List<Product> mostReviewProducts = productService.getMostReviewProducts();
		model.addAttribute("mostReviewProductsModel", mostReviewProducts);

		return "MostReview";

	}

	@RequestMapping("/MostScan")
	public String showMostScanPage(Model model, HttpSession session, HttpServletRequest request) {

		List<Product> mostScanProducts = productService.getMostScanProducts();
		model.addAttribute("mostScanProductsModel", mostScanProducts);

		return "MostScan";

	}

}
