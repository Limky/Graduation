package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.AppProductService;
import kr.ac.zebra.service.AppReviewService;

@Controller
public class AppScanController {

   private AppProductService appProductService;
   private AppReviewService appReviewService;

   @Autowired
   public void setReviewService(AppReviewService reviewService) {
      this.appReviewService = reviewService;
   }

   @Autowired
   public void setProductService(AppProductService productService) {
      this.appProductService = productService;
   }

   @RequestMapping("/appScan")
   public String showScanInfo(HttpServletRequest request) {

      System.out.println("AppScan");

      String barcode = request.getParameter("barcode");

      Product product = appProductService.getProduct(barcode);
      List<Review> reviews = appReviewService.getReviews(barcode);

      if (product == null) {
         AppApply apply = appProductService.getApply(barcode);
         String result = "";

         if (apply == null) {
            result = "null";
            request.setAttribute("result", result);
         } else {
            result = "existApply";

            request.setAttribute("result", result);
         }
      } else {
         appProductService.scanCounting(barcode);

         request.setAttribute("product", product);
         request.setAttribute("reviews", reviews);
      }

      return "appScan";

   }

}