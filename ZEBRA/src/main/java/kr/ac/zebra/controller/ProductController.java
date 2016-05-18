package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.service.ProductService;

@Controller
public class ProductController {

	private ProductService productService;
	
	@Autowired//di ¡÷¿‘ 
	public void setProductService(ProductService productService){
		this.productService = productService;	
	}
	

	@RequestMapping("/PopularProduct")
	public String showPopularProductPage(Model model, HttpSession session, HttpServletRequest request){


			return "PopularProduct";
		
	
	}
	
	
	
	
	
}
