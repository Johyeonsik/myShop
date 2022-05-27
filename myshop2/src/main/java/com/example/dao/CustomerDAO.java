package com.example.dao;

import java.util.List;

import com.example.domain.Criteria;
import com.example.domain.CustomerVO;

public interface CustomerDAO {
	public List<CustomerVO> list(Criteria cri);
	public int count(Criteria cri);
	public CustomerVO read(int cus_no);
	public void insert(CustomerVO vo);
	public void update(CustomerVO vo);
}
