package com.razr.coding.exercise.business;

import java.util.ArrayList;
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
class ShapeSortingServiceTest {
	
	ShapeSortingService subject = new ShapeSortingService();
	
	List<SingleSidedShape> originalList = new ArrayList<SingleSidedShape>();
	Circle circle = new Circle();
	Square square = new Square();

	@BeforeEach
	void setup() {
		circle.setSideLength(1.0);
		square.setSideLength(2.0);
	
		originalList.add(circle);
		originalList.add(square);
	}
	
	@Test
	void alreadySortedListGetsReversed() {
		List<SingleSidedShape> newList = subject.getSortedSingleSidedShapes(originalList);
		Assert.assertEquals(newList.get(0), square);
		Assert.assertEquals(newList.get(1), circle);
	}

	@Test
	void originalListRemainsUnchanged() {
		subject.getSortedSingleSidedShapes(originalList);
		Assert.assertEquals(originalList.get(0), circle);
		Assert.assertEquals(originalList.get(1), square);
	}

}
