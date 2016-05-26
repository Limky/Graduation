package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

//@Componentï¿½ë’— ï¿½ì”  ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ?®?‰?‘æ¿¡ï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¹ ä»¥ï¿½ï¿½ë–.
@Component("applyDAO")
public class AppApplyDAO {

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired å¯ƒìŒ?Š¦ typeï¿½ì”  åª›ìˆˆï¿? å¯ƒìŒ?Š¦?‘œï¿? ï§£ì„?”ï¿½ë¸³ï¿½ë–.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public AppApply getApply(String barcode) {

		try {
			String sqlStatement = "select * from producttb where barcode=" + barcode;

			AppApply apply = jdbcTemplateObject.queryForObject(sqlStatement, new AppApplyMapper());

			if (apply.getBarcode().isEmpty()) {

				return null;
			} else {

				return apply;
			}

		} catch (Exception e) {

			System.out.println("getApply DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
			e.printStackTrace();
			return null;

		}

	}

	// Querying and returning multiple object
	public List<AppApply> getApplys() {

		String sqlStatement = "select * from producttb";

		return jdbcTemplateObject.query(sqlStatement, new AppApplyMapper());

	}

	public boolean insertProduct(String id, String barcode, String productName) {

		String sqlStatement = "insert into applytb (barcode, id, productName) values (?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { barcode, id, productName }) == 1);

	}

}
