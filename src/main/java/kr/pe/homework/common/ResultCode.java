package kr.pe.homework.common;

public enum ResultCode {

	/*
	 * status : 코드
	 * msg : 로그 메시지
	 */
	SUCCESS_DIST            (  "S0000", "뿌리기에 성공했습니다"),
	SUCCESS_RECIEVE 		(  "S0000", "받기에 성공했습니다"),
	SUCCESS_SEARCH 			(  "S0000", "조회에 성공했습니다"),

    ERROR					(  "E0000", "실패했습니다"),
    ERROR_CHAT_ROOM_USER	(  "E0001", "대화방이 존재하지 않거나 대화방에 속한 사용자가 아닙니다"),
    ERROR_DIST_TIME_EXPIRE  (  "E0002", "뿌리기 유효기간이 경과하였습니다"),
    ERROR_DIST_NOT_FOUND	(  "E0003", "뿌리기 정보가 존재하지 않습니다."),
    ERROR_RECIEVE_COUNT		(  "E0004", "뿌리기는 한번만 받을 수 있습니다."),
    ERROR_DIST_USER			(  "E0005", "자신이 뿌린 뿌리기는 받을 수 없습니다"),
    ERROR_DIST_SEARCH		(  "E0006", "자신이 뿌린 뿌리기가 아니거나 유효한 토큰이 아닙니다"),
    ERROR_DIST_SEARCH_LIMIT	(  "E0007", "현재 기준 7일 이내의 뿌리기만 조회 가능합니다"),
    ;

	private final String code;
	private final String msg;

	ResultCode (String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static ResultCode getResultCode(String code) {
		ResultCode result = null;
		for (ResultCode resultCode : ResultCode.values()) {
			if (resultCode.code == code) {
				result = resultCode;
				break;
			}
		}
		return result;
	}
	
	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
