package kr.ac.zebra.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import kr.ac.zebra.dto.Product;


public class ProductMapper implements RowMapper<Product> {

	
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product =new Product();
		

			product.setBarcode(rs.getString("barcode"));
			product.setCategory(rs.getString("category"));
			product.setCompanyName(rs.getString("companyName"));
			product.setDescription(rs.getString("description"));
			product.setProductName(rs.getString("productName"));
			product.setProductUrl(rs.getString("productUrl"));
			product.setScanCount(rs.getInt("scanCount"));
			product.setStarPoint(rs.getDouble("starPoint"));
			product.setTotalReviewCount(rs.getInt("totalReviewCount"));
			
		
			
		return product;
		
		
		
	}
	
	
	
	
}

