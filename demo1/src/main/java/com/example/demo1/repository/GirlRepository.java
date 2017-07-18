package com.example.demo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.dom.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer>{

	public List<Girl> findByAge(Integer age);
}
