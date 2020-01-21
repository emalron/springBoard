package com.emalron.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/dataSource-context.xml"})
public class MysqlConnectionTest {
	private static final Logger logger = LoggerFactory.getLogger(MysqlConnectionTest.class);
	
	@Inject
	private DataSource ds;
	
	@Test
	public void db������_�ȴ�() {
		try (Connection conn = ds.getConnection()) {
			logger.info("\n Mysql ����: " + conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Inject
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void sessionFactory_��ü��_�ִ�() {
		logger.info("\n Session Factory: " + sessionFactory);
	}
	
	@Test
	public void sqlSession_��ü��_factory����_�����ȴ�() {
		try(SqlSession session = sessionFactory.openSession()) {
			logger.info("\n SQL session: " + session);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
