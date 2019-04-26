//  author : 임형진
//	fileName : 통합구현 이수자평가.pdf
//	content : 학생 서비스 인터페이스
//	lastUpdate : 2019-01-25


package study.spring.hellospring.service;

import java.util.List;

import study.spring.hellospring.model.Student;

public interface StudentService {
	/**
	 * 학생 등록하기
	 * @param Student 저장할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	//--> import study.spring.hellospring.model.Student;
	public void addStudent(Student student) throws Exception;
	
	/**
	 * 학생 수정하기
	 * @param Student 수정할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	//--> import study.spring.hellospring.model.Student;
	public void editStudent(Student student) throws Exception;
	
	/**
	 * 학생 삭제하기
	 * @param Student 삭제할 학생의 일련번호를 담고 있는 Beans
	 * @throws Exception
	 */
	
	public void deleteStudent(Student student) throws Exception;
	
	
	/**
	 * 학생 등록하기
	 * @param Student 제시할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	
	public Student getStudentItem(Student student) throws Exception;
	
	
	/**
	 * 학생 등록하기
	 * @param Student 제시할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	//--> import java.util.List;
	public List<Student> getStudentList(Student student) throws Exception;
	
	
	
	public int getStudentCount(Student student) throws Exception;
}
