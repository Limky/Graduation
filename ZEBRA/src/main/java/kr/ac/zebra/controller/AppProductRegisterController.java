package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.service.AppProductRegisterService;

@Controller
public class AppProductRegisterController {
	private AppProductRegisterService appProductService;

	@Autowired
	public void setAppProductRegisterService(AppProductRegisterService appProductService) {
		this.appProductService = appProductService;
	}

	@RequestMapping("/appProductRegister")
	public String showAppProductRegister(HttpServletRequest request) {

		System.out.println("appProductRegiset");
		String id = request.getParameter("id");
		String barcode = request.getParameter("barcode");
		String productName = request.getParameter("productName");
		
		if(appProductService.insertProduct(id, barcode, productName)){
			request.setAttribute("result", "{\"1\"}");
		}else{
			request.setAttribute("result", "{\"0\"}");
		}
		
		return "appProductRegister";
	}

}
