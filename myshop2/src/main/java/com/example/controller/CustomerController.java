package com.example.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.CustomerDAO;
import com.example.domain.Criteria;
import com.example.domain.CustomerVO;
import com.example.domain.PageMaker;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerDAO dao;
	
	@RequestMapping("/list")
	public String customerList(Model model) {
		model.addAttribute("pageName", "customer/list.jsp");
		return "home";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public HashMap<String, Object> customerListJSON(Criteria cri){
		HashMap<String, Object> map = new HashMap<>();
		cri.setPerPageNum(5);
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setDisplayPageNum(5);
		pm.setTotalCount(dao.count(cri));
		
		map.put("pm", pm);
		map.put("list", dao.list(cri));
		return map;
	}
}
