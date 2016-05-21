package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.zebra.dto.Member;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.ProductService;

@Controller
public class ProductController {

	private ProductService productService;
	
	@Autowired//di ���� 
	public void setProductService(ProductService productService){
		this.productService = productService;	
	}

	@RequestMapping("/Product")
	public String showProductPage(Model model, HttpSession session, HttpServletRequest request){	
		session.setAttribute("currentCategory", "0");
			return "Product";

	}

	
	@RequestMapping("/Category")
	public String showCategoryPage(Model model, HttpSession session, HttpServletRequest request){
	
			return "Category";
	
	}
	
//--------------------------------------��� ��ǰ �޼���-----------------------------------//
	@RequestMapping(value="/PopularProduct",method = RequestMethod.GET)
	public String showPopularProductPage(Model model, HttpSession session, HttpServletRequest request){

		String currentCategory=(String)request.getParameter("category");
		session.setAttribute("currentCategory", currentCategory);
		List<Product> popularProduct =productService.getPopularProducts(currentCategory);
		model.addAttribute("popularProductModel", popularProduct);

			return "PopularProduct";
		
	
	}
	
	@RequestMapping(value="/AllMostReview",method = RequestMethod.GET)
	public String showMostReviewPage(Model model, HttpSession session, HttpServletRequest request){

		String currentCategory=(String)request.getParameter("category");
		session.setAttribute("currentCategory", currentCategory);
		List<Product> mostReviewProducts =productService.getMostReviewProducts(currentCategory);
		model.addAttribute("mostReviewProductsModel", mostReviewProducts);

			return "AllMostReview";
		
	
	}
	
	
	@RequestMapping(value="/AllMostScan",method = RequestMethod.GET)
	public String showMostScanPage(Model model, HttpSession session, HttpServletRequest request){

		String currentCategory=(String)request.getParameter("category");
		session.setAttribute("currentCategory", currentCategory);
		List<Product> mostScanProducts =productService.getMostScanProducts(currentCategory);
		model.addAttribute("mostScanProductsModel", mostScanProducts);

			return "AllMostScan";
		
	
	}
	
	
	//-----------------------------------------
	

	
	
	
	
}