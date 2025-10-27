package com.gbk.mybatis.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Select;

import com.gbk.mybatis.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> findAll();

	Student findById(Long id);
//	@Select("SELECT * FROM student WHERE id = #{id}")
//	Student findById(Long id);
	
	
	void insert(Student student);
//	@Insert("INSERT INTO student(NAME, email, age) \r\n"
//			+ " 	VALUES (#{name}, #{email}, #{age})")
//	@Options(useGeneratedKeys = true, keyProperty = "id")
//	void insert(Student student);

	void update(Student student);

	void delete(Long id);
}
