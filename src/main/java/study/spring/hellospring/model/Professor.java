/**
 * 작성자: 임형진
 * 파일명: 통합구현 이수자평가.pdf
 * 파일내용: Professor Beans
 * 최중수정일: 2019-01-25
 */

package study.spring.hellospring.model;

public class Professor {
	private int profno;			// 교수번호
	private String name;		// 교수이름
	private String userid;		// 아이디 
	private String position;	// 직급
	private int sal;			// 급여
	private String hiredate;	// 입사일
	private int comm; 			// 보직수당 - null 허용
	private int deptno;			// 소속학과 번호 - department 테이블을 참조하는 키
	public int getProfno() {
		return profno;
	}
	public String getName() {
		return name;
	}
	public String getUserid() {
		return userid;
	}
	public String getPosition() {
		return position;
	}
	public int getSal() {
		return sal;
	}
	public String getHiredate() {
		return hiredate;
	}
	public int getComm() {
		return comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Professor [profno=" + profno + ", name=" + name + ", userid=" + userid + ", position=" + position
				+ ", sal=" + sal + ", hiredate=" + hiredate + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	
}