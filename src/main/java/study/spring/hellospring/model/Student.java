/**
 * 작성자: 임형진
 * 파일명: 통합구현 이수자평가.pdf
 * 파일내용: Student Beans
 * 최중수정일: 2019-01-25
 */

package study.spring.hellospring.model;

public class Student {
	private int studno;   
	private String name;     
	private String userid;   
	private int grade;    
	private String idnum;    
	private String birthdate;
	private String tel;      
	private int height;   
	private int weight;   
	private int deptno;   
	private int profno;
	private int limitStart;
	private int listCount;
	private String dname;
	private String pname;
	
	public String getDname() {
		return dname;
	}
	public String getPname() {
		return pname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getLimitStart() {
		return limitStart;
	}
	public int getListCount() {
		return listCount;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getStudno() {
		return studno;
	}
	public String getName() {
		return name;
	}
	public String getUserid() {
		return userid;
	}
	public int getGrade() {
		return grade;
	}
	public String getIdnum() {
		return idnum;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public String getTel() {
		return tel;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	public int getDeptno() {
		return deptno;
	}
	public int getProfno() {
		return profno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	@Override
	public String toString() {
		return "Student [studno=" + studno + ", name=" + name + ", userid=" + userid + ", grade=" + grade + ", idnum="
				+ idnum + ", birthdate=" + birthdate + ", tel=" + tel + ", height=" + height + ", weight=" + weight
				+ ", deptno=" + deptno + ", profno=" + profno + ", limitStart=" + limitStart + ", listCount="
				+ listCount + ", dname=" + dname + ", pname=" + pname + "]";
	}
	
	
	
	
}
