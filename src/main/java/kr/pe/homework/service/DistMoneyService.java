package kr.pe.homework.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.homework.model.DistMoneyModel;
import kr.pe.homework.persistence.dao.AllocateDistMoneyDAO;
import kr.pe.homework.persistence.dao.ChatRoomDAO;
import kr.pe.homework.persistence.dao.DistMoneyDAO;
import kr.pe.homework.persistence.dao.TokenDAO;
import kr.pe.homework.persistence.repository.DistMoneyRepository;

@Service
public class DistMoneyService {
	
	@Autowired
	DistMoneyRepository distMoneyRepository;
	
	//TODO: dist
	public void distMoney(DistMoneyModel distModel) throws Exception {

		//dist_info DB 저장
		DistMoneyDAO distMoneyDAO = new DistMoneyDAO(distModel.getToken(), distModel.getUserSeq(), distModel.getRoomSeq(), distModel.getDistAmount());
		distMoneyRepository.insertDistMoneyInfo(distMoneyDAO);

		//(4) 뿌릴 금액을 인원수에 맞게 분배하여 저장합니다. (분배 로직은 자유롭게 구현해 주세요.)
		List<ChatRoomDAO> chatRoomUserList = distMoneyRepository.getChatRoomUserList(distModel.getRoomSeq());
		int userCnt = chatRoomUserList.size();

		//TODO: 분배로직
		long distAmountPerUser = distModel.getDistAmount() / (userCnt-1);
		long distAmount = distModel.getDistAmount();
		long distAmountInput = 0;

		List<AllocateDistMoneyDAO> allocateDistMoneyList = new ArrayList<AllocateDistMoneyDAO>();
		for(int i=0; i<userCnt-1; i++) {
			if(i+2 != userCnt) {
				distAmountInput = distAmountPerUser;
				distAmount = distAmount - distAmountPerUser;
			}else {
				distAmountInput = distAmount;
			}
			allocateDistMoneyList.add(new AllocateDistMoneyDAO(distModel.getToken(), distAmountInput));
		}
		distMoneyRepository.insertAllocateDistMoneyList(allocateDistMoneyList);
	}
	
	public int makeToken(int userSeq) throws Exception {
		Random random = new Random();
		
		int token = random.nextInt(900) + 100;
		
		//TODO : check and recreate token

		distMoneyRepository.tokenSave(new TokenDAO(userSeq, token));
		
		return token;
	}
}
