package kr.ac.zebra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.zebra.dao.MemberDAO;
import kr.ac.zebra.dto.Member;

@Service
public class PowerReviewerService {
	private MemberDAO memberDAO;

	@Autowired // DI ¡÷¿‘
	public void MemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public List<Member> getFirstGrade() {

		List<Member> fistGrade = memberDAO.getFirstGrade();

		return fistGrade;
	}

	public List<Member> getSecondGrade() {

		List<Member> secondGrade = memberDAO.getSecondGrade();

		return secondGrade;
	}

	public List<Member> getThirdGrade() {

		List<Member> thirdGrade = memberDAO.getThirdGrade();

		return thirdGrade;
	}

}
