//  author : 임형진
//	fileName : 통합구현 이수자평가.pdf
//	content : 교수 서비스 인터페이스 구현체
//	lastUpdate : 2019-01-25



package study.spring.hellospring.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.hellospring.model.Professor;
import study.spring.hellospring.model.Student;
import study.spring.hellospring.service.ProfessorService;
@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	/** MyBatis의 Mapper를 호출하기 위한 SqlSession 객체 */
	// Spring으로부터 주입받는다.
	// --> import org.springframework.beans.factory.annotation.Autowired;
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public void addProfessor(Professor professor) throws Exception {
		try {
			// ProfessorMapper.insertProfessorItem 기능을 호출한다.
			// 두 번째 파라미터는 저장할 데이터를 담고 있는 Beans객체
			int result = sqlSession.insert("ProfessorMapper.insertProfessorItem", professor);
			
			// 리턴값의 저장된 행의 수
			if (result == 0) {
				// 저장된 행이 없다면 강제로 예외를 발생시킨다.
				// --> 이 예외를 처리 가능한 catch 블록으로 제어가 이동한다.
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {

			System.out.println("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			// 에러가 발생했으므로 SQL 수행 내역을 되돌림
			System.out.println(e.getLocalizedMessage());
			System.out.println("데이터 저장에 실패했습니다.");
			return;
		} 
		
	}
	
	
	@Override
	public void editProfessor(Professor professor) throws Exception {
		try {
			// ProfessorMapper.updateProfessorItem 기능을 호출한다.
			// 두 번째 파라미터는 저장할 데이터를 담고 있는 Beans객체
			int result = sqlSession.update("ProfessorMapper.updateProfessorItem", professor);
			
			// 리턴값의 저장된 행의 수
			if (result == 0) {
				// 저장된 행이 없다면 강제로 예외를 발생시킨다.
				// --> 이 예외를 처리 가능한 catch 블록으로 제어가 이동한다.
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {

			System.out.println("변경된 데이터가 없습니다.");
		} catch (Exception e) {
			// 에러가 발생했으므로 SQL 수행 내역을 되돌림
			System.out.println(e.getLocalizedMessage());
			System.out.println("데이터 수정에 실패했습니다.");
			return;
		} 
		
	}

	@Override
	public void deleteProfessor(Professor professor) throws Exception {
			
		Student student = new Student();
		try {
			// ProfessorMapper.deleteProfessorItem 기능을 호출한다.
			// 두 번째 파라미터는 삭제할 데이터를 담고 있는 Beans객체
			sqlSession.delete("StudentMapper.deleteStudentByProfno", student);
			int result = sqlSession.delete("ProfessorMapper.deleteProfessorItem", professor);
			
			// 리턴값의 저장된 행의 수
			if (result == 0) {
				// 저장된 행이 없다면 강제로 예외를 발생시킨다.
				// --> 이 예외를 처리 가능한 catch 블록으로 제어가 이동한다.
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {

			System.out.println("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			// 에러가 발생했으므로 SQL 수행 내역을 되돌림
			System.out.println(e.getLocalizedMessage());
			System.out.println("데이터 삭제에 실패했습니다.");
			return;
		} 
		
	}

	@Override
	public Professor getProfessorItem(Professor professor) throws Exception {
		Professor result = null;
		
		try {
			// ProfessorMapper.selectProfessorItem 기능을 호출한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans 객체
			// 조회 결과가 다중행을 리턴하기 때문에 Beans객체 형태로 리턴된다.
			result = sqlSession.selectOne("ProfessorMapper.selectProfessorItem", professor);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 데이터가 없습니다.");		
		} catch (Exception e) {

			System.out.println("데이터 조회에 실패했습니다.");			
		}
		return result;
	}

	@Override
	public List<Professor> getProfessorList(Professor professor) throws Exception {
		List<Professor> result = null;
		
		try {
			// ProfessorMapper.selectProfessorItem 기능을 호출한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans 객체
			// 조회 결과가 다중행을 리턴하기 때문에 Beans객체 형태로 리턴된다.
			result = sqlSession.selectList("ProfessorMapper.selectProfessorList", professor);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 데이터가 없습니다.");		
		} catch (Exception e) {

			System.out.println("데이터 조회에 실패했습니다.");			
		}
		
		return result;
	}
	
	
	
}
