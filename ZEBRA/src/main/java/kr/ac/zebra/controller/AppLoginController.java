package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Member;
import kr.ac.zebra.service.AppGcmService;
import kr.ac.zebra.service.LoginService;

@Controller
public class AppLoginController {

	private LoginService loginService;
	private AppGcmService appGcmService;
	
	@Autowired
	public void setLoginService(LoginService loginService, AppGcmService appGcmService) {
		this.loginService = loginService;
		this.appGcmService = appGcmService;
	}
	
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/appLogin")
	public String showloginTest(HttpServletRequest request) {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String tokenId = request.getParameter("token");
		
		
		appGcmService.updateTokenId(tokenId);

		Member member = loginService.checkMember(id, password);

		request.setAttribute("member", member);

	
		return "appLogin";

	}
}
