package kr.pe.homework.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.pe.homework.persistence.dao.AllocateDistMoneyDAO;
import kr.pe.homework.persistence.dao.DistMoneyDAO;
import kr.pe.homework.persistence.repository.DistMoneyRepository;


@Service
public class RequestMoneyService {

	@Autowired
	DistMoneyRepository distMoneyRepository;
	
	public List<DistMoneyDAO> getDistMoneyList(int token){
		return distMoneyRepository.getDistMoneyList(new DistMoneyDAO(token));
	}

	public List<AllocateDistMoneyDAO> getUserAllocatedDistMoneyList(int token, int userSeq){
		AllocateDistMoneyDAO allocateDistMoneyDAO = new AllocateDistMoneyDAO();
		allocateDistMoneyDAO.setToken(token);
		allocateDistMoneyDAO.setAllocateUserSeq(userSeq);
		System.out.println("getUserAllocatedDistMoneyList token : " + token);
		System.out.println("getUserAllocatedDistMoneyList userSeq : " + userSeq);
		return distMoneyRepository.getUserAllocatedDistMoneyList(allocateDistMoneyDAO);
	}
	
	public List<AllocateDistMoneyDAO> getUnAllocateDistMoneyList(int token){
		return distMoneyRepository.getUnAllocateDistMoneyList(token);
	}

	public boolean isExpiredToken(String datetime) {

		LocalDateTime expireDate = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).plusMinutes(10); 

		if(expireDate.isAfter(LocalDateTime.now())) {
			return false;
		}else {
			return true;
		}
	}

	public int countDistUser(int token, int userSeq){
		return distMoneyRepository.countDistUser(new DistMoneyDAO (token, userSeq));
	}
	
	public int updateAllocateDistMoney(AllocateDistMoneyDAO allocateDistMoneyDAO){
		return distMoneyRepository.updateAllocateDistMoney(allocateDistMoneyDAO);
	}
	

	
}
