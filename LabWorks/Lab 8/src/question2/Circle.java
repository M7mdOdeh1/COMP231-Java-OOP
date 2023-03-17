package question2;

public class Circle extends Shape implements Cloneable {
	protected double radius;
	protected Postion postion;

	public Circle() {
		super();
		radius=0;
		postion= new Postion(0,0);
	}

	public Circle(String color, boolean filled, double radius, Postion postion) {
		super(color, filled);
		this.postion= postion;
	    this.radius= radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius*radius*3.14;
	}
	
	public Postion getPostion() {
		return postion;
	}

	public void setPostion(Postion postion) {
		this.postion = postion;
	}

	@Override
	public String toString() {
		return "Circle [Area=" + getArea()
				+ ", postion: "+ postion.toString();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		Circle circle;
		circle = (Circle)super.clone();
		circle.postion= (Postion)postion.clone();
		
		return circle;
	}
	

	

}
