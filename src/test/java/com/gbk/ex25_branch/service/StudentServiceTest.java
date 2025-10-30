package com.gbk.ex25_branch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.gbk.ex25_branch.domain.StudentTest;
import com.gbk.ex25_branch.mapper.StudentMapperTest;

//@SpringBootTest
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentServiceTest {

	@Autowired
	private StudentMapperTest studentMapperTest;

//	@Test
//	@DisplayName("학생 등록후 조회 확인(TDD)")
//	void testRegisterAndFind() {
//	}

//	@Test3
//	@DisplayName("학생 전체 조회 (TDD)")
//	void testFindAll() {
////		given
//		StudentTest s3 = StudentTest.builder().name("홍길동3").email("hong3@test.com").age(23).build();
//		StudentTest s4 = StudentTest.builder().name("홍길동4").email("hong4@test.com").age(23).build();
//		
//		studentMapperTest.insert(s3);
//		studentMapperTest.insert(s4);
//		
////		when
//		List<StudentTest> students = studentMapperTest.findAll();
//		
////		then
////		assertTrue(students.size() >= 2);
//		
////		assertEquals("이영희", students.get(0).getName());
//	}

	@Test
	@DisplayName("학생 전체 조회 (TDD)")
	void testFindAll() {
		// given
		StudentTest s3 = StudentTest.builder().name("홍길동3").email("hong3@test.com").age(23).build();
		StudentTest s4 = StudentTest.builder().name("홍길동4").email("hong4@test.com").age(24).build();
		studentMapperTest.insert(s3);
		studentMapperTest.insert(s4);

		// when
		List<StudentTest> students = studentMapperTest.findAll();
		System.out.println("--- DB 조회 결과 ---");
	    students.forEach(s -> System.out.println(s.getName() + ", " + s.getEmail()));
	    System.out.println("--------------------");
//		 then
		assertTrue(students.size() >= 2);
//		 스스로 수정해보자
		assertEquals("홍길동4", students.get(0).getName()); // 최신순
//		assertEquals("이영희", students.get(0).getName()); // 최신순
	}
}
