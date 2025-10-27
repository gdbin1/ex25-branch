package com.gbk.ex25_branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Ex25BranchApplication {

	public static void main(String[] args) { 
		SpringApplication.run(Ex25BranchApplication.class, args);
	}

}
