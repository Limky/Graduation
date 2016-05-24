package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.Review;



@Component("ReviewDAO")
public class ReviewDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public Review getReviewsById(String id){
		try {
			String sqlStatement = "select * from reviewtb where id=?";

			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { id }, new ReviewMapper());
		} catch (Exception e) {

			System.out.println("DAO 예외 처리 발생 획인 메세지 getReviewsById ");
			e.printStackTrace();

			return null;
		}
	}

	public Review getReview(String barcode) {

		try {
			String sqlStatement = "select * from reviewtb where barcode=?";

			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { barcode }, new ReviewMapper());
		} catch (Exception e) {

			System.out.println("DAO 예외 처리 발생 획인 메세지 getReview ");
			e.printStackTrace();

			return null;
		}
	}

	public List<Review> getReviews(String barcode) {

		try {
			String sqlStatement = "select * from reviewtb where barcode= ?";

			return jdbcTemplateObject.query(sqlStatement, new Object[] { barcode }, new ReviewMapper());
		} catch (Exception e) {

			System.out.println("DAO 예외 처리 발생 획인 메세지 getReviews ");
			e.printStackTrace();

			return null;
		}

	}

	public void setReview(String id, String barcode, String reviewText, double starPoint, String memberUrl, String productUrl) {

		try {
			String sqlStatement = "insert into reviewtb (id, barcode, reviewText, starPoint, memberUrl, productUrl) values (?, ?, ?, ?, ?, ?)";

			jdbcTemplateObject.update(sqlStatement, new Object[] { id, barcode, reviewText, starPoint, memberUrl, productUrl});
		} catch (Exception e) {
			System.out.println("DAO 예외 처리 발생 획인 메세지 setReview ");
			e.printStackTrace();
		}

	}
}
