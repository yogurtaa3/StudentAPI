package study.spring.hellospring;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import study.spring.hellospring.model.Professor;
import study.spring.hellospring.service.ProfessorService;
import study.spring.helper.WebHelper;

@Controller
public class ProfessorApi {

	private static final Logger logger = LoggerFactory.getLogger(ProfessorApi.class);
	
	/** 사용하고자 하는 Helper + Service 객체 주입 설정 */
	
	@Autowired
	WebHelper web;
	
	@Autowired
	ProfessorService professorService;
	
	/** 교수 목록 API */
	@ResponseBody
	@RequestMapping(value="/professor_api/professorSelectListApi", method=RequestMethod.GET)
	public void professorSelectListApi(Locale locale, Model model, HttpServletResponse response) {
		/** 1) WebHelper 초기화 + 컨텐츠 형식 지정 */
		web.init();
		
		/** 2) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		List<Professor> item = null;
		
		try {
			item = professorService.getProfessorList(null);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return;
		}
		
		/** 3) 처리 결과를 JSON으로 출력하기 */
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("item", item);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	/** 교수 상세 API */
	@ResponseBody
	@RequestMapping(value="/professor_api/professorSelectItemApi", method=RequestMethod.GET)
	public void professorSelectItemApi(Locale locale, Model model, HttpServletResponse response) {
		
		/** 1) WebHelper 초기화 + 컨텐츠 형식 지정 */
		web.init();
		response.setContentType("application/json");
		
		/** 2) 파라미터 받기 및 유효성 검사 */
		int profno = web.getInt("profno");
		logger.debug("profno=" + profno);
		
		if (profno == 0) {
			web.printJsonRt("교수번호가 없습니다.");
			return;
		}
		
		// 전달받은 파라미터를 Beans로 구성
		Professor professor = new Professor();
		professor.setProfno(profno);
		
		/** 3) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		Professor item = null;
		
		try {
			item = professorService.getProfessorItem(professor);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
				
		/** 4) 처리 결과를 JSON으로 출력하기 */
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("item", item);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}
	
	/** 교수 정보 등록 API */
	@ResponseBody
	@RequestMapping(value="/professor_api/professorInsertApi", method=RequestMethod.POST)
	public void professorInsertApi(Locale locale, Model model, HttpServletResponse response) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		
		/** 2) 파라미터 받기 및 유효성 검사 */
		String name = web.getString("name");
		String userid = web.getString("user_id");
		String position = web.getString("position");
		int sal = web.getInt("sal");
		int comm = web.getInt("comm");
		String hiredate = web.getString("hiredate");
		int deptno = web.getInt("deptno");
		
		// 전달 받은 파라미터는 로그로 값을 확인하는 것이 좋다.
		logger.debug("name=" + name);
		logger.debug("userid=" + userid);
		logger.debug("position=" + position);
		logger.debug("sal=" + sal);
		logger.debug("comm=" + comm);
		logger.debug("hiredate=" + hiredate);
		logger.debug("deptno=" + deptno);
		
		// 필수항복 유효성 검사
		
		if (name == null) {
			web.printJsonRt("이름을 입력하세요");
			return;
		}
		
		if (userid == null) {
			web.printJsonRt("아이디를 입력하세요");
			return;
		}
		
		if (position == null) {
			web.printJsonRt("직급을 입력하세요");
			return;
		}
		
		if (sal == 0) {
			web.printJsonRt("급여를 입력하세요");
			return;
		}
		
		
		if (hiredate == null) {
			web.printJsonRt("입사일을 입력하세요");
			return;
		}
		
		if (deptno == 0) {
			web.printJsonRt("학과번호를 입력하세요");
			return;
		}
		
		// 파라미터 빈즈 구성
		Professor professor = new Professor();
		professor.setName(name);
		professor.setUserid(userid);
		professor.setPosition(position);
		professor.setSal(sal);
		professor.setComm(comm);
		professor.setHiredate(hiredate);	
		professor.setDeptno(deptno);
		
		/** 3) Service를 통한 SQL 수행 */
		try {
		
				professorService.addProfessor(professor);
			
			
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return;
		}
		
		
		/** 4) 처리 결과를 JSON으로 출력하기 */
		web.printJsonRt("OK");
	}
	
	/** 교수 삭제 API */
	@ResponseBody
	@RequestMapping(value="/professor_api/professorDeleteApi", method=RequestMethod.POST)
	public void professorDeleteApi(Locale locale, Model model, HttpServletResponse response) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		response.setContentType("application/json");
		
		/** 2) 파라미터 받기 및 유효성 검사 */
		
		int profno = web.getInt("profno");
		
		// 전달 받은 파라미터는 로그로 값을 확인하는 것이 좋다.
		
		logger.debug("profno=" + profno);
		
		// 필수항복 유효성 검사
		
		if (profno == 0) {
			web.printJsonRt("교수번호가 없습니다.");
			return;
		}
		
		
		
		// 파라미터 빈즈 구성
		Professor professor = new Professor();
			
		professor.setProfno(profno);
		
		/** 3) Service를 통한 SQL 수행 */
		try {
		
				professorService.deleteProfessor(professor);
			
			
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return;
		}
		
		
		/** 4) 처리 결과를 JSON으로 출력하기 */
		web.printJsonRt("OK");
	}
	
	/** 교수 수정 API */
	@ResponseBody
	@RequestMapping(value="/professor_api/professorEditApi", method=RequestMethod.POST)
	public void professorEditApi(Locale locale, Model model, HttpServletResponse response) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		response.setContentType("application/json");
		/** 2) 파라미터 받기 및 유효성 검사 */
		int profno = web.getInt("profno");
		String name = web.getString("name");
		String userid = web.getString("user_id");
		String position = web.getString("position");
		int sal = web.getInt("sal");
		int comm = web.getInt("comm");
		String hiredate = web.getString("hiredate");
		int deptno = web.getInt("deptno");
		
		// 전달 받은 파라미터는 로그로 값을 확인하는 것이 좋다.
		logger.debug("profno=" + profno);
		logger.debug("name=" + name);
		logger.debug("userid=" + userid);
		logger.debug("position=" + position);
		logger.debug("sal=" + sal);
		logger.debug("comm=" + comm);
		logger.debug("hiredate=" + hiredate);
		logger.debug("deptno=" + deptno);
		
		// 필수항복 유효성 검사
		
		if (profno == 0) {
			web.printJsonRt("교수번호가 없습니다.");
			return;
		}
		
		if (name == null) {
			web.printJsonRt("이름을 입력하세요");
			return;
		}
		
		if (userid == null) {
			web.printJsonRt("아이디를 입력하세요");
			return;
		}
		
		if (position == null) {
			web.printJsonRt("직급을 입력하세요");
			return;
		}
		
		if (sal == 0) {
			web.printJsonRt("급여를 입력하세요");
			return;
		}
		
		
		if (hiredate == null) {
			web.printJsonRt("입사일을 입력하세요");
			return;
		}
		
		if (deptno == 0) {
			web.printJsonRt("학과번호를 입력하세요");
			return;
		}
		
		// 파라미터 빈즈 구성
		Professor professor = new Professor();
		professor.setProfno(profno);
		professor.setName(name);
		professor.setUserid(userid);
		professor.setPosition(position);
		professor.setSal(sal);
		professor.setComm(comm);
		professor.setHiredate(hiredate);	
		professor.setDeptno(deptno);
		
		/** 3) Service를 통한 SQL 수행 */
		try {
				professorService.editProfessor(professor);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return;
		}
		
		
		/** 4) 처리 결과를 JSON으로 출력하기 */
		web.printJsonRt("OK");
	
	}

	
	
	
	
	
	
}
