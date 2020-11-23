package kr.pe.homework.persistence.dao;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TokenDAO {

	private int seq;
	private int userSeq;
	private int token;
	private String createDate;

	public TokenDAO (int userSeq, int token){
		this.userSeq = userSeq;
		this.token = token;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUser_seq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreate_date(String createDate) {
		this.createDate = createDate;
	}
}
