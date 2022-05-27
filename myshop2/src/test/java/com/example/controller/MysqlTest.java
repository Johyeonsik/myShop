package com.example.controller;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.CalendarDAO;
import com.example.dao.MysqlDAO;
import com.example.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)  //SpringJUnit4ClassRunner.class를 먼저 import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlTest {
    @Autowired
    private CalendarDAO dao;
    
    @Test
    public void getTime(){
    	String writer = "mozzi";
    	dao.list(writer);
    }
}
