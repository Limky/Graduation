package kr.ac.zebra.dao;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.zebra.dto.Member;

//@Componentï¿½ë’— ï¿½ì”  ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ?®?‰?‘æ¿¡ï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¹ ä»¥ï¿½ï¿½ë–.
@Component("memberDAO")
public class MemberDAO {

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired å¯ƒìŒ?Š¦ typeï¿½ì”  åª›ìˆˆï¿? å¯ƒìŒ?Š¦?‘œï¿? ï§£ì„?”ï¿½ë¸³ï¿½ë–.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	// ---------------------------------------------------------------------------------------------------------------//
	// Querying and returning a single object
	public Member getMember(String id) {

		try {
			String sqlStatement = "select * from membertb where id=?";

			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { id }, new MemberMapper());
		} catch (Exception e) {

			System.out.println("DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö ");
			e.printStackTrace();
			return null;

		}

	}

	// Querying and returning multiple object
	public List<Member> getMembers() {

		String sqlStatement = "select * from membertb";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper()); // Anonymous
																			// Classes
	}

	public List<Member> getFirstGrade() {

		String sqlStatement = "select * from membertb where level = 1 order by totalReviewCount desc limit 0,3";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper());

	}

	public List<Member> getSecondGrade() {

		String sqlStatement = "select * from membertb where level = 2 order by totalReviewCount desc limit 0,3";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper());

	}

	public List<Member> getThirdGrade() {

		String sqlStatement = "select * from membertb where level = 3 order by totalReviewCount desc limit 0,3";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper());

	}
}
