package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

@Component("appApplyDAO")
public class AppApplyDAO {

	private JdbcTemplate jdbcTemplateObject;

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

			System.out.println("getApply DAO 예외 처리 발생 획인 메세지 ");
			return null;

		}

	}

	public List<AppApply> getApplys() {

		String sqlStatement = "select * from producttb";

		return jdbcTemplateObject.query(sqlStatement, new AppApplyMapper());

	}

	public boolean insertProduct(String id, String barcode, String productName) {

		String sqlStatement = "insert into applytb (barcode, id, productName) values (?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { barcode, id, productName }) == 1);

	}

}
