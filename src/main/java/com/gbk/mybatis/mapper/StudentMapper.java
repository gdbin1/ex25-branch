package com.gbk.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gbk.mybatis.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> findAll();

	Student findById(Long id);
	@Select("INSERT INTO student(NAME, email, age) \r\n"
			+ " VALUES (#{name}, #{email}, #{age})")
	
	
	void insert(Student student);
	@Insert("INSERT INTO student(NAME, email, age) \r\n"
			+ "  	VALUES (#{name}, #{email}, #{age})")
	
	@Options(useGeneratedKeys = true, keyProperty = "id")
	
	void update(Student student);
	@Update("UPDATE student\r\n"
	+ "	SET NAME = #{name}, email = #{email}, age = #{age}\r\n"
	+ "	WHERE id = #{id}")
	
	void delete(Long id);
//	@Delete("DELETE FROM student WHERE id = #{id}")
}
