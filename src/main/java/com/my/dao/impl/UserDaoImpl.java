package com.my.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.IUserDao;
import com.my.entity.User;

@Repository
public class UserDaoImpl implements IUserDao{
	
	@Autowired
	private SqlSession sqlSession;

	public User findById(String id) {
		return sqlSession.selectOne("com.my.dao.mapper.UserMapper.selectUser", id);
	}
	
	@Transactional
	public void saveUser(User user) {
		sqlSession.insert("com.my.dao.mapper.UserMapper.saveUser", user);
	}
	
}
