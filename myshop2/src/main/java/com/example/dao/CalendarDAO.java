package com.example.dao;

import java.util.List;

import com.example.domain.CalendarVO;


public interface CalendarDAO {
	public List<CalendarVO> list(String writer);
	public CalendarVO read(int cno);
	public void insert(CalendarVO vo);
	public void update(CalendarVO vo);
	public void delete(int cno);
}
