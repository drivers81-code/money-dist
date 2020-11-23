package kr.pe.homework.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RecieveMoneyModel {
	private Long distAmount;
	private Integer distUserCount;
	private Integer userSeq;
	private Integer roomSeq;
	private Integer token;

	public Long getDistAmount() {
		return distAmount;
	}
	public void setDistAmount(Long distAmount) {
		this.distAmount = distAmount;
	}
	public Integer getDistUserCount() {
		return distUserCount;
	}
	public void setDistUserCount(Integer distUserCount) {
		this.distUserCount = distUserCount;
	}
	public Integer getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}
	public Integer getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(Integer roomSeq) {
		this.roomSeq = roomSeq;
	}
	public Integer getToken() {
		return token;
	}
	public void setToken(Integer token) {
		this.token = token;
	}

}
