package com.razr.coding.exercise.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.razr.coding.exercise.model.Circle;
import com.razr.coding.exercise.model.SingleSidedShape;
import com.razr.coding.exercise.model.Square;

@Service
public class ShapeGenerationService {

	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 100;
	
	public static final int NUM_SHAPES_OF_EACH_TYPE = 50;
	
	public List<SingleSidedShape> generateRandomShapes() {
		List<SingleSidedShape> randomlyGeneratedShapes = new ArrayList<SingleSidedShape>();
		
		for (int i = 1; i <= NUM_SHAPES_OF_EACH_TYPE; i++) {
			randomlyGeneratedShapes.add(Circle.generateRandom(MIN_LENGTH, MAX_LENGTH));
			randomlyGeneratedShapes.add(Square.generateRandom(MIN_LENGTH, MAX_LENGTH));
		}
		
		return randomlyGeneratedShapes;
	}
}
