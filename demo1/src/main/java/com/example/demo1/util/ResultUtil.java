package com.example.demo1.util;

import com.example.demo1.dom.Result;

public class ResultUtil {

	public static Result success(Object object) {
		Result result=new Result();
		result.setCode(0);
		result.setMsg("正确");
		result.setDate(object);
		return result;
	}
	public static Result success() {
		return success(null);
	}
	
	public static Result error(Integer code,String msg) {
		Result result=new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
