package com.example.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.CalendarDAO;
import com.example.domain.CalendarVO;


@Controller
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	CalendarDAO dao;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public void insert(CalendarVO vo) {
		dao.insert(vo);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	@ResponseBody
	public CalendarVO read(int cno) {
		return dao.read(cno);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public void delete(int cno) {

		dao.delete(cno);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<CalendarVO> list(String writer) {
		List<CalendarVO> list = new ArrayList<>();
		list=dao.list(writer);
		return list;
	}
	
}
