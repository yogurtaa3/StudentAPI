package study.spring.hellospring.hello;

public class Value {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	
	
	@Override
	public String toString() {
		return "Value [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
