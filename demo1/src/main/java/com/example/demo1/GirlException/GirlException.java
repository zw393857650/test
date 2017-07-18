package com.example.demo1.GirlException;

import com.example.demo1.Enum.ResultEnum;

public class GirlException extends RuntimeException{

	private Integer code;

	public GirlException(ResultEnum girlEnum) {
		super(girlEnum.getMsg());
		this.code =girlEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
