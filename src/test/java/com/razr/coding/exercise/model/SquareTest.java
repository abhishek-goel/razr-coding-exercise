package com.razr.coding.exercise.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SquareTest {

	Square subject = new Square();
	
	@Test
	void areaIsZeroWhenSizeIsZero() {
		subject.setSideLength(0.0);
		Assert.assertEquals((Double)0.0, subject.getArea());
	}

	@Test
	void areaIsCalculatedCorrectly() {
		subject.setSideLength(2.0);
		Assert.assertEquals((Double)4.0, subject.getArea());
	}
	
	@Test
	void toStringReturnsCorrectString() {
		Assert.assertEquals("Square: Size = 0.00, Area = 0.00", subject.toString());
	}

}
