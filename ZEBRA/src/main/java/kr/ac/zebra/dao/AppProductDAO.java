package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

@Component("appProductDAO")
public class AppProductDAO {

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
					new AppProductMapper());

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

		return jdbcTemplateObject.query(sqlStatement, new AppProductMapper());
	}

	public List<Product> getSearchProduct(String keyword) {

		try {
			String sqlStatement = "select * from producttb where productName like '%" + keyword + "%'";

			return jdbcTemplateObject.query(sqlStatement, new AppProductMapper());
		} catch (Exception e) {
			System.out.println("getMostScanProducts DAO 예외 처리 발생 획인 메세지 ");
			return null;

		}
	}

	public List<Product> getCategoryProducts(String category) {
		try {
			String sqlStatement = "select * from producttb where category= ?";

			return jdbcTemplateObject.query(sqlStatement, new Object[] { category }, new AppProductMapper());
		} catch (Exception e) {

			return null;
		}

	}

	public Boolean isExit(String barcode) {

		try {
			String sqlStatement = "select * from applytb where barcode=?";

			AppApply apply = jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { barcode },
					new AppApplyMapper());

			return true;

		} catch (Exception e) {

			return false;
		}
	}

	public void setAvarageStarPoint(String barcode) {
		double sum;
		double count;
		double avarage;
		String sqlStatement = "select sum(starPoint) from reviewtb where barcode=?";
		sum = jdbcTemplateObject.queryForInt(sqlStatement, new Object[] { barcode });

		System.out.println("sum =" + sum);
		if (sum == 0.0) {
		} else {

			sqlStatement = "select count(if(barcode=?, barcode, null)) from reviewtb where barcode = ?";
			count = jdbcTemplateObject.queryForInt(sqlStatement, new Object[] { barcode, barcode });

			avarage = (double) (sum / count);

			sqlStatement = "update producttb set starpoint=? where barcode=?";
			jdbcTemplateObject.update(sqlStatement, new Object[] { avarage, barcode });
		}

	}

}
