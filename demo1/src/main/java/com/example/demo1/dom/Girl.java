package com.example.demo1.dom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Girl {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String cupSize;
	
	@Min(value=18,message="未成年")
	private Integer age;

	@Override
	public String toString() {
		return "Girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + "]";
	}

	public Girl(Integer id, String cupSize, Integer age) {
		super();
		this.id = id;
		this.cupSize = cupSize;
		this.age = age;
	}

	public Girl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	

}
