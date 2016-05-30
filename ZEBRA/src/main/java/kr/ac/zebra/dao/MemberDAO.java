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

		String sqlStatement = "select * from membertb where level = 'Gold' order by totalReviewCount desc limit 0,3";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper());

	}
	
	public List<Member> getSecondGrade() {

		String sqlStatement = "select * from membertb where level = 'Silver' order by totalReviewCount desc limit 0,3";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper());

	}
	
	public List<Member> getThirdGrade() {

		String sqlStatement = "select * from membertb where level = 'Bronze' order by totalReviewCount desc limit 0,3";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper());

	}
}

/*
 * public int getRowCount() { String sqlStatement =
 * "select count(*) from member"; return
 * jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);// ï¿½ë¸¯ï¿½êµ¹ï¿½ì“½
 * // ï¿½ì‚¤?‡‰?š¯? ¥ï¿½ë“ƒ
 * 
 * }
 * 
 * //
 * -----------------------------------------------------------------------------
 * ----------------------------------// // Querying and returning a single
 * object public Member getMember(String id) {
 * 
 * try { String sqlStatement = "select * from membertb where id=?";
 * 
 * return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { id },
 * new MemberMapper()); } catch (Exception e) {
 * 
 * System.out.println("DAO ¿¹¿Ü Ã³¸® ¹ß»ı È¹ÀÎ ¸Ş¼¼Áö "); e.printStackTrace(); return null;
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * public boolean insert(Member member) {
 * 
 * String id = member.getId(); String password = member.getPassword(); String
 * name = member.getName(); String memberUrl = member.getMemberUrl(); String
 * lastReviewDate = member.getLastReviewDate(); String phoneNumber =
 * member.getPhoneNumber(); int point = member.getPoint(); int level =
 * member.getLevel(); int reviewCount = member.getReviewCount(); int
 * totalReivewCount = member.getTotalReivewCount();
 * 
 * String sqlStatement =
 * "insert into membertb (id, password, name, memberUrl, lastReviewDate, phoneNumber, point, level, reviewCount, totalReivewCount) values (?,?,?,?,?,?,?,?,?,?)"
 * ; return (jdbcTemplateObject.update(sqlStatement, new Object[] { id,
 * password, name, memberUrl, lastReviewDate, phoneNumber, point, level,
 * reviewCount, totalReivewCount }) == 1); }
 * 
 * public boolean update(Member member) {
 * 
 * String id = member.getId(); String password = member.getPassword(); String
 * name = member.getName(); String memberUrl = member.getMemberUrl(); String
 * lastReviewDate = member.getLastReviewDate(); String phoneNumber =
 * member.getPhoneNumber(); int point = member.getPoint(); int level =
 * member.getLevel(); int reviewCount = member.getReviewCount(); int
 * totalReivewCount = member.getTotalReivewCount();
 * 
 * String sqlStatement =
 * "update membertb set id=?, password=?, name=?, memberUrl=?, lastReviewDate=?, phoneNumber=?, point=?, level=?, reviewCount=?, totalReivewCount=? where id=?"
 * ; return (jdbcTemplateObject.update(sqlStatement, new Object[] { id,
 * password, name, memberUrl, lastReviewDate, phoneNumber, point, level,
 * reviewCount, totalReivewCount }) == 1); }
 * 
 * public boolean delete(int id) {
 * 
 * String sqlstatement = "delete from membertb where id=?"; return
 * (jdbcTemplateObject.update(sqlstatement, new Object[] { id }) == 1); }
 * 
 * }
 */