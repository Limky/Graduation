package kr.ac.zebra.dao;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.Member;

//@Componentï¿½ë’— ï¿½ì”  ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ?®?‰?‘æ¿¡ï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¹ ä»¥ï¿½ï¿½ë–.
@Component("appMemberDAO")
public class AppMemberDAO {

   private JdbcTemplate jdbcTemplateObject;

   // @Autowired å¯ƒìŒ?Š¦ typeï¿½ì”  åª›ìˆˆï¿? å¯ƒìŒ?Š¦?‘œï¿? ï§£ì„?”ï¿½ë¸³ï¿½ë–.
   @Autowired
   public void setDataSource(DataSource dataSource) {
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   // ---------------------------------------------------------------------------------------------------------------//
   // Querying and returning a single object
   public Member getMember(String id) {

      try {
         String sqlStatement = "select * from membertb where id=?";

         return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { id }, new AppMemberMapper());
      } catch (Exception e) {
         System.out.println("DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö  getMember");

         return null;
      }

   }

   // Querying and returning multiple object
   public List<Member> getMembers() {

      try {

         String sqlStatement = "select * from membertb";

         return jdbcTemplateObject.query(sqlStatement, new AppMemberMapper());
      } catch (Exception e) {
         System.out.println("DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö  getMembers");
         
         return null;
      }

   }

   public void setting(String id, int reviewCount, int point, int totalReviewCount) {

      String sqlStatement = "update membertb set reviewCount = ?, point= ?, totalreviewcount= ? where id = ?";

      totalReviewCount++;
      reviewCount--;
      point += 10;

      jdbcTemplateObject.update(sqlStatement, new Object[] { reviewCount, point, totalReviewCount, id });

      System.out.println(totalReviewCount);

      if (totalReviewCount == 4) {
         sqlStatement = "update membertb set level = 'silver' where id = ?";
         jdbcTemplateObject.update(sqlStatement, new Object[] { id });
      } else if (totalReviewCount == 7) {
         sqlStatement = "update membertb set level = 'gold' where id = ?";
         jdbcTemplateObject.update(sqlStatement, new Object[] { id });
      }

   }

   public void setting2(String id, int reviewCount, int point, String nowDate, int totalReviewCount) {

      String sqlStatement = "update membertb set reviewCount = ?, point= ?, lastreviewdate= ?, totalreviewcount= ? where id = ?";

      totalReviewCount++;
      reviewCount = 2;
      point += 10;

      jdbcTemplateObject.update(sqlStatement, new Object[] { reviewCount, point, nowDate, totalReviewCount, id });

      if (totalReviewCount == 4) {
         sqlStatement = "update membertb set level = 'Silver' where id = ?";
         jdbcTemplateObject.update(sqlStatement, new Object[] { id });
      } else if (totalReviewCount == 7) {
         sqlStatement = "update membertb set level = 'Gold' where id = ?";
         jdbcTemplateObject.update(sqlStatement, new Object[] { id });
      }

   }

   // public List<Member> getFirstGrade() {
   //
   // String sqlStatement = "select * from membertb where level = 1 order by
   // totalReviewCount desc limit 0,3";
   //
   // return jdbcTemplateObject.query(sqlStatement, new AppMemberMapper());
   //
   // }
   //
   // public List<Member> getSecondGrade() {
   //
   // String sqlStatement = "select * from membertb where level = 2 order by
   // totalReviewCount desc limit 0,3";
   //
   // return jdbcTemplateObject.query(sqlStatement, new AppMemberMapper());
   //
   // }
   //
   // public List<Member> getThirdGrade() {
   //
   // String sqlStatement = "select * from membertb where level = 3 order by
   // totalReviewCount desc limit 0,3";
   //
   // return jdbcTemplateObject.query(sqlStatement, new AppMemberMapper());
   //
   // }

}