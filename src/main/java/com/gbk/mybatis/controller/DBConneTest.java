package com.gbk.mybatis.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DBConneTest {
	
	private static final Logger log = LoggerFactory.getLogger(DBConneTest.class);
	
	@Autowired
	private DataSource dataSource;
	
	@GetMapping("/dbconn")
	public String dbconn() {
		try (Connection conn = dataSource.getConnection()) {
			String result = conn.getMetaData().getURL();
			log.info(result);
			return "DB연결 성공: " + result;
		} catch (Exception e) {
			e.printStackTrace();
			return "DB연결 실패";
		}
	}
	
}
