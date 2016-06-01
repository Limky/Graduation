package kr.ac.zebra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.Review;

@Component("appReviewDAO")
public class AppReviewDAO {

   private JdbcTemplate jdbcTemplateObject;

   @Autowired
   public void setDataSource(DataSource dataSource) {
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public Review getReview(String barcode) {

      try {
         String sqlStatement = "select * from reviewtb where barcode=?";

         return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { barcode }, new AppReviewMapper());
      } catch (Exception e) {

         System.out.println("DAO 예외 처리 발생 획인 메세지 getReview ");

         return null;
      }
   }

   public List<Review> getReviews(String barcode) {

      try {
         String sqlStatement = "select * from reviewtb where barcode= ?";

         return jdbcTemplateObject.query(sqlStatement, new Object[] { barcode }, new AppReviewMapper());
      } catch (Exception e) {

         System.out.println("DAO 예외 처리 발생 획인 메세지 getReviews ");

         return null;
      }

   }

   public List<Review> getReviewsById(String id) {
      try {
         String sqlStatement = "select * from reviewtb where id=?";

         return jdbcTemplateObject.query(sqlStatement, new Object[] { id }, new AppReviewMapper());
      } catch (Exception e) {

         System.out.println("DAO 예외 처리 발생 획인 메세지 getReviewsById ");

         return null;
      }
   }

   public void setReview(String id, String barcode, String reviewText, double starPoint, String memberUrl,
         String productUrl, String level) {

      try {
         String sqlStatement = "insert into reviewtb (id, barcode, reviewText, starPoint, level, memberUrl, productUrl) values (?, ?, ?, ?, ?, ?, ?)";

         jdbcTemplateObject.update(sqlStatement,
               new Object[] { id, barcode, reviewText, starPoint, level, memberUrl, productUrl });
      } catch (Exception e) {
         System.out.println("setReview() 예외 처리 발생 획인 메세지 ");
         e.printStackTrace();
      }
   }

   public void updateReview(String id, String barcode, String reviewText, double starPoint, String memberUrl,
         String productUrl, String level) {
      try {
         String sqlStatement = "update reviewtb set reviewText=?, starPoint=?, level=? where id=? and barcode=?";

         jdbcTemplateObject.update(sqlStatement, new Object[] { reviewText, starPoint, level, id, barcode });
      } catch (Exception e) {
         System.out.println("DAO 예외 처리 발생 획인 메세지 updateReview ");
      }

   }

   public Review isExist(String id, String barcode) {

      try {
         String sqlStatement = "select * from reviewtb where id=? and barcode=?";

         System.out.println(id);
         System.out.println(barcode);

         Review review = jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { id, barcode },
               new AppReviewMapper());

         System.out.println(review);

         return review;
      } catch (Exception e) {
         System.out.println("fail");
         return null;
      }
   }

   public List<Integer> getStarPoint(String barcode) {

      try {
         String sqlStatement = "select count(if(starPoint=?, starPoint, null)) from reviewtb where barcode = ?";
         int sum = 0;
         int count = 0;
         int i = 0;
         List<Integer> star = new ArrayList<Integer>();

         for (i = 0; i < 5; i++) {
            count = jdbcTemplateObject.queryForInt(sqlStatement, new Object[] { i + 1, barcode });
            sum += count;
            star.add(i, count);
         }
         star.add(i, sum);

         System.out.println("star=" + star);

         return star;
      } catch (Exception e) {
         return null;
      }
   }
   
   public void reviewCounting(String barcode){
      String sqlStatement = "update producttb set totalReviewCount=totalReviewCount+1 where barcode =";
      
      jdbcTemplateObject.update(sqlStatement, new Object[]{barcode});
   }

}