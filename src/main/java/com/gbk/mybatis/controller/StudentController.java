package com.gbk.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gbk.mybatis.domain.Student;
import com.gbk.mybatis.service.StudentService;

import lombok.RequiredArgsConstructor;








@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;
	
//	list 화면: 전체 학생 목록
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students",studentService.getAllStudent());
		
		return "student/list";
	}
	
//	등록폼:form 화면: 새로운 학생 정보를 입력하기 위한 빈 화면.
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student",new Student());
		return "student/form";
	}
	
//	등록 처리: 학생 정보 기록 후 저장 버튼 클릭을 하면, 학생 정보를 insert
	@PostMapping
	public String create(@ModelAttribute Student student) {
//		이미 학생이 저장이 완료됨
		studentService.createStudent(student);
		return "redirect:/students";
	}
//	http://localhost:8080/students/11/edit
//	수정 폼
	@GetMapping("/{id}/edit")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudent(id));
		return "student/form";
	}
	
	
//	수정 처리:(업데이트)
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}
	
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
	
//	----------자습---------------------------------------------------------------------
//	@GetMapping("/cart")
//	public String viewCart(Model model) {
//		List<Student> cartItems = studentService.getAllStudent();
//		model.addAttribute("students", cartItems);
//		return "cart";
//	}
//	
//	@PostMapping("/{id}/update_quantity")
//	public String selfUpdate(@PathVariable Long id, @ModelAttribute Student studentUpdateData,RedirectAttributes redirectAttributes) {
//		Student existingStudent = studentService.getStudent(id);
//		if(existingStudent != null && studentUpdateData.getAge() != null) {
//			existingStudent.setAge(studentUpdateData.getAge());
//		}
//		studentService.updateStudent(existingStudent);
//		redirectAttributes.addFlashAttribute("message", id + "번 상품의 수량이 업데이트 됨");
//		return "redirect:/students/cart";
//	}
	
//	@PostMapping("/{id}/delete")
//	public String delete1(@PathVariable Long id) {
//		studentService.deleteStudent(id);
//		return "redirect:/students/cart";
//	}
//	
	
	
}
