package question2;

public class Circle {
	
	private double radius;
	private String color;
	
	public Circle(double radius, String color) throws WrongRadiusException {
		super();
		setRadius(radius);
		this.color = color;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius (double radius) throws WrongRadiusException  {
		if(radius <0)
			throw new WrongRadiusException("Radius cannot be negative");
		else
			this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}

	public static void main(String [] args) {
		try {
		Circle circle1 = new Circle(4,"blue");
		System.out.println(circle1.toString());	
		Circle circle2 = new Circle(-3,"red");
		}catch (WrongRadiusException Exc) {
			
			System.out.println(Exc.getMessage());
		}
				
	}

	
}


class WrongRadiusException extends Exception{
	WrongRadiusException(String str){
		super(str);
	}
}



