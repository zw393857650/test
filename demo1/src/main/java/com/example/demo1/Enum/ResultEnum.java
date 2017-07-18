package com.example.demo1.Enum;

public enum ResultEnum {
	GIRL1(100,"小学生"),
	GIRL2(101,"中学生"),
	RIGHT(0,"正确"),
	ERROR(-1,"有误"),
	;

	private Integer code;
	private String msg;
	
	
	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
