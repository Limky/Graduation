package kr.ac.zebra.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.Enterprise;
import kr.ac.zebra.dto.Member;


	//@Componentï¿½ë’— ï¿½ì”  ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ?®?‰?‘æ¿¡ï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¹ ä»¥ï¿½ï¿½ë–.
	@Component("enterpriseDAO")
	public class EnterpriseDAO {

		private JdbcTemplate jdbcTemplateObject;

		// @Autowired å¯ƒìŒ?Š¦ typeï¿½ì”  åª›ìˆˆï¿? å¯ƒìŒ?Š¦?‘œï¿? ï§£ì„?”ï¿½ë¸³ï¿½ë–.
		@Autowired
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		}

		public int getRowCount() {
			String sqlStatement = "select count(*) from member";
			return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);// ï¿½ë¸¯ï¿½êµ¹ï¿½ì“½
																					// ï¿½ì‚¤?‡‰?š¯? ¥ï¿½ë“ƒ

		}
	//--------------------------------------¼öÁ¤ ¶óÀÎ-------------------------------------------------------------------------//
		// Querying and returning a single object
		public Enterprise getEnterprise(String email) {
			
		
			try {
				String sqlStatement = "select * from enterprisetb where email=?";

				return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { email }, new EnterpriseMapper());
			}catch (Exception e) {
			    
				System.out.println("DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
				e.printStackTrace();
				return null;
				
			}
		

		}

		// Querying and returning multiple object
		public List<Enterprise> getEnterprises() {

			String sqlStatement = "select * from enterprisetb";

			return jdbcTemplateObject.query(sqlStatement, new EnterpriseMapper()); // Anonymous
																				// Classes

		}

		public boolean insert(Enterprise enterprise){
			
			 String companyName = enterprise.getCompanyName();
			 String email = enterprise.getEmail();
			 String password = enterprise.getPassword();
			 
			 
				
					
			String sqlStatement="insert into enterprisetb (companyName, email, password) values (?,?,?)";
			return (jdbcTemplateObject.update(sqlStatement, new Object[]{companyName, email, password})==1);
		}

		
		public boolean update(Enterprise enterprise){
			
			
			 String companyName = enterprise.getCompanyName();
			 String email = enterprise.getEmail();
			 String password = enterprise.getPassword();
			 
			 
			String sqlStatement="update enterprisetb set companyName=?, email=?, password=? where email=?";
			return (jdbcTemplateObject.update(sqlStatement, new Object[]{companyName, email, password, email})==1);
		}
		
		public boolean delete (int email) {
			
			String sqlstatement="delete from enterprisetb where email=?";
			return(jdbcTemplateObject.update(sqlstatement,new Object[]{email})==1);
		}
		
		

		
	}

	
	
	
	
	
