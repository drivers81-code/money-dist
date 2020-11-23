package kr.pe.homework.persistence.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.pe.homework.persistence.dao.AllocateDistMoneyDAO;
import kr.pe.homework.persistence.dao.ChatRoomDAO;
import kr.pe.homework.persistence.dao.DistMoneyDAO;
import kr.pe.homework.persistence.dao.SearchDistMoneyDAO;
import kr.pe.homework.persistence.dao.TokenDAO;

@Mapper
public interface DistMoneyRepository {
	int tokenSave(TokenDAO tokenDAO);
	List<ChatRoomDAO> getChatRoomUserList(int roomSeq);
	int getChatRoomUserCheck(ChatRoomDAO chatRoomDAO);

	int insertDistMoneyInfo(DistMoneyDAO distMoneyDAO);
	void insertAllocateDistMoneyList(@Param("allocateDistMoneyList")  List<AllocateDistMoneyDAO> allocateDistMoneyList);
	              
	
	List<DistMoneyDAO> getDistMoneyList(DistMoneyDAO distMoneyDAO);

	long allocateDistMoney(DistMoneyDAO distMoney);
	
	List<AllocateDistMoneyDAO> getUserAllocatedDistMoneyList(AllocateDistMoneyDAO allocateDistMoneyDAO);
	List<AllocateDistMoneyDAO> getUnAllocateDistMoneyList(int seq);
	
	
	int countDistUser(DistMoneyDAO distMoneyDAO);
	int updateAllocateDistMoney(AllocateDistMoneyDAO allocatedDistMoneyDAO);

	//search
	SearchDistMoneyDAO getDistMoneyStatus(SearchDistMoneyDAO searchDistMoneyDAO);
	List<SearchDistMoneyDAO> getDistMoneyStatusAllocatedUserList(SearchDistMoneyDAO searchDistMoneyDAO);

}
