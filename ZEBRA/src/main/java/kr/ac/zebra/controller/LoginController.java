package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Member;
import kr.ac.zebra.service.LoginService;

@Controller
public class LoginController {

	private LoginService loginService;
	
	@Autowired//di 주입 
	public void setLoginService(LoginService loginService){
		this.loginService = loginService;	
	}
	

	@RequestMapping("/doLogin")
	public String showDoLoginPage(Model model, HttpSession session, HttpServletRequest request){


		String tid = request.getParameter("id");
		String tpassword = request.getParameter("password");
		
		Member member=loginService.checkMember(tid,tpassword);
		

		if(member == null){
			System.out.println("로그인 실패");
			return "failLogin";
	
		} else {
			System.out.println("로그인 성공");
			
			model.addAttribute("modelLoginMember", member);
			session.setAttribute("sessionLoginMember", member);		
			session.setAttribute("logOk", member.getName());
	
			return "doLogin";
		}		
		
	
	}
	
	
	
}
