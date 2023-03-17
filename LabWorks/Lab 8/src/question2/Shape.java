package question2;

public abstract class Shape implements Comparable<Shape> {
	protected String color;
	protected boolean filled;
	
	public Shape() {
		this("", false);
	}
	
	public Shape(String color, boolean filled) {
		this.color=color;
		this.filled= filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public int compareTo(Shape s) {
		if(this.getArea()- s.getArea()>0)
			return 1;
		else if(this.getArea()- s.getArea()<0)
			return -1;
		else 
			return 0;
	}
	
	public abstract double getArea();
	
	public abstract String toString();

}
