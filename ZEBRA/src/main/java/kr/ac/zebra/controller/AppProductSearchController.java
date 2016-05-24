package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.AppProductSearchService;

@Controller
public class AppProductSearchController {

	private AppProductSearchService appProductSearchService;

	@Autowired
	public void setSearchService(AppProductSearchService appProductSearchService) {
		this.appProductSearchService = appProductSearchService;
	}

	@RequestMapping("/appProductSearch")
	public String showSearchProducts(HttpServletRequest request) {

		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		System.out.println("controller");

		List<Product> searchProduct = appProductSearchService.getProductSearch(keyword);
		
		System.out.println(searchProduct);
		
		request.setAttribute("productList", searchProduct);

		return "appProductSearch";
	}
}
