package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.Criteria;
import com.example.domain.CustomerVO;
import com.example.domain.UserVO;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.CustomerMapper";

	@Override
	public List<CustomerVO> list(Criteria cri) {
		return session.selectList(namespace + ".list", cri);
	}
	@Override
	public int count(Criteria cri) {
		return session.selectOne(namespace +".count",cri);
	}

	@Override
	public CustomerVO read(int cus_no) {
		return session.selectOne(namespace + ".read", cus_no);
	}

	@Override
	public void insert(CustomerVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void update(CustomerVO vo) {
		session.update(namespace + ".update", vo);
	}


	
}
