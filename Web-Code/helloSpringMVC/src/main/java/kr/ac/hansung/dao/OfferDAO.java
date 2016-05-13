package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component�뒗 �씠 �겢�옒�뒪瑜� �옄�룞�쑝濡� 鍮덉쑝濡� �꽕�젙�빐 以��떎.
@Component("offerDAO")
public class OfferDAO {

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired 寃쎌슦 type�씠 媛숈� 寃쎌슦瑜� 泥섎━�븳�떎.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from enterprise";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);// �븯�굹�쓽
																				// �삤釉뚯젥�듃

	}

	// Querying and returning a single object
	public Offer getOffer(String name) {

		String sqlStatement = "select * from enterprise where email=?";

		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new OfferMapper());

	}

	// Querying and returning multiple object
	public List<Offer> getOffers() {

		String sqlStatement = "select * from enterprise";

		return jdbcTemplateObject.query(sqlStatement, new OfferMapper()); // Anonymous
																			// Classes

	}
	
	public List<Products> getOffers2() {

		String sqlStatement = "select * from producttb";

		return jdbcTemplateObject.query(sqlStatement, new ProductsMapper()); // Anonymous
																			// Classes

	}
	
	public boolean insert(Offer offer){
		
		String email = offer.getEmail();
		String password = offer.getPassword();
		String company = offer.getCompany();
		
		String sqlStatement="insert into enterprise (email, password, company) values (?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{email, password, company})==1);
	}

	
	public boolean update(Offer offer){
		
		int id = offer.getId();
		String email = offer.getEmail();
		String password = offer.getPassword();
		String company = offer.getCompany();
		
		String sqlStatement="update enterprise set email=?, password=?, company=? where id=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{email, password, company, id})==1);
	}
	
	public boolean delete (int id) {
		
		String sqlstatement="delete from enterprise where id=?";
		return(jdbcTemplateObject.update(sqlstatement,new Object[]{id})==1);
	}
	
	

	
}
