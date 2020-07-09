package com.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.data.TestDaoInter;

@Controller
public class TestController {
	@Autowired
	private TestDaoInter dao;
	
	@GetMapping("/")
	public String list() {
		return "/test/testlist";
	}
	
	@GetMapping("/insertform")
	public String insertform() {
		return "/test/testinput";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam String name) {
		dao.insertTest(name);
		return "redirect:insertform";
	}

}
