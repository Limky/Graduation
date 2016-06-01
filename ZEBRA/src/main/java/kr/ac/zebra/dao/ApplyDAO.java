package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

@Component("applyDAO")
public class ApplyDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<AppApply> getApplys() {

		String sqlStatement = "select * from applytb";

		return jdbcTemplateObject.query(sqlStatement, new AppApplyMapper());

	}

	public boolean DeleteApplyTb(String barcode) {

		try {
			String sqlstatement = "delete from applytb where barcode=?";
			return (jdbcTemplateObject.update(sqlstatement, new Object[] { barcode }) == 1);
		} catch (Exception e) {

			System.out.println("DeleteApplyTb DAO 예외 처리 발생 획인 메세지 ");
			e.printStackTrace();
			return false;

		}

	}

}
