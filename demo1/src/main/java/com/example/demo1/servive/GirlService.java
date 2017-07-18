package com.example.demo1.servive;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo1.Enum.ResultEnum;
import com.example.demo1.GirlException.GirlException;
import com.example.demo1.dom.Girl;
import com.example.demo1.repository.GirlRepository;

@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
    @Transactional
	public void insertTwo(String cupSize,Integer age) {
    	Girl girl=new Girl();
    	girl.setCupSize(cupSize);
    	girl.setAge(age);
    	girlRepository.save(girl);
    	
    	Girl girl2=new Girl();
    	girl2.setCupSize(cupSize);
    	girl2.setAge(age-2);
    	girlRepository.save(girl2);
    }
    
    public void getAge(Integer id) throws Exception{
    	Girl girl=girlRepository.findOne(id);
    	Integer age=girl.getAge();
    	if(age<14) {
    		throw new GirlException(ResultEnum.GIRL1);
    	}else if(age>14&&age<18) {
    		throw new GirlException(ResultEnum.GIRL2);
    	}
    }
}
