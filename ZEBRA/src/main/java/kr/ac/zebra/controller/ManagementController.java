package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.ManagementService;

@Controller
public class ManagementController {

	private ManagementService managementService;

	
	@Autowired // di 주입
	public void setProductService(ManagementService managementService) {
		this.managementService = managementService;
		
	}

	@RequestMapping(value = "/Management", method = RequestMethod.GET)
	public String showManagementPage(Model model, HttpSession session, HttpServletRequest request) {

		
		System.out.println("Management 메서드 받음");
		List<AppApply> applyList = managementService.getApplys();
		model.addAttribute("applyListModel", applyList);
		
		
		return "Management";

	}

	@RequestMapping(value = "/Confirm", method = RequestMethod.GET)
	public String showConfirmPage(Model model, HttpSession session, HttpServletRequest request) {

		
		System.out.println("Confirm 메서드 받음");
		
		
		
		return "Confirm";

	}
	
	
	@RequestMapping(value = "/doConfirm", method = RequestMethod.GET)
	public String showDoConfirmPage(Model model, HttpSession session, HttpServletRequest request) {

		
		if(request.getParameter("allow").equals("okay")){
			System.out.println("doConfirm 상품등록 if");
			//---------상품 등록----------//
			//1. 상품 등록하기 위한 dto 세팅
			//2. 멤버 포인트 증가
			//3. ApplyTable Delete 
			
			Product product = new Product();
			
			product.setBarcode(request.getParameter("barcode"));
			product.setCategory(request.getParameter("category"));
			product.setCompanyName(request.getParameter("companyName"));
			product.setDescription(request.getParameter("description"));
			product.setProductName(request.getParameter("productName"));
			product.setProductUrl(request.getParameter("productUrl"));
			product.setScanCount(1);//초기화..
			product.setStarPoint(0);
			product.setTotalReviewCount(1);
			
			if(managementService.insertProduct(product)){
				
				System.out.println("상품 반영 완료!!");
				//2. 멤버 포인트 증가
				managementService.increasePoint(request.getParameter("id"));
				
				//3. ApplyTable Delete 
				managementService.DeleteApplyTb(request.getParameter("barcode"));
					
				System.out.println("멤버포인트 증가 && 어플라이 디비 삭제");
				
			}else{
				
				System.out.println("상품 반영 실패");
			}
			
			
				
		
			
			
		}else{
			
			//-------유효하지 않는 상품임--------
			//1. ApplyTable Delete 
			//2. 멤버 포인트 감소
			
			//1. ApplyTable Delete 
			managementService.DeleteApplyTb(request.getParameter("barcode"));
			
			//2. 멤버 포인트 감소
			managementService.decreasePoint(request.getParameter("id"));
			
		}
		
	
	
		 
		System.out.println("doConfirm 메서드 받음");
		
		
		
		return "doConfirm";

	}
}
