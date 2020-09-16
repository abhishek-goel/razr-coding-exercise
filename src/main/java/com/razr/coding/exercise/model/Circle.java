package com.razr.coding.exercise.model;

import java.util.concurrent.ThreadLocalRandom;

public class Circle extends SingleSidedShape {

	public Circle() {
		super();
		setNameAttributes();
	}

	public Circle(Double radius) {
		super();
		setNameAttributes();
		this.sideLength = radius;
	}

	private void setNameAttributes() {
		this.shapeName = "Circle";
		this.sideName = "Radius";
	}

	@Override
	public Double getArea() {
		return Math.PI * Math.pow(this.getSideLength(), 2);
	}
	
	public static Circle generateRandom(int minDiameter, int maxDiameter) {
		int randomDiameter = ThreadLocalRandom.current().nextInt(minDiameter, maxDiameter);
		
		Circle circle = new Circle();
		circle.setSideLength(randomDiameter/2.0);

		return circle;
	}
}
