package kr.ac.zebra.dao;

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
	
	
	
	
	// Querying and returning multiple object
	public List<Product> getPopularProducts() {
		try {
		
			String sqlStatement = "select * from producttb where totalReviewCount >= 2 order by starPoint DESC LIMIT 0, 9";

			return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
			
		}catch (Exception e) {
		
		
		System.out.println("getPopularProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
		e.printStackTrace();
		return null;

	}
																	// Classes

	}
	
	// Querying and returning multiple object
	public List<Product> getMostReviewProducts() {
		try {
		
			String sqlStatement = "select * from producttb where totalReviewCount > 0 order by totalReviewCount DESC LIMIT 0, 10";

			return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
			
		}catch (Exception e) {
		
		
		System.out.println("getMostReviewProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
		e.printStackTrace();
		return null;

	}
																	// Classes

	}
	
	
	// Querying and returning multiple object
	public List<Product> getMostScanProducts() {
		try {
		
			String sqlStatement = "select * from producttb  order by scanCount DESC LIMIT 0, 10;";

			return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous
			
		}catch (Exception e) {
		
		
		System.out.println("getMostScanProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
		e.printStackTrace();
		return null;

	}
																	// Classes

	}
	
	
	
	//----------------------------------------ÀÚ»ç »óÇ°-----------------------------------------
	

	// Querying and returning multiple object
	public List<Product> getHousePopularProducts(String companyName) {
		try {
		
			String sqlStatement = "select * from producttb  where (companyName = ?) and (totalReviewCount > 2) order by starPoint DESC LIMIT 0, 10";

			return jdbcTemplateObject.query(sqlStatement,new Object[] { companyName }, new ProductMapper()); // Anonymous
			
		}catch (Exception e) {
		
		
		System.out.println("getHousePopularProducts DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
		e.printStackTrace();
		return null;

	}
																	// Classes

	}
	
	
	
	

}
