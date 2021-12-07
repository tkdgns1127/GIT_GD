package com.min.edu.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SignDaoImpl implements ISignDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.dao.SianDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectSign() {
		logger.info("test 실행");
		
		return sqlSession.selectOne(NS+"test");
	}

}
