package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dom.Girl;
import com.example.demo1.repository.GirlRepository;
import com.example.demo1.servive.GirlService;



@RestController
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	//插入
	@PostMapping(value="/girls")
	public Girl girladd(@RequestParam(value="cupSize") String cupSize,
			             @RequestParam(value="age") Integer age) {
		Girl girl=new Girl();
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
	}
	//查询
	@GetMapping(value="/girls")
	public List<Girl> girlall() {
		return girlRepository.findAll();
	}
	//修改
	@PutMapping(value="girls/{id}")
	public Girl girlput(@PathVariable(value="id")Integer id,
			            @RequestParam(value="cupSize")String cupSize,
			            @RequestParam(value="age")Integer age){
		Girl girl=new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
	}
	//删除
	@DeleteMapping(value="girls/{id}")
	public void girlDelete(@PathVariable(value="id")Integer id) {
		girlRepository.delete(id);
	}
	//自定义方法，按照年龄来查询s
	@GetMapping(value="girls/age/{age}")
	public List<Girl> girlAge(@PathVariable(value="age")Integer age){
		return girlRepository.findByAge(age);
	}
	//自定义方法,同时插入两条数据
	@PostMapping(value="girls/two")
	public void girltwo(@RequestParam(value="cupSize")String cupSize,
			            @RequestParam(value="age")Integer age) {
		girlService.insertTwo(cupSize, age);
		
	}
	@GetMapping(value="girls/getAge/{id}")
	public void girlage(@PathVariable("id")Integer id) throws Exception{
		girlService.getAge(id);
	}
	
	//分页查询

		@PostMapping(value="/girls/fen")
		public Page<Girl> girlsfenye(@RequestParam(value="page",defaultValue="0")Integer page,
				                                   @RequestParam(value="pageSize",defaultValue="5")Integer pageSize) {

			Sort sort=new Sort(Sort.Direction.DESC,"age");
			Pageable pageable=new PageRequest(page,pageSize,sort);
			return girlRepository.findAll(pageable);
		}
	
}
