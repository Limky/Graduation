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
public class ManagementController {

	private OurProductService ourProductService;

	@Autowired // di 주입
	public void setProductService(OurProductService ourProductService) {
		this.ourProductService = ourProductService;
	}

	@RequestMapping(value = "/Management", method = RequestMethod.GET)
	public String showManagementPage(Model model, HttpSession session, HttpServletRequest request) {

		
		System.out.println("Management 메서드 받음");
		return "Management";

	}

}
