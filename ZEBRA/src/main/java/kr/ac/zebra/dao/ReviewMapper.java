package kr.ac.zebra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.zebra.dto.Review;



public class ReviewMapper implements RowMapper<Review> {

	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {

		Review appReview = new Review();

		appReview.setId(rs.getString("id"));
		appReview.setBarcode(rs.getString("barcode"));
		appReview.setReviewText(rs.getString("reviewText"));
		appReview.setStarPoint(rs.getDouble("starPoint"));
		appReview.setMemberUrl(rs.getString("memberUrl"));
		appReview.setProductUrl(rs.getString("productUrl"));
		appReview.setLevel(rs.getString("level"));
		
		return appReview;

	}

}
