package kr.pe.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.homework.persistence.dao.ChatRoomDAO;
import kr.pe.homework.persistence.repository.DistMoneyRepository;


@Service
public class CommonService {

	@Autowired
	DistMoneyRepository distMoneyRepository;
	
	//roomSeq : roomSeq 에 속한 유저인지 체크
	public int checkRoomUser(Integer roomSeq, Integer userSeq) throws Exception{
		return distMoneyRepository.getChatRoomUserCheck(new ChatRoomDAO(roomSeq, userSeq));
	}

}
