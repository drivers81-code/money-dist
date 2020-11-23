package kr.pe.homework.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.homework.persistence.dao.SearchDistMoneyDAO;
import kr.pe.homework.persistence.repository.DistMoneyRepository;

@Service
public class SearchDistMoneyService {

	@Autowired
	DistMoneyRepository distMoneyRepository;
	
	public SearchDistMoneyDAO getDistMoneyStatus(int token, int userSeq){
		
		SearchDistMoneyDAO searchDistMoneyDAO = new SearchDistMoneyDAO();
		searchDistMoneyDAO.setToken(token);
		searchDistMoneyDAO.setUserSeq(userSeq);
		return distMoneyRepository.getDistMoneyStatus(searchDistMoneyDAO);
	}
	
	public List<SearchDistMoneyDAO> getDistMoneyStatusAllocatedUserList(int token, int userSeq){
		
		SearchDistMoneyDAO searchDistMoneyDAO = new SearchDistMoneyDAO();
		searchDistMoneyDAO.setToken(token);
		searchDistMoneyDAO.setUserSeq(userSeq);
		return distMoneyRepository.getDistMoneyStatusAllocatedUserList(searchDistMoneyDAO);
	}
	
	public boolean isExpiredSearch(String datetime) {
		LocalDateTime expireDate = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).plusDays(7); 
		//LocalDateTime expireDate = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).plusMinutes(1);
		return expireDate.isBefore(LocalDateTime.now());
	}
}
