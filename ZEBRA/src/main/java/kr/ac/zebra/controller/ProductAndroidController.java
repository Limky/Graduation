package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Member;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.ProductService;

@Controller
public class ProductAndroidController {

	private ProductService productService;
	
	@Autowired//di 주입 
	public void setProductService(ProductService productService){
		this.productService = productService;	
	}
	
	//-------------------------------자사 상품 라인---------------------------------------
	//----------------------------안드로이드-----------------------------------
	
		@RequestMapping("/androidTest")
		public String showandroidTestPage(HttpServletRequest request,Model model){

			String memberId = "a";
			String reciveBarcode = request.getParameter("barcode");
			System.out.println(reciveBarcode);
					
			//------------DB---------------------
			Member member = productService.getMember(memberId);
			Product product = productService.getProduct(reciveBarcode);
			//String ProductName = product.getProductName();
			//System.out.println(ProductName);
			//model.addAttribute("modelProductName",ProductName);
			//request.setAttribute("requestProductName", product);
			request.setAttribute("requestProductObject", product);
			request.setAttribute("requestMemerObject", member);
			
			return "androidTest";
		}
		
		@RequestMapping("/test")
		public String showtestPage(HttpServletRequest request,Model model){

			String reciveBarcode = request.getParameter("barcode");
			System.out.println(reciveBarcode);
					
			
			return "failLogin";
		}
		
		
		
		//-------------------------------자사 상품 라인---------------------------------------
		@RequestMapping("/houseProduct")
		public String showHousePopularProductPage(Model model, HttpSession session, HttpServletRequest request){

			
			List<Product> housePopularProducts =productService.getHousePopularProducts((String)session.getAttribute("logOk"));
			model.addAttribute("housePopularProductsModel", housePopularProducts);

				return "houseProduct";
		
		
		}
	
	
	

}
