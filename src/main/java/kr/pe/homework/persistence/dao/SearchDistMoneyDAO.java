package kr.pe.homework.persistence.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SearchDistMoneyDAO {

	private Integer seq;
	private Integer token;
	private Integer distSeq;
	private Long allocateAmount;
	private Integer allocateUserSeq;
	private String allocateDate;
	private Integer userSeq;
	private Integer roomSeq;
	private Long distAmount;
	private String createDate;
	private Integer allocatedAmount;
	private Integer allocatedCount;

	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Integer getToken() {
		return token;
	}
	public void setToken(Integer token) {
		this.token = token;
	}
	public Integer getDistSeq() {
		return distSeq;
	}
	public void setDistSeq(Integer distSeq) {
		this.distSeq = distSeq;
	}
	public Long getAllocateAmount() {
		return allocateAmount;
	}
	public void setAllocateAmount(Long allocateAmount) {
		this.allocateAmount = allocateAmount;
	}
	public Integer getAllocateUserSeq() {
		return allocateUserSeq;
	}
	public void setAllocateUserSeq(Integer allocateUserSeq) {
		this.allocateUserSeq = allocateUserSeq;
	}
	public String getAllocateDate() {
		return allocateDate;
	}
	public void setAllocateDate(String allocateDate) {
		this.allocateDate = allocateDate;
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
	public Long getDistAmount() {
		return distAmount;
	}
	public void setDistAmount(Long distAmount) {
		this.distAmount = distAmount;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getAllocatedAmount() {
		return allocatedAmount;
	}
	public void setAllocatedAmount(Integer allocatedAmount) {
		this.allocatedAmount = allocatedAmount;
	}
	public Integer getAllocatedCount() {
		return allocatedCount;
	}
	public void setAllocatedCount(Integer allocatedCount) {
		this.allocatedCount = allocatedCount;
	}
}
