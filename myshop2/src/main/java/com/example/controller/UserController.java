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
	
	//비밀번호 암호화
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
		
		//패스워드 암호화하여 패스워드에 넣어주기
		String password = passEncoder.encode(vo.getPass());
		vo.setPass(password);
		dao.update(vo);
		return "redirect:/user/list";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertPost(UserVO vo){

		//패스워드 암호화하여 패스워드에 넣어주기
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
		int result = 0;			//아이디가 없는경우
		
		UserVO vo = dao.read(id);
		if(vo != null) {		//아이디 존재여부
			if(passEncoder.matches(pass, vo.getPass())) {		//로그인 성공
			
				result=1;
				session.setAttribute("id", id);
				session.setAttribute("name", vo.getName());
			}else {				//패스워드가 다른경우
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
