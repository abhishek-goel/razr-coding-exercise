package com.razr.coding.exercise.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CircleTest {

	Circle subject = new Circle();
	
	@Test
	void areaIsZeroWhenRadiusIsZero() {
		subject.setSideLength(0.0);
		Assert.assertEquals((Double)0.0, subject.getArea());
	}

	@Test
	void areaIsCalculatedCorrectly() {
		subject.setSideLength(2.0);
		Assert.assertEquals((Double)(Math.PI * 4.0), subject.getArea());
	}
	
	@Test
	void toStringReturnsCorrectString() {
		Assert.assertEquals("Circle: Radius = 0.00, Area = 0.00", subject.toString());
	}
}
