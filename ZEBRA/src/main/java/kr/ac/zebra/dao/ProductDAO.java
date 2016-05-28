package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

@Component("productDAO")
public class ProductDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Product getProduct(String barcode) {

		System.out.println("Product DAO");

		try {
			String sqlStatement = "select * from producttb where barcode=?";

			Product product = jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { barcode },
					new ProductMapper());

			if (product.getBarcode().isEmpty()) {

				return null;
			} else {

				return product;
			}

		} catch (Exception e) {

			System.out.println("getProduct DAO 예외 처리 발생 획인 메세지 ");

			return null;

		}
	}

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
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { barcode, productName, description, category,
				productUrl, companyName, scanCount, totalReviewCount, starPoint }) == 1);

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
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { barcode, productName, description, category,
				productUrl, companyName, scanCount, totalReviewCount, starPoint }) == 1);
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

		} catch (Exception e) {

			System.out.println("getPopularProducts DAO 예외 처리 발생 획인 메세지 ");
			return null;

		}

	}

	public List<Product> getMostReviewProducts() {
		try {

			String sqlStatement = "select * from producttb where totalReviewCount > 0 order by totalReviewCount DESC LIMIT 0, 10";

			return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous

		} catch (Exception e) {

			System.out.println("getMostReviewProducts DAO 예외 처리 발생 획인 메세지 ");
			return null;

		}

	}

	public List<Product> getMostScanProducts() {
		try {

			String sqlStatement = "select * from producttb  order by scanCount DESC LIMIT 0, 10;";

			return jdbcTemplateObject.query(sqlStatement, new ProductMapper()); // Anonymous

		} catch (Exception e) {

			System.out.println("getMostScanProducts DAO 예외 처리 발생 획인 메세지 ");
			return null;
		}
	}

	public List<Product> getSearchProduct(String keyword) {

		try {
			String sqlStatement = "select * from producttb where productName like '%" + keyword + "%'";

			return jdbcTemplateObject.query(sqlStatement, new ProductMapper());
		} catch (Exception e) {
			System.out.println("getMostScanProducts DAO 예외 처리 발생 획인 메세지 ");
			return null;

		}
	}

	public List<Product> getCategoryProducts(String category) {
		try {
			String sqlStatement = "select * from producttb where category=" + category;

			return jdbcTemplateObject.query(sqlStatement, new ProductMapper());
		} catch (Exception e) {

			return null;
		}

	}

	public Boolean isExit(String barcode) {

		System.out.println("DAO isExit()");
		try {
			String sqlStatement = "select * from applytb where barcode=?";

			List<AppApply> apply = jdbcTemplateObject.query(sqlStatement, new Object[] { barcode },
					new AppApplyMapper());

			System.out.println(apply);

			if (apply == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
