package kr.pe.homework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import kr.pe.homework.common.ResponseObject;
import kr.pe.homework.common.ResultCode;
import kr.pe.homework.model.DistMoneyModel;
import kr.pe.homework.model.RecieveMoneyModel;
import kr.pe.homework.persistence.dao.AllocateDistMoneyDAO;
import kr.pe.homework.persistence.dao.DistMoneyDAO;
import kr.pe.homework.persistence.dao.SearchDistMoneyDAO;
import kr.pe.homework.service.CommonService;
import kr.pe.homework.service.DistMoneyService;
import kr.pe.homework.service.RequestMoneyService;
import kr.pe.homework.service.SearchDistMoneyService;

@RestController
public class MoneyController {

	
	/*
		Introduction
		카카오페이에는 머니 뿌리기 기능이 있습니다.
			● 사용자는 다수의 친구들이 있는 대화방에서 뿌릴 금액과 받아갈 대상의 숫자를 입력하여 뿌리기 요청을 보낼 수 있습니다.
			● 요청 시 자신의 잔액이 감소되고 대화방에는 뿌리기 메세지가 발송됩니다.
			● 대화방에 있는 다른 사용자들은 위에 발송된 메세지를 클릭하여 금액을 무작위로 받아가게 됩니다.
			이번 과제에서는 UI 및 메세지 영역은 제외한 간소화된 REST API를 구현하는 것이 목표입니다.
		
		요구 사항
			● 뿌리기, 받기, 조회 기능을 수행하는 REST API 를 구현합니다.
			○ 요청한 사용자의 식별값은 숫자 형태이며 "X-USER-ID" 라는 HTTP Header로 전달됩니다.
			○ 요청한 사용자가 속한 대화방의 식별값은 문자 형태이며 "X-ROOM-ID" 라는 HTTP Header로 전달됩니다.
			○ 모든 사용자는 뿌리기에 충분한 잔액을 보유하고 있다고 가정하여 별도로 잔액에 관련된 체크는 하지 않습니다.
			● 작성하신 어플리케이션이 다수의 서버에 다수의 인스턴스로 동작하더라도 기능에 문제가 없도록 설계되어야 합니다.
			● 각 기능 및 제약사항에 대한 단위테스트를 반드시 작성합니다.
		
		기술 제약사항
			● 개발 언어는 Java, kotlin, scala 중 익숙한 개발 언어를 선택하여 과제를 진행해주시면
			됩니다.
			● 핵심 문제해결 전략을 간단하게 작성하여 readme.md 파일에 첨부 해 주세요.
			● 데이터베이스 사용에는 제약이 없습니다.
			● API 의 HTTP Method들 (GET | POST | PUT | DEL) 은 자유롭게 선택하세요.
			● 에러응답, 에러코드는 자유롭게 정의해주세요.
		
		평가항목
			과제는 다음 내용을 고려하여 평가 하게 됩니다.
			● 프로젝트 구성 방법 및 관련된 시스템 아키텍쳐 설계 방법이 적절한가?
			● 요구사항을 잘 이해하고 구현하였는가?
			● 작성한 어플리케이션 코드가 간결하고 가독성 좋게 작성되었는가?
			● 작성한 테스트 코드는 적절한 범위의 테스트를 수행하고 있는가?
			● 어플레케이션은 다량의 트래픽에도 무리가 없도록 효율적으로 작성되었는가?
	*/
	
	/*
	1. 뿌리기 API
		● 다음 조건을 만족하는 뿌리기 API를 만들어 주세요.
		(1) 뿌릴 금액, 뿌릴 인원을 요청값으로 받습니다.
		(2) 뿌리기 요청건에 대한 고유 token을 발급하고 응답값으로 내려줍니다.
		(3) token은 3자리 문자열로 구성되며 예측이 불가능해야 합니다.
		(4) 뿌릴 금액을 인원수에 맞게 분배하여 저장합니다. (분배 로직은 자유롭게 구현해 주세요.)
	*/
	
	@Autowired
	private CommonService moneyService;

	@Autowired
	private DistMoneyService distMoneyService;
	
	@Autowired
	private RequestMoneyService requestMoneyService;

	@Autowired
	private SearchDistMoneyService searchDistMoneyService;
	
	
	@PostMapping(value = "/requestDistMoney")
	//@ResponseStatus(value = HttpStatus.OK)
	//(1)
	public ResponseObject<Object> requestDistMoney(
			@RequestHeader(value="X-USER-ID") Integer userSeq,
			@RequestHeader(value="X-ROOM-ID") Integer roomSeq,
			@RequestBody DistMoneyModel distModel) {

		ResponseObject<Object> response = new ResponseObject<>();

		try {
			//roomId
			distModel.setRoomSeq(roomSeq);
			//userId
			distModel.setUserSeq(userSeq);

			//대화방에 속한 사용자인지 확인.
			if(moneyService.checkRoomUser(roomSeq, userSeq)==0) {
				response.setData(distModel);
				response.setMessage(ResultCode.ERROR_CHAT_ROOM_USER.getMsg());
				return response;
			};

			//make token : 
			//(2) 뿌리기 요청건에 대한 고유 token을 발급하고 응답값으로 내려줍니다.
			//(3) token은 3자리 문자열로 구성되며 예측이 불가능해야 합니다.
			distModel.setToken(distMoneyService.makeToken(userSeq));

			//(4) 뿌릴 금액을 인원수에 맞게 분배하여 저장합니다. (분배 로직은 자유롭게 구현해 주세요.)
			distMoneyService.distMoney(distModel);

		}catch(Exception e) {
			e.printStackTrace();
		}

		response.setData(distModel);
		response.setMessage(ResultCode.SUCCESS_DIST.getMsg());
		return response;
	}

	/*
	2. 받기 API
		● 다음 조건을 만족하는 받기 API를 만들어 주세요.
		○ 뿌리기 시 발급된 token을 요청값으로 받습니다.
		○ token에 해당하는 뿌리기 건 중 아직 누구에게도 할당되지 않은 분배건 하나를 API를 호출한 사용자에게 할당하고, 그 금액을 응답값으로 내려줍니다.
		○ 뿌리기 당 한 사용자는 한번만 받을 수 있습니다.
		○ 자신이 뿌리기한 건은 자신이 받을 수 없습니다.
		○ 뿌린기가 호출된 대화방과 동일한 대화방에 속한 사용자만이 받을 수 있습니다.
		○ 뿌린 건은 10분간만 유효합니다. 뿌린지 10분이 지난 요청에 대해서는 받기 실패 응답이 내려가야 합니다.
	 */
	
	@GetMapping(value = "/getMoney")
	//@ResponseStatus(value = HttpStatus.OK)
	public ResponseObject<Object> getMoney(			
			@RequestHeader(value="X-USER-ID") Integer userSeq,
			@RequestHeader(value="X-ROOM-ID") Integer roomSeq,
			@RequestBody RecieveMoneyModel requestModel) {

		ResponseObject<Object> response = new ResponseObject<>();

		try {
			int token = requestModel.getToken();
			//header to model
			requestModel.setRoomSeq(roomSeq);
			requestModel.setUserSeq(userSeq);
			
			List<DistMoneyDAO> distMoneyList = requestMoneyService.getDistMoneyList(token);
			
			//존재하는 뿌리기 정보가 없는경우
			if(distMoneyList.size()==0) {
				response.setData(requestModel);
				response.setMessage(ResultCode.ERROR_DIST_NOT_FOUND.getMsg());
				return response;
			}
			
			//뿌린 건은 10분간만 유효합니다. 뿌린지 10분이 지난 요청에 대해서는 받기 실패 응답이 내려가야 합니다.
			if(requestMoneyService.isExpiredToken(distMoneyList.get(0).getCreateDate())) {
				response.setData(requestModel);
				response.setMessage(ResultCode.ERROR_DIST_TIME_EXPIRE.getMsg());
				return response;
			}
			
			//뿌리기가 호출된 대화방과 동일한 대화방에 속한 사용자만이 받을 수 있습니다.
			if(moneyService.checkRoomUser(roomSeq, userSeq)==0) {
				response.setData(requestModel);
				response.setMessage(ResultCode.ERROR_CHAT_ROOM_USER.getMsg());
				return response;
			};

			//뿌리기 당 한 사용자는 한번만 받을 수 있습니다.
			List<AllocateDistMoneyDAO> allocatedDistMoneyList = requestMoneyService.getUserAllocatedDistMoneyList(token, userSeq);
			if(allocatedDistMoneyList.size() > 0) {
				response.setData(allocatedDistMoneyList);
				response.setMessage(ResultCode.ERROR_RECIEVE_COUNT.getMsg());
				return response;
			};

			//자신이 뿌리기한 건은 자신이 받을 수 없습니다.
			if(requestMoneyService.countDistUser(token, userSeq) > 0) {
				response.setData(requestModel);
				response.setMessage(ResultCode.ERROR_DIST_USER.getMsg());
				return response;
			};
			
			//token에 해당하는 뿌리기 건 중 아직 누구에게도 할당되지 않은 분배건 하나를 API를 호출한 사용자에게 할당하고, 그 금액을 응답값으로 내려줍니다.
			List<AllocateDistMoneyDAO> availableDistList = requestMoneyService.getUnAllocateDistMoneyList(token);
			if(availableDistList.size()>0) {
				AllocateDistMoneyDAO allocateDistMoneyDAO = availableDistList.get(0);
				allocateDistMoneyDAO.setAllocateUserSeq(userSeq);
				requestMoneyService.updateAllocateDistMoney(allocateDistMoneyDAO);
				response.setData(allocateDistMoneyDAO);
			}else {
				
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		response.setMessage(ResultCode.SUCCESS_RECIEVE.getMsg());
		return response;
	}

	/*
	3. 조회 API
		● 다음 조건을 만족하는 조회 API를 만들어 주세요.
		○ 뿌리기 시 발급된 token을 요청값으로 받습니다.
		○ token에 해당하는 뿌리기 건의 현재 상태를 응답값으로 내려줍니다. 현재 상태는 다음의 정보를 포함합니다.
		○ 뿌린 시각, 뿌린 금액, 받기 완료된 금액, 받기 완료된 정보 ([받은 금액, 받은 사용자 아이디] 리스트)
		○ 뿌린 사람 자신만 조회를 할 수 있습니다. 다른사람의 뿌리기건이나 유효하지 않은 token에 대해서는 조회 실패 응답이 내려가야 합니다.
		○ 뿌린 건에 대한 조회는 7일 동안 할 수 있습니다.
	*/
	@GetMapping(value = "/searchRequest")
	//@ResponseStatus(value = HttpStatus.OK)
	public ResponseObject<Object> searchRequest(
			@RequestHeader(value="X-USER-ID") Integer userSeq,
			@RequestBody DistMoneyModel distModel) {

		int token = distModel.getToken();
		ResponseObject<Object> response = new ResponseObject<>();

		//뿌리기 DB 조회
		SearchDistMoneyDAO getDistMoneyStatus = searchDistMoneyService.getDistMoneyStatus(token, userSeq);

		// 뿌린 사람 자신만 조회를 할 수 있습니다. 다른사람의 뿌리기건이나 유효하지 않은 token에 대해서는 조회 실패 응답이 내려가야 합니다.
		if(null == getDistMoneyStatus.getSeq()) {
			response.setData(distModel);
			response.setMessage(ResultCode.ERROR_DIST_SEARCH.getMsg());
			return response;
		}

		// 뿌린 건에 대한 조회는 7일 동안 할 수 있습니다.
		if(searchDistMoneyService.isExpiredSearch(getDistMoneyStatus.getCreateDate())) {
			response.setData(distModel);
			response.setMessage(ResultCode.ERROR_DIST_SEARCH_LIMIT.getMsg());
			return response;
		}

		// 뿌린 시각, 뿌린 금액, 받기 완료된 금액, 받기 완료된 정보 ([받은 금액, 받은 사용자 아이디] 리스트)
		List<SearchDistMoneyDAO> allocatedUserList = searchDistMoneyService.getDistMoneyStatusAllocatedUserList(token, userSeq);
		Map <String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("dist", getDistMoneyStatus);
		resultMap.put("allocated", allocatedUserList);
		response.setData(resultMap);
		response.setMessage(ResultCode.SUCCESS_SEARCH.getMsg());
		return response;
	}
}