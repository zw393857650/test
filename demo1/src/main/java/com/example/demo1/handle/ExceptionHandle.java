package com.example.demo1.handle;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.demo1.GirlException.GirlException;
import com.example.demo1.dom.Result;
import com.example.demo1.util.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if(e instanceof GirlException) {
		  GirlException girlException=(GirlException) e;
		  return ResultUtil.error(girlException.getCode(),girlException.getMessage());
		}
		return ResultUtil.error(-1,"未知错误");
	}

}
