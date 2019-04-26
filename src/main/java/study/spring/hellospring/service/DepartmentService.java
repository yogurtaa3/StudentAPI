//  author : 임형진
//	fileName : 통합구현 이수자평가.pdf
//	content : 학과 서비스 인터페이스
//	lastUpdate : 2019-01-25

package study.spring.hellospring.service;

import java.util.List;

import study.spring.hellospring.model.Department;
import study.spring.hellospring.model.Professor;
import study.spring.hellospring.model.Student;

public interface DepartmentService {
	/**
	 * 학생 등록하기
	 * @param Department 저장할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	//--> import study.spring.hellospring.model.Department;
	public void addDepartment(Department department) throws Exception;
	
	/**
	 * 학생 수정하기
	 * @param Department 수정할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	//--> import study.spring.hellospring.model.Department;
	public void editDepartment(Department department) throws Exception;
	
	/**
	 * 학생 삭제하기
	 * @param Department 삭제할 학생의 일련번호를 담고 있는 Beans
	 * @throws Exception
	 */
	
	public void deleteDepartment(Department department, Professor professor, Student student) throws Exception;
	
	
	/**
	 * 학생 조회하기
	 * @param Department 제시할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	
	public Department getDepartmentItem(Department department) throws Exception;
	
	
	/**
	 * 학생목록 조회하기
	 * @param Department 제시할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	//--> import java.util.List;
	public List<Department> getDepartmentList(Department department) throws Exception;
	
	
	/**
	 * 학생목록 조회하기
	 * @param Department 제시할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	//--> import java.util.List;
	public List<Department> getDepartmentAddList(Department department) throws Exception;
	/**
	 * 전체 목록 수 조회
	 * @return 조회 결과
	 * @throws Exception
	 */
	public int getDepartmentCount(Department department) throws Exception;
	
	
}
