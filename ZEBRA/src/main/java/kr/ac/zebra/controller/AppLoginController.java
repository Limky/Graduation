package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Member;
import kr.ac.zebra.service.LoginService;

@Controller
public class AppLoginController {

	public LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/appLogin")
	public String showloginTest(HttpServletRequest request) {

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		Member member = loginService.checkMember(id, password);

		request.setAttribute("member", member);

		/*
		 * System.out.println("login test"); List<Integer> star =
		 * reviewService.getStarPoint("8801056059842");
		 */
		return "appLogin";

	}
}
