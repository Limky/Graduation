package kr.ac.zebra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.EnterpriseDAO;
import kr.ac.zebra.dto.Enterprise;

@Service("loginservice") // service로 bean에 등록시켜준다
public class LoginService {

	private EnterpriseDAO enterpriseDAO;

	@Autowired // DI 주입
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	public Enterprise checkEnterprise(String temail, String tpassword) {

		Enterprise enterprise = enterpriseDAO.getEnterprise(temail);

		if (enterprise == null) {

			return null;

		} else {

			String dbpassword = enterprise.getPassword();

			if (dbpassword.equals(tpassword)) {

				return enterprise;
			} else {

				return null;
			}
		}

	}

}
