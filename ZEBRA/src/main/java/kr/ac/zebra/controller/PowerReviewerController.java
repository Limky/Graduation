package kr.ac.zebra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Member;
import kr.ac.zebra.service.PowerReviewerService;

@Controller
public class PowerReviewerController {

	private PowerReviewerService powerReviewerService;
	
	@Autowired
	public void setPowerReviewerService(PowerReviewerService powerReviewService){
		this.powerReviewerService = powerReviewService;
	}
	
	
	@RequestMapping("/powerReviewer")
	public String showPowerReviewer(Model model){
		
		List<Member> firstGrade = powerReviewerService.getFirstGrade();
		List<Member> secondGrade = powerReviewerService.getSecondGrade();
		List<Member> thirdGrade = powerReviewerService.getThirdGrade();
		
		model.addAttribute("firstGrade", firstGrade);
		model.addAttribute("secondGrade", secondGrade);
		model.addAttribute("thirdGrade", thirdGrade);
		
		
		return "powerReviewer";
	}
	
}
