package kr.ac.zebra.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.AppMemberDAO;
import kr.ac.zebra.dao.AppProductDAO;
import kr.ac.zebra.dao.AppReviewDAO;
import kr.ac.zebra.dto.Member;
import kr.ac.zebra.dto.Review;

@Service("appReviewService") // service로 bean에 등록시켜준다
public class AppReviewService {

	private AppReviewDAO appReviewDAO;
	private AppMemberDAO appMemberDAO;
	private AppProductDAO appProductDAO;

	@Autowired
	public void setReviewDAO(AppReviewDAO reviewDAO) {
		this.appReviewDAO = reviewDAO;
	}

	@Autowired
	public void setMemberDAO(AppMemberDAO memberDAO) {
		this.appMemberDAO = memberDAO;
	}

	@Autowired
	public void setProductDAO(AppProductDAO appProductDAO) {
		this.appProductDAO = appProductDAO;
	}

	public List<Review> getReviews(String barcode) {

		return appReviewDAO.getReviews(barcode);

	}

	public Review getReview(String barcode) {

		return appReviewDAO.getReview(barcode);

	}

	public List<Review> getReviewsById(String id) {

		return appReviewDAO.getReviewsById(id);

	}

	public void setReview(String id, String barcode, String reviewText, double starPoint, String memberUrl,
			String productUrl, String level) {

		System.out.println("setReview");

		if (appReviewDAO.isExist(id, barcode) == null) {
			System.out.println("isExist");
			appReviewDAO.setReview(id, barcode, reviewText, starPoint, memberUrl, productUrl, level);
		} else {

			appReviewDAO.updateReview(id, barcode, reviewText, starPoint, memberUrl, productUrl, level);
		}

	}

	public List<Integer> getStarPoint(String barcode) {

		List<Integer> star = appReviewDAO.getStarPoint(barcode);
		List<Integer> starAvarage = new ArrayList<Integer>();
		int sum = star.get(star.size() - 1);
		int count;

		for (int i = 0; i < 6; i++) {
			count = (star.get(i) * 100) / sum;
			starAvarage.add(i, count);
			System.out.println(count);
		}

		System.out.println(starAvarage);

		return starAvarage;
	}

	public Boolean checkAvailable(String id, String barcode) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		String nowDate = df.format(cal.getTime());

		Member member = appMemberDAO.getMember(id);
		System.out.println("appReviewService");

		if (member.getLastReviewDate().equals(nowDate)) {
			if (member.getReviewCount() > 0) {

				appMemberDAO.setting(id, member.getReviewCount(), member.getPoint(), member.getTotalReviewCount());
				appProductDAO.setAvarageStarPoint(barcode);

				return true;
			} else {
				return false;
			}
		} else {
			appMemberDAO.setting2(id, member.getReviewCount(), member.getPoint(), nowDate,
					member.getTotalReviewCount());
			appProductDAO.setAvarageStarPoint(barcode);

			return true;
		}
	}
}
