package com.razr.coding.exercise.model;

import java.util.concurrent.ThreadLocalRandom;

public class Square extends SingleSidedShape {

	public Square() {
		super();
		this.setNameAttributes();
	}
	
	public Square(Double sideLength) {
		super();
		this.setNameAttributes();
		this.sideLength = sideLength;
	}
	
	private void setNameAttributes() {
		this.shapeName = "Square";
		this.sideName = "Size";
	}

	@Override
	public Double getArea() {
		return Math.pow(this.getSideLength(), 2);
	}
	
	public static Square generateRandom(int minSideLength, int maxSideLength) {
		int randomSideLength = ThreadLocalRandom.current().nextInt(minSideLength, maxSideLength);
		
		Square square = new Square();
		square.setSideLength(randomSideLength * 1.0);

		return square;
	}
}