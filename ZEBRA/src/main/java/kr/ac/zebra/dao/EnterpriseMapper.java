package kr.ac.zebra.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.zebra.dto.Enterprise;
import kr.ac.zebra.dto.Member;




public class EnterpriseMapper implements RowMapper<Enterprise> {

	
	public Enterprise mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Enterprise enterprise =new Enterprise();
		

			enterprise.setCompanyName(rs.getString("companyName"));
			enterprise.setEmail(rs.getString("email"));
			enterprise.setPassword(rs.getString("password"));
		
		
		return enterprise;
		
		
		
	}
	
	
	
	
}

