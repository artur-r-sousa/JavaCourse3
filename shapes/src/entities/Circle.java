package entities;

import entities.enums.Color;

public class Circle extends Shape {
	
	private double radius;
	
	public Circle() {
		super();
	}
	
	public Circle(Color color, double radius) {
		super(color);
		this.radius = radius;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
