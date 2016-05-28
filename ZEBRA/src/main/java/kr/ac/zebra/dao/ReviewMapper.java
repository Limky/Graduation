package kr.ac.zebra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.zebra.dto.Review;

public class ReviewMapper {

	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {

		Review review = new Review();

		review.setId(rs.getString("id"));
		review.setBarcode(rs.getString("barcode"));
		review.setReviewText(rs.getString("reviewText"));
		review.setStarPoint(rs.getDouble("starPoint"));
		review.setMemberUrl(rs.getString("memberUrl"));
		review.setProductUrl(rs.getString("productUrl"));
		review.setLevel(rs.getString("level"));

		return review;
	}
}
