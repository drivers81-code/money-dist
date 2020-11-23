package kr.pe.homework.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResponseObject<T> {

	@JsonInclude(value = Include.NON_NULL)
	private Integer total;

	@JsonInclude(value = Include.NON_NULL)
	private T data;

	@JsonInclude(value = Include.NON_NULL)
	private String message;

	public ResponseObject() {
	}

	public ResponseObject(T data) {
		this.data = data;
	}

	public ResponseObject(Integer total) {
		this.total = total;
	}

	public ResponseObject(T data, Integer total) {
		this.total = total;
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//@Override
	//public String toString() {
	//	return ToStringBuilder.reflectionToString(this, NotNullToStringStyle.NOT_NULL_STYLE);
	//}

}
