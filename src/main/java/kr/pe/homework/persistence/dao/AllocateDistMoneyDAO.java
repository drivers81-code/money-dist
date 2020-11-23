package kr.pe.homework.persistence.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AllocateDistMoneyDAO {

	private int seq;
	private int token;
	private int distSeq;
	private long allocateAmount;
	private int allocateUserSeq;
	private String allocateDate;
	
	public AllocateDistMoneyDAO() {
	
	}

	public AllocateDistMoneyDAO(int allocateUserSeq) {
		this.allocateUserSeq = allocateUserSeq;
	}

	public AllocateDistMoneyDAO(int token, long distAmountInput) {
		this.token = token;
		this.allocateAmount = distAmountInput;
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

	public int getDistSeq() {
		return distSeq;
	}

	public void setDistSeq(int distSeq) {
		this.distSeq = distSeq;
	}

	public long getAllocateAmount() {
		return allocateAmount;
	}

	public void setAllocateAmount(long allocateAmount) {
		this.allocateAmount = allocateAmount;
	}

	public int getAllocateUserSeq() {
		return allocateUserSeq;
	}

	public void setAllocateUserSeq(int allocateUserSeq) {
		this.allocateUserSeq = allocateUserSeq;
	}

	public String getAllocateDate() {
		return allocateDate;
	}

	public void setAllocateDate(String allocateDate) {
		this.allocateDate = allocateDate;
	}

}
