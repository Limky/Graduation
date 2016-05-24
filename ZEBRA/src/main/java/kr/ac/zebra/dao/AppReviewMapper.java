package kr.ac.zebra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.zebra.dto.AppReview;

public class AppReviewMapper implements RowMapper<AppReview> {

	public AppReview mapRow(ResultSet rs, int rowNum) throws SQLException {

		AppReview appReview = new AppReview();

		appReview.setId(rs.getString("id"));
		appReview.setBarcode(rs.getString("barcode"));
		appReview.setReviewText(rs.getString("reviewText"));
		appReview.setStarPoint(rs.getDouble("starPoint"));
		appReview.setMemberUrl(rs.getString("memberUrl"));
		appReview.setProductUrl(rs.getString("productUrl"));

		return appReview;

	}

}
