package kr.pe.homework.persistence.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DistMoneyDAO {

	private int seq;
	private int token;
	private int userSeq;
	private int roomSeq;
	private long distAmount;
	private String createDate;

	public DistMoneyDAO () {
	}
		
	public DistMoneyDAO (int token) {
		this.token = token;
	}

	public DistMoneyDAO (int token, int userSeq) {
		this.token = token;
		this.userSeq = userSeq;
	}
	
	public DistMoneyDAO (int token, int userSeq, int roomSeq, long distAmount) {
		this.token = token;
		this.userSeq = userSeq;
		this.roomSeq = roomSeq;
		this.distAmount = distAmount;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getRoomSeq() {
		return roomSeq;
	}

	public void setRoomSeq(int roomSeq) {
		this.roomSeq = roomSeq;
	}

	public long getDistAmount() {
		return distAmount;
	}

	public void setDistAmount(long distAmount) {
		this.distAmount = distAmount;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
