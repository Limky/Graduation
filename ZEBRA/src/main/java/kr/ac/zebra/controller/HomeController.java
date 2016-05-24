package kr.ac.zebra.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {

		
		return "home";
		
	}
	
	
	@RequestMapping("/topNavigation")
	public String showTopMenunPage(){
	
		return "topNavigation";
	}
	
	

	@RequestMapping("/bootstraptest")
	public String showbootstraptestPage(){
	
		return "bootstraptest";
	}
	
	
	@RequestMapping("/testdesign")
	public String testdesign(){
	
		return "testdesign";
	}
	

	
	@RequestMapping("/Search")
	public String Search(){
	
		return "Search";
	}
	
	
}
