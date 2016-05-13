package kr.ac.hansung.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller //@Component 의 기능과 똑같다. 하지만 좀더 구체적으로 쓴것이 Controller 즉 좀 더 명확히씀
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
	
		
		return "home";
	}
	
	
	
	@RequestMapping("/MostReviews")
	public String showMostReviews(){	
		

		return "MostReviews";
		
	}
	
	@RequestMapping("/ScanPriority")
	public String showScanPriority(){	
		

		return "ScanPriority";
		
	}
	
	
}
