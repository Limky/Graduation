package kr.ac.zebra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.Product;

//@Componentï¿½ë’— ï¿½ì”  ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ?®?‰?‘æ¿¡ï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¹ ä»¥ï¿½ï¿½ë–.
@Component("ourProductDAO")
public class OurProductDAO {

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired å¯ƒìŒ?Š¦ typeï¿½ì”  åª›ìˆˆï¿? å¯ƒìŒ?Š¦?‘œï¿? ï§£ì„?”ï¿½ë¸³ï¿½ë–.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from producttb";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);// ï¿½ë¸¯ï¿½êµ¹ï¿½ì“½
																				// ï¿½ì‚¤?‡‰?š¯? ¥ï¿½ë“ƒ

	}

	// --------------------------------------¼öÁ¤
	// ¶óÀÎ-------------------------------------------------------------------------//

	// ----------------------------------------ÀÚ»ç
	// »óÇ°-----------------------------------------

	// Querying and returning multiple object
	public List<Product> getOurAllProducts(String companyName) {
		try {

			String sqlStatement = "select * from producttb  where companyName = ? order by totalReviewCount DESC LIMIT 0, 10";

			return jdbcTemplateObject.query(sqlStatement, new Object[] { companyName }, new ProductMapper()); // Anonymous

		} catch (Exception e) {

			System.out.println("getAllProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
			e.printStackTrace();
			return null;

		}

	}

	// Querying and returning multiple object
	public List<Product> getOurPopularityProducts(String companyName) {
		try {

			System.out.println("ourProductDAO getOurPopularityProducts Á¢±Ù ¼º°ø");
			String sqlStatement = "select * from producttb where ( companyName = ? ) and ( totalReviewCount >= 2 ) order by starPoint DESC";
			return jdbcTemplateObject.query(sqlStatement, new Object[] { companyName }, new ProductMapper()); // Anonymous

		} catch (Exception e) {

			System.out.println("ourProductDAO getOurPopularityProducts ¿¹¿Ü Ã³¸® ¹ß»ı  ");
			e.printStackTrace();
			return null;

		}
		// Classes

	}

	// Querying and returning multiple object
	public List<Product> getOurMostReviewProducts(String companyName) {
		try {

			System.out.println("ourProductDAO getOurMostReviewProducts Á¢±Ù ¼º°ø");
			String sqlStatement = "select * from producttb where companyName = ? and totalReviewCount > 0 order by totalReviewCount DESC";
			return jdbcTemplateObject.query(sqlStatement, new Object[] { companyName }, new ProductMapper()); // Anonymous

		} catch (Exception e) {

			System.out.println("ourProductDAO getOurMostReviewProducts ¿¹¿Ü Ã³¸® ¹ß»ı");
			e.printStackTrace();
			return null;

		}

	}

	// Querying and returning multiple object
	public List<Product> getOurMostScanProducts(String companyName) {
		try {

			System.out.println("ourProductDAO getOurMostScanProducts Á¢±Ù ¼º°ø");
			String sqlStatement = "select * from producttb where companyName = ? order by scanCount DESC";
			return jdbcTemplateObject.query(sqlStatement, new Object[] { companyName }, new ProductMapper()); // Anonymous

		} catch (Exception e) {

			System.out.println("ourProductDAO getOurMostScanProducts ¿¹¿Ü Ã³¸® ¹ß»ı");
			e.printStackTrace();
			return null;

		}

	}
	
	public List<Integer> getCompanyCount(String companyName) {

	      List<Integer> count = new ArrayList<Integer>();
	      int percentage = 0;

	      String sqlStatMent = "select sum(totalReviewCount) from producttb where companyName = ?";

	      count.add(jdbcTemplateObject.queryForInt(sqlStatMent, new Object[] { companyName }));

	      sqlStatMent = "select sum(scanCount) from producttb where companyName = ?";

	      count.add(jdbcTemplateObject.queryForInt(sqlStatMent, new Object[] { companyName }));

	      percentage = count.get(0) * 100 / count.get(1);
	      count.add(percentage);

	      System.out.println("company=" + count);

	      return count;
	   }

	  

}
