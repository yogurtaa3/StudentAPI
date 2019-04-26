//  author : 임형진
//	fileName : 통합구현 이수자평가.pdf
//	content : 학생 서비스 인터페이스 구현체
//	lastUpdate : 2019-01-25

package study.spring.hellospring.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.hellospring.model.Student;
import study.spring.hellospring.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {
	
	/** MyBatis의 Mapper를 호출하기 위한 SqlSession 객체 */
	// Spring으로부터 주입받는다.
	// --> import org.springframework.beans.factory.annotation.Autowired;
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addStudent(Student student) throws Exception {
		try {
			// StudentMapper.insertStudentItem 기능을 호출한다.
			// 두 번째 파라미터는 저장할 데이터를 담고 있는 Beans객체
			int result = sqlSession.insert("StudentMapper.insertStudentItem", student);
			
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
	public void editStudent(Student student) throws Exception {
		try {
			// StudentMapper.updateStudentItem 기능을 호출한다.
			// 두 번째 파라미터는 저장할 데이터를 담고 있는 Beans객체
			int result = sqlSession.update("StudentMapper.updateStudentItem", student);
			
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
	public void deleteStudent(Student student) throws Exception {
		try {
			// StudentMapper.deleteStudentItem 기능을 호출한다.
			// 두 번째 파라미터는 삭제할 데이터를 담고 있는 Beans객체
			int result = sqlSession.insert("StudentMapper.deleteStudentItem", student);
			
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
	public Student getStudentItem(Student student) throws Exception {
		Student result = null;
		
		try {
			// StudentMapper.selectStudentItem 기능을 호출한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans 객체
			// 조회 결과가 다중행을 리턴하기 때문에 Beans객체 형태로 리턴된다.
			result = sqlSession.selectOne("StudentMapper.selectStudentItem", student);
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
	public List<Student> getStudentList(Student student) throws Exception {
		List<Student> result = null;
		
		try {
			// StudentMapper.selectStudentItem 기능을 호출한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans 객체
			// 조회 결과가 다중행을 리턴하기 때문에 Beans객체 형태로 리턴된다.
			result = sqlSession.selectList("StudentMapper.selectStudentList", student);
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
	public int getStudentCount(Student student) throws Exception {
		int result;
		
		try {
			result = sqlSession.selectOne("StudentMapper.selectStudentCount", student);
		} catch (Exception e) {

			throw new Exception("데이터 조회에 실패했습니다.");
		}
		
		
		return result;
	}
	
	
	
}
