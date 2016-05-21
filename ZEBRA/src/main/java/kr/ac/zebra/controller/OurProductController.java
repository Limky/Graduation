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
import kr.ac.zebra.service.OurProductService;

@Controller
public class OurProductController {

	private OurProductService ourProductService;

	@Autowired // di ¡÷¿‘
	public void setProductService(OurProductService ourProductService) {
		this.ourProductService = ourProductService;
	}

	@RequestMapping(value = "/OurProduct", method = RequestMethod.GET)
	public String showOurProductPage(Model model, HttpSession session, HttpServletRequest request) {

		String fiter = request.getParameter("filter");
		String companyName = (String) session.getAttribute("logOk");
		
		
		//----------------------------------------------------------------------------------------
		if (fiter.equals("All")) {
			
			List<Product> AllProducts = ourProductService.getOurAllProducts(companyName);
			model.addAttribute("ourProductsModel", AllProducts);

		}
		
		if (fiter.equals("Popularity")) {
	
			List<Product> PopularityProducts = ourProductService.getOurPopularityProducts(companyName);
			model.addAttribute("ourProductsModel", PopularityProducts);
			
		}
		
		if (fiter.equals("MostReview")) {
	
			List<Product> MostReviewProducts = ourProductService.getOurMostReviewProducts(companyName);
			model.addAttribute("ourProductsModel", MostReviewProducts);
			
			
		}
		
		if (fiter.equals("MostScan")) {
		
			List<Product> MostScanProducts = ourProductService.getOurMostScanProducts(companyName);
			model.addAttribute("ourProductsModel", MostScanProducts);
			
			
		}

		return "OurProduct";

	}

}
