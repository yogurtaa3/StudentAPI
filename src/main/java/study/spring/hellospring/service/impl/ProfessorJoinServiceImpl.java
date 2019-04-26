//  author : 임형진
//	fileName : 서비스구현평가.pdf
//	content : 교수 서비스 인터페이스 구현체
//	lastUpdate : 2019-01-18

package study.spring.hellospring.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.hellospring.model.ProfessorDepartment;
import study.spring.hellospring.service.ProfessorJoinService;

@Service
public class ProfessorJoinServiceImpl implements ProfessorJoinService {
	
	/** MyBatis의 Mapper를 호출하기 위한 SqlSession 객체 */
	// Spring으로부터 주입받는다.
	// --> import org.springframework.beans.factory.annotation.Autowired;
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public ProfessorDepartment getProfessorJoinItem(ProfessorDepartment professor) throws Exception {
		ProfessorDepartment result = null;
		
		try {
			// ProfessorJoinMapper.selectProfessorJoinItem 기능을 호출한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans 객체
			// 조회 결과가 다중행을 리턴하기 때문에 Beans객체 형태로 리턴된다.
			result = sqlSession.selectOne("ProfessorJoinMapper.selectProfessorJoinItem", professor);
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
	public List<ProfessorDepartment> getProfessorJoinList(ProfessorDepartment professor) throws Exception {
		List<ProfessorDepartment> result = null;
		
		try {
			// ProfessorJoinMapper.selectProfessorJoinItem 기능을 호출한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans 객체
			// 조회 결과가 다중행을 리턴하기 때문에 Beans객체 형태로 리턴된다.
			result = sqlSession.selectList("ProfessorJoinMapper.selectProfessorJoinList", professor);
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
	public int getProfessorCount(ProfessorDepartment professor) throws Exception {
		int result;
		
		try {
			result = sqlSession.selectOne("ProfessorJoinMapper.selectProfessorCount", professor);
		} catch (Exception e) {

			throw new Exception("데이터 조회에 실패했습니다.");
		}
		
		
		return result;
	}
	
}
