package kr.ac.zebra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.AppMemberDAO;
import kr.ac.zebra.dao.EnterpriseDAO;
import kr.ac.zebra.dto.Enterprise;
import kr.ac.zebra.dto.Member;

@Service("loginservice") // service로 bean에 등록시켜준다
public class LoginService {

	private EnterpriseDAO enterpriseDAO;
	private AppMemberDAO memberDAO;

	@Autowired // DI 주입
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	@Autowired
	public void setMemberDAO(AppMemberDAO memberDAO) {
		this.memberDAO = memberDAO;
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

	// ------------------------안드로이드-------------------------------

	public Member checkMember(String id, String password) {

		Member member = memberDAO.getMember(id);

		if (member == null) {

			return null;

		} else {

			String dbpassword = member.getPassword();

			if (dbpassword.equals(password)) {

				return member;
			} else {

				return null;
			}
		}

	}

}
