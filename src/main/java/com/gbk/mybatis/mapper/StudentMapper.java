package com.gbk.mybatis.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Options;

import com.gbk.mybatis.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> findAll();

	Student findById(Long id);
	
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Student student);

	void update(Student student);

	void delete(Long id);
}
