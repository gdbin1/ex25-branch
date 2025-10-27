package com.gbk.ex25_branch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gbk.ex25_branch", "com.gbk.mybatis"})
@MapperScan(basePackages = "com.gbk.mybatis.mapper")
public class Ex25BranchApplication {

	public static void main(String[] args) { 
		SpringApplication.run(Ex25BranchApplication.class, args);
	}

}
