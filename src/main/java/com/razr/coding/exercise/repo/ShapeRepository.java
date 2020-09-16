package com.razr.coding.exercise.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.razr.coding.exercise.business.ShapeGenerationService;
import com.razr.coding.exercise.business.ShapeSearchService;
import com.razr.coding.exercise.business.ShapeSortingService;
import com.razr.coding.exercise.model.Circle;
import com.razr.coding.exercise.model.SingleSidedShape;
import com.razr.coding.exercise.model.Square;

@Repository
public class ShapeRepository {
	
	@Autowired
	private ShapeGenerationService shapeGenerationService;

	@Autowired
	private ShapeSortingService shapeSortingService;

	@Autowired
	private ShapeSearchService shapeSearchService;

	private Map<Double, Circle> circles = new HashMap<Double, Circle>();
	private Map<Double, Square> squares = new HashMap<Double, Square>();
	private List<SingleSidedShape> shapes = new ArrayList<SingleSidedShape>();
	
	public void addCircle(Circle circle) {
		circles.put(circle.getSideLength(), circle);
	}
	
	public Circle getCircle(Double sideLength) {
		return circles.get(sideLength);
	}
	
	public Circle deleteCircle(Double sideLength) {
		return circles.remove(sideLength);
	}
	
	public void addSquare(Square square) {
		squares.put(square.getSideLength(), square);
	}
	
	public Square getSquare(Double sideLength) {
		return squares.get(sideLength);
	}
	
	public Square deleteSquare(Double sideLength) {
		return squares.remove(sideLength);
	}
	
	public List<SingleSidedShape> getRandomShapes() {
		if( shapes.isEmpty() ) {
			shapes = shapeGenerationService.generateRandomShapes();
			shapes.stream().parallel().filter(shape -> shape.getClass() == Circle.class).forEach(shape -> addCircle((Circle)shape));
			shapes.stream().parallel().filter(shape -> shape.getClass() == Square.class).forEach(shape -> addSquare((Square)shape));
		}
		return shapes;
	}
	
	public List<SingleSidedShape> getSortedShapes() {
		if( shapes.isEmpty() ) {
			return null;
		}
		List<SingleSidedShape> sortedShapes = shapeSortingService.getSortedSingleSidedShapes(shapes);
		Collections.sort(sortedShapes); // sorting service sorts in descending order. Task description doesn't mention descending in the ReST API section. So need to sort ascending. 
		return sortedShapes;
	}
	
	public List<SingleSidedShape> getShapesWithAreaClosestToMean() {
		if( shapes.isEmpty() ) {
			return null;
		}
		
		return shapeSearchService.findClosestMeanShape(shapes);
	}
}
