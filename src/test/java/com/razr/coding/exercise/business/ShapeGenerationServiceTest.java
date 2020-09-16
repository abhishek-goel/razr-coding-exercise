package com.razr.coding.exercise.business;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.razr.coding.exercise.model.Circle;
import com.razr.coding.exercise.model.SingleSidedShape;
import com.razr.coding.exercise.model.Square;

@SpringBootTest
@RunWith(SpringRunner.class)
class ShapeGenerationServiceTest {

	ShapeGenerationService subject = new ShapeGenerationService();
	List<SingleSidedShape> randomShapes;
	
	@BeforeEach
	void setup() {
		randomShapes = subject.generateRandomShapes();
	}
	
	@Test
	void correctNumberOfShapesAreGenerated() {
		Assert.assertEquals(ShapeGenerationService.NUM_SHAPES_OF_EACH_TYPE * 2, randomShapes.size());
		Assert.assertEquals(ShapeGenerationService.NUM_SHAPES_OF_EACH_TYPE, randomShapes.stream().filter(shape -> shape.getClass() == Square.class).count());
		Assert.assertEquals(ShapeGenerationService.NUM_SHAPES_OF_EACH_TYPE, randomShapes.stream().filter(shape -> shape.getClass() == Circle.class).count());
	}
	
	@Test
	void shapeLengthsAreWithinLimit() {
		for (SingleSidedShape singleSidedShape : randomShapes) {
			Double sideLength = singleSidedShape.getSideLength();
			
			if(singleSidedShape.getClass() == Circle.class) {
				if( sideLength < 0 || sideLength > ShapeGenerationService.MAX_LENGTH/2 ) {
					Assert.fail(String.format("Circle radius is incorrect. Expected to be between %d and %d. But is %.2f", ShapeGenerationService.MIN_LENGTH, ShapeGenerationService.MAX_LENGTH/2, sideLength));
				}
			}
			
			if(singleSidedShape.getClass() == Square.class) {
				if( sideLength < 0 || sideLength > ShapeGenerationService.MAX_LENGTH ) {
					Assert.fail(String.format("Square size is incorrect. Expected to be between %d and %d. But is %.2f", ShapeGenerationService.MIN_LENGTH, ShapeGenerationService.MAX_LENGTH, sideLength));
				}
			}
		}
	}
}
