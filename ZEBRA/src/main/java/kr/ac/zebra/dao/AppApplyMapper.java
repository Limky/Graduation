package kr.ac.zebra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.zebra.dto.AppApply;

public class AppApplyMapper implements RowMapper<AppApply> {

	public AppApply mapRow(ResultSet rs, int rowNum) throws SQLException {

		AppApply apply = new AppApply();

		apply.setBarcode(rs.getString("barcode"));
		apply.setId(rs.getString("id"));
		apply.setProductName(rs.getString("productName"));

		return apply;
	}
}
