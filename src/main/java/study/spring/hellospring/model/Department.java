/**
 * 작성자: 임형진
 * 파일명: 통합구현 이수자평가.pdf
 * 파일내용: Department Beans
 * 최중수정일: 2019-01-25
 */

package study.spring.hellospring.model;

public class Department {
	 private int deptno;
	 private String dname; 
	 private String loc;
	 
	 private int limitStart;
	 private int listCount;
	 
	 
	public int getDeptno() {
		return deptno;
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
	public String getDname() {
		return dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", limitStart=" + limitStart
				+ ", listCount=" + listCount + "]";
	}
	
	 
	
}
