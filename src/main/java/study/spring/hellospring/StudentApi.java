/**
 * 작성자: 임형진
 * 파일명: 통합구현 이수자평가.pdf
 * 파일내용: Student Api 컨트롤러
 * 최중수정일: 2019-01-25
 */

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

import study.spring.hellospring.model.Student;
import study.spring.hellospring.service.StudentService;
import study.spring.helper.WebHelper;



@Controller
public class StudentApi {
	
	
private static final Logger logger = LoggerFactory.getLogger(StudentApi.class);
	
	/** 사용하고자 하는 Helper + Service 객체 주입 설정 */
	
	@Autowired
	WebHelper web;
	
	@Autowired
	StudentService studentService;
	
	/** 교수 목록 API */
	@ResponseBody
	@RequestMapping(value="/student_api/studentSelectListApi", method=RequestMethod.GET)
	public void studentSelectListApi(Locale locale, Model model, HttpServletResponse response) {
		/** 1) WebHelper 초기화 + 컨텐츠 형식 지정 */
		web.init();
		
		/** 2) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		List<Student> item = null;
		
		try {
			item = studentService.getStudentList(null);
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
	@RequestMapping(value="/student_api/studentSelectItemApi", method=RequestMethod.GET)
	public void studentSelectItemApi(Locale locale, Model model, HttpServletResponse response) {
		
		/** 1) WebHelper 초기화 + 컨텐츠 형식 지정 */
		web.init();
		response.setContentType("application/json");
		
		/** 2) 파라미터 받기 및 유효성 검사 */
		int studno = web.getInt("studno");
		logger.debug("studno=" + studno);
		
		if (studno == 0) {
			web.printJsonRt("학생번호가 없습니다.");
			return;
		}
		
		// 전달받은 파라미터를 Beans로 구성
		Student student = new Student();
		student.setStudno(studno);
		
		/** 3) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		Student item = null;
		
		try {
			item = studentService.getStudentItem(student);
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
	@RequestMapping(value="/student_api/studentInsertApi", method=RequestMethod.POST)
	public void studentInsertApi(Locale locale, Model model, HttpServletResponse response) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		response.setContentType("application/json");
		
		/** 2) 파라미터 받기 및 유효성 검사 */
		String name = web.getString("name");
		String userid = web.getString("user_id");
		int grade = web.getInt("grade");
		String idnum = web.getString("idnum");
		String birthdate = web.getString("birthdate");
		String tel = web.getString("tel");
		int height = web.getInt("height");
		int weight = web.getInt("weight");
		int deptno = web.getInt("deptno");
		int profno = web.getInt("profno");
		
		// 전달 받은 파라미터는 로그로 값을 확인하는 것이 좋다.
		logger.debug("name=" + name);
		logger.debug("userid=" + userid);
		logger.debug("grade=" + grade);
		logger.debug("idnum=" + idnum);
		logger.debug("birthdate=" + birthdate);
		logger.debug("tel=" + tel);
		logger.debug("height=" + height);
		logger.debug("weight=" + weight);
		logger.debug("deptno=" + deptno);
		logger.debug("profno=" + profno);
		
		// 필수항복 유효성 검사
		
		if (name == null) {
			web.redirect(null, "이름을 입력하세요");
			return;
		}
		
		if (userid == null) {
			web.redirect(null, "아이디를 입력하세요");
			return;
		}
		
		if (grade == 0) {
			web.redirect(null, "학년을 입력하세요");
			return;
		}
		
		if (idnum == null) {
			web.redirect(null, "주민번호를 입력하세요");
			return;
		}
		
		
		if (tel == null) {
			web.redirect(null, "전화번호를 입력하세요");
			return;
		}
		
		if (height == 0) {
			web.redirect(null, "키를 입력하세요");
			return;
		}
		
		if (weight == 0) {
			web.redirect(null, "몸무게를 입력하세요");
			return;
		}
		
		if (deptno == 0) {
			web.redirect(null, "학과를 선택하세요");
			return;
		}
		
		// 파라미터 빈즈 구성
		Student student = new Student();
		student.setName(name);
		student.setUserid(userid);
		student.setGrade(grade);
		student.setIdnum(idnum);
		student.setBirthdate(birthdate);
		student.setTel(tel);
		student.setHeight(height);
		student.setWeight(weight);
		student.setDeptno(deptno);
		student.setProfno(profno);
		
		/** 3) Service를 통한 SQL 수행 */
		try {
		
				studentService.addStudent(student);
			
			
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return;
		}
		
		
		/** 4) 처리 결과를 JSON으로 출력하기 */
		web.printJsonRt("OK");
	}
	
	/** 교수 삭제 API */
	@ResponseBody
	@RequestMapping(value="/student_api/studentDeleteApi", method=RequestMethod.POST)
	public void studentDeleteApi(Locale locale, Model model, HttpServletResponse response) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		response.setContentType("application/json");
		
		/** 2) 파라미터 받기 및 유효성 검사 */
		
		int studno = web.getInt("studno");
		
		// 전달 받은 파라미터는 로그로 값을 확인하는 것이 좋다.
		
		logger.debug("studno=" + studno);
		
		// 필수항복 유효성 검사
		
		if (studno == 0) {
			web.printJsonRt("학생번호가 없습니다.");
			return;
		}
		
		
		
		// 파라미터 빈즈 구성
		Student student = new Student();
			
		student.setStudno(studno);
		
		/** 3) Service를 통한 SQL 수행 */
		try {
		
				studentService.deleteStudent(student);
			
			
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return;
		}
		
		
		/** 4) 처리 결과를 JSON으로 출력하기 */
		web.printJsonRt("OK");
	}
	
	/** 교수 수정 API */
	@ResponseBody
	@RequestMapping(value="/student_api/studentEditApi", method=RequestMethod.POST)
	public void studentEditApi(Locale locale, Model model, HttpServletResponse response) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		response.setContentType("application/json");
		
		/** 2) 파라미터 받기 및 유효성 검사 */
		int studno = web.getInt("studno");
		String name = web.getString("name");
		String userid = web.getString("user_id");
		int grade = web.getInt("grade");
		String idnum = web.getString("idnum");
		String birthdate = web.getString("birthdate");
		String tel = web.getString("tel");
		int height = web.getInt("height");
		int weight = web.getInt("weight");
		int deptno = web.getInt("deptno");
		int profno = web.getInt("profno");
		
		// 전달 받은 파라미터는 로그로 값을 확인하는 것이 좋다.
		logger.debug("studno=" + studno);
		logger.debug("name=" + name);
		logger.debug("userid=" + userid);
		logger.debug("grade=" + grade);
		logger.debug("idnum=" + idnum);
		logger.debug("birthdate=" + birthdate);
		logger.debug("tel=" + tel);
		logger.debug("height=" + height);
		logger.debug("weight=" + weight);
		logger.debug("deptno=" + deptno);
		logger.debug("profno=" + profno);
		
		// 필수항복 유효성 검사
		
		if (studno == 0) {
			web.redirect(null, "해당 학생번호가 없습니다.");
			return;
		}

		if (name == null) {
			web.redirect(null, "이름을 입력하세요");
			return;
		}
		
		if (userid == null) {
			web.redirect(null, "아이디를 입력하세요");
			return;
		}
		
		if (grade == 0) {
			web.redirect(null, "학년을 입력하세요");
			return;
		}
		
		if (idnum == null) {
			web.redirect(null, "주민번호를 입력하세요");
			return;
		}
		
		
		if (tel == null) {
			web.redirect(null, "전화번호를 입력하세요");
			return;
		}
		
		if (height == 0) {
			web.redirect(null, "키를 입력하세요");
			return;
		}
		
		if (weight == 0) {
			web.redirect(null, "몸무게를 입력하세요");
			return;
		}
		
		if (deptno == 0) {
			web.redirect(null, "학과를 선택하세요");
			return;
		}
		
		// 파라미터 빈즈 구성
		Student student = new Student();
		student.setStudno(studno);
		student.setName(name);
		student.setUserid(userid);
		student.setGrade(grade);
		student.setIdnum(idnum);
		student.setBirthdate(birthdate);
		student.setTel(tel);
		student.setHeight(height);
		student.setWeight(weight);
		student.setDeptno(deptno);
		student.setProfno(profno);
		
		/** 3) Service를 통한 SQL 수행 */
		try {
				studentService.editStudent(student);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return;
		}
		
		
		/** 4) 처리 결과를 JSON으로 출력하기 */
		web.printJsonRt("OK");
		
	}
}
