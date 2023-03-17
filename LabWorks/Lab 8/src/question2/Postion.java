package question2;

public class Postion implements Cloneable {
	protected double x;
	protected double y;
	
	public Postion(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	

	@Override
	public String toString() {
		return "Postion [x=" + x + ", y=" + y + "]";
	}
	
}
