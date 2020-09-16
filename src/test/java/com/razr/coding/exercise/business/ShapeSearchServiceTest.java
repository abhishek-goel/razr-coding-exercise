package com.razr.coding.exercise.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.razr.coding.exercise.model.SingleSidedShape;
import com.razr.coding.exercise.model.Square;

@SpringBootTest
@RunWith(SpringRunner.class)
class ShapeSearchServiceTest {

	@Autowired
	ShapeSearchService subject;
	
	@Test
	void multipleShapesClosestToMeanAreFound() {
		List<SingleSidedShape> shapes = new ArrayList<SingleSidedShape>();
		
		shapes.add(new Square(2.0));
		shapes.add(new Square(4.0));
		
		Assert.assertEquals(2, subject.findClosestMeanShape(shapes).size());
	}
	
	@Test
	void shapeWithSameAreaAsMeanIsFound() {
		List<SingleSidedShape> shapes = new ArrayList<SingleSidedShape>();
		
		shapes.add(new Square(2.0));
		shapes.add(new Square(3.0));
		shapes.add(new Square(4.0));
		
		Assert.assertEquals((Double)3.0, subject.findClosestMeanShape(shapes).get(0).getSideLength());
	}

	
	@Test
	void shapeWithAreaClosestToMeanIsFound() {
		List<SingleSidedShape> shapes = new ArrayList<SingleSidedShape>();
		
		shapes.add(new Square(2.1));
		shapes.add(new Square(4.0));
		
		Assert.assertEquals((Double)2.1, subject.findClosestMeanShape(shapes).get(0).getSideLength());
	}
}
