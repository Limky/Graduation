package kr.ac.zebra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.Product;


//@Componentï¿½ë’— ï¿½ì”  ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ?®?‰?‘æ¿¡ï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¹ ä»¥ï¿½ï¿½ë–.
@Component("productDAO")
public class ProductDAO {

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

	// --------------------------------------¼öÁ¤ ¶óÀÎ-------------------------------------------------------------------------//
	// Querying and returning a single object
	public Product getProduct(String barcode) {

		try {
			String sqlStatement = "select * from producttb where barcode=?";

			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { barcode }, new ProductMapper());
		} catch (Exception e) {

			System.out.println("getProduct DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
			e.printStackTrace();
			return null;

		}

	}

	// Querying and returning multiple object
	public List<Product> getProducts() {

		String sqlStatement = "select * from producttb";

		return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
																				// Classes

	}

	public boolean insert(Product product) {

		try{
		 String barcode = product.getBarcode();
		 String productName = product.getCompanyName();
		 String description = product.getDescription();
		 String category = product.getCategory();
		 String productUrl = product.getProductUrl();
		 String companyName = product.getCompanyName();
		 int scanCount = product.getScanCount();
		 int totalReviewCount = product.getTotalReviewCount();
		 double starPoint = product.getStarPoint();
		
	
		String sqlStatement = "insert into producttb (barcode, productName, description, category, productUrl, companyName, scanCount, totalReviewCount, starPoint) values (?,?,?,?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { barcode, productName, description, category, productUrl, companyName, scanCount, totalReviewCount, starPoint }) == 1);
	
		}catch (Exception e) {
		
		System.out.println("insert ProductDAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
		e.printStackTrace();
		return false;
		
	}
	
	}

	public boolean update(Product product) {


		 String barcode = product.getBarcode();
		 String productName = product.getCompanyName();
		 String description = product.getDescription();
		 String category = product.getCategory();
		 String productUrl = product.getProductUrl();
		 String companyName = product.getCompanyName();
		 int scanCount = product.getScanCount();
		 int totalReviewCount = product.getTotalReviewCount();
		 double starPoint = product.getStarPoint();

		String sqlStatement = "update producttb set barcode=?, productName=?, description=?, category=?, productUrl=?, companyName=?, scanCount=?, totalReviewCount=?, starPoint=? where barcode=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { barcode, productName, description, category, productUrl, companyName, scanCount, totalReviewCount, starPoint }) == 1);

	
	
	}

	public boolean delete(int barcode) {

		String sqlstatement = "delete from producttb where barcode=?";
		return (jdbcTemplateObject.update(sqlstatement, new Object[] { barcode }) == 1);
	}
	
	
	
	
	// ÀÎ±â »óÇ°À» °¡Á®¿Â´Ù
	public List<Product> getPopularProducts(String category) {
		try {
			if(category.equals("0")){
				System.out.println("getPopularProducts ¸ğµç »óÇ° ´­·¶À½ DAO");
				String sqlStatement = "select * from producttb where totalReviewCount >= 2 order by starPoint DESC LIMIT 0, 9";
				return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
					
			}else{
				System.out.println("getPopularProducts ¸ğµç»óÇ° ÀÌ¿Ü ´­·¶À½ DAO");
				String sqlStatement = "select * from producttb where totalReviewCount >= 2 and category =" + category +" order by starPoint DESC LIMIT 0, 9";
				return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
			}
						
			
		}catch (Exception e) {
		
		
		System.out.println("getPopularProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
		e.printStackTrace();
		return null;

	}
																	// Classes

	}
	
	// ÃÖ´Ù ¸®ºä¸¦ º¸¿©ÁØ´Ù
	public List<Product> getMostReviewProducts(String category) {
		try {
			if(category.equals("0")){
				System.out.println("getMostReviewProducts ¸ğµç »óÇ° ´­·¶À½ DAO");
			String sqlStatement = "select * from producttb where totalReviewCount > 0 order by totalReviewCount DESC LIMIT 0, 10";
			return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
		
			}else{
				System.out.println("getMostReviewProducts ¸ğµç»óÇ° ÀÌ¿Ü ´­·¶À½ DAO");
				String sqlStatement = "select * from producttb where totalReviewCount > 0 and category =" + category +" order by totalReviewCount DESC LIMIT 0, 10";
				return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
				
			}			
		}catch (Exception e) {
		
		
		System.out.println("getMostReviewProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
		e.printStackTrace();
		return null;

	}
																	// Classes

	}
	
	
	// ÃÖ´Ù ½ºÄµÀ» °¡Á®¿Â´Ù.
	public List<Product> getMostScanProducts(String category) {
		try {
		
			if(category.equals("0")){
			
			System.out.println("getMostScanProducts ¸ğµç »óÇ° ´­·¶À½ DAO");
			String sqlStatement = "select * from producttb  order by scanCount DESC LIMIT 0, 10;";

			return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
			}
			else{
				
			System.out.println("getMostScanProducts ¸ğµç »óÇ° ÀÌ¿Ü ´­·¶À½ DAO");
			String sqlStatement = "select * from producttb  where  category =" + category +" order by scanCount DESC LIMIT 0, 10;";
			return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous	
				
			}
			
		}catch (Exception e) {
		
		
		System.out.println("getMostScanProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
		e.printStackTrace();
		return null;

	}
																	// Classes

	}
	
	public List<Product> getSearchProduct(String keyword) {
	      try {
	         String sqlStatement = "select * from producttb where productName like '%" + keyword + "%'";

	         return jdbcTemplateObject.query(sqlStatement, new ProductMapper());
	      } catch (Exception e) {
	         System.out.println("getMostScanProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
	         e.printStackTrace();
	         return null;

	      }
	   }
	
	
	
	 public List<Integer> getProductCount(String barcode) {

	      List<Integer> count = new ArrayList<Integer>();
	      int percentage = 0;

	      String sqlStatMent = "select sum(totalReviewCount) from producttb where barcode = ?";

	      count.add(jdbcTemplateObject.queryForInt(sqlStatMent, new Object[] { barcode }));

	      sqlStatMent = "select sum(scanCount) from producttb where barcode = ?";

	      count.add(jdbcTemplateObject.queryForInt(sqlStatMent, new Object[] { barcode }));

	      percentage = count.get(0) * 100 / count.get(1);
	      count.add(percentage);

	      System.out.println("product=" + count);

	      return count;
	   }
	
	
	

}
