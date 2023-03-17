package question2;

public class Rectangle extends Shape {
	protected double width;
	protected double length;
	
	public Rectangle() {
		super();
		width=0;
		length=0;
	}
	public Rectangle(String color, boolean filled, double width, double length) {
		super(color, filled);
		this.width=width;
		this.length= length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getArea() {
		return width*length;
	}
	
	@Override
	public String toString() {
		return "Rectangle [ Area=" + getArea() + "]";
	}
	
	
	
	
	
	
	

}
