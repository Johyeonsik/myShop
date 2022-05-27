package com.example.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDAO dao;
	
	//��й�ȣ ��ȣȭ
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@Resource(name="uploadPath")
	String path;
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("pageName", "user/login.jsp");
		return "/home";
	}
	@RequestMapping("/insert")
	public String insert(Model model){
		model.addAttribute("pageName", "user/insert.jsp");
		return "/home";
	}
	
	@RequestMapping("/update")
	public String update(Model model, String id){
		model.addAttribute("vo",dao.read(id));
		model.addAttribute("pageName", "user/update.jsp");
		return "/home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePost(UserVO vo){
		
		//�н����� ��ȣȭ�Ͽ� �н����忡 �־��ֱ�
		String password = passEncoder.encode(vo.getPass());
		vo.setPass(password);
		dao.update(vo);
		return "redirect:/user/list";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertPost(UserVO vo){

		//�н����� ��ȣȭ�Ͽ� �н����忡 �־��ֱ�
		String password = passEncoder.encode(vo.getPass());
		vo.setPass(password);
		dao.insert(vo);

		return "redirect:/user/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public int loginPost(String id, String pass, HttpSession session){
		int result = 0;			//���̵� ���°��
		
		UserVO vo = dao.read(id);
		if(vo != null) {		//���̵� ���翩��
			if(passEncoder.matches(pass, vo.getPass())) {		//�α��� ����
			
				result=1;
				session.setAttribute("id", id);
				session.setAttribute("name", vo.getName());
			}else {				//�н����尡 �ٸ����
				result=2;
				
			}
		}
		return result;
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("list", dao.list());
		model.addAttribute("pageName", "user/list.jsp");
		return "/home";
	}
}
