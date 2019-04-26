package study.spring.hellospring.model;

public class ProfessorDepartment extends Professor {
	private String dname;
	private int limitStart;
	private int listCount;
	public String getDname() {
		return dname;
	}
	public int getLimitStart() {
		return limitStart;
	}
	public int getListCount() {
		return listCount;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	@Override
	public String toString() {
		return "ProfessorDepartment [dname=" + dname + ", limitStart=" + limitStart + ", listCount=" + listCount
				+ ", getProfno()=" + getProfno() + ", getName()=" + getName() + ", getUserid()=" + getUserid()
				+ ", getPosition()=" + getPosition() + ", getSal()=" + getSal() + ", getHiredate()=" + getHiredate()
				+ ", getComm()=" + getComm() + ", getDeptno()=" + getDeptno() + "]";
	}
	
	
	

	
	
	

}
