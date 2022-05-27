package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CalendarVO;

@Repository
public class CalendarDAOImpl implements CalendarDAO{
	
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.CalendarMapper";

	@Override
	public List<CalendarVO> list(String writer) {
		return session.selectList(namespace + ".list", writer);
	}

	@Override
	public CalendarVO read(int cno) {
		return session.selectOne(namespace + ".read", cno);
	}

	@Override
	public void insert(CalendarVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void update(CalendarVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int cno) {
		session.delete(namespace + ".delete", cno);
		
	}


	
}
