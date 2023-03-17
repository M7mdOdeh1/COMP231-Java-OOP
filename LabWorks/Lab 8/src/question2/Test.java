package question2;

import java.util.*;

public class Test {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		ArrayList<Shape> shape= new ArrayList<>();

		
		shape.add(new Circle("red", true, 1, new Postion(2,5)));
		shape.add(new Rectangle("blue", true, 5, 77));
		shape.add(new Circle("lime", true, 2, new Postion(3,7)));
		shape.add(new Rectangle("cyan", true, 4, 15));
		
	
		Circle c1 = (Circle)((Circle)shape.get(0)).clone();   //clone the first index of array list
		
		c1.setPostion(new Postion(10,6));
		c1.setRadius(100);
		
		System.out.println(shape.get(0).toString());
		System.out.println(c1.toString());
		System.out.println("c1 radius: "+ c1.getRadius());
		
		
		//Sort(shape);
		//printInfo(shape);
		
	}
	
	public static void Sort(ArrayList<Shape> shape) {
		java.util.Collections.sort(shape);
	}

	public static void printInfo(ArrayList<Shape> shape) {
		for(int i=0; i<shape.size(); i++) {
			System.out.println(shape.get(i));
		}
		
	}
	
	

}
