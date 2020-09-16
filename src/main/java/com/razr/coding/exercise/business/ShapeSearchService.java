package com.razr.coding.exercise.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.razr.coding.exercise.model.SingleSidedShape;

@Service
public class ShapeSearchService {

	public List<SingleSidedShape> findClosestMeanShape(List<SingleSidedShape> shapes) {
		Double meanArea = shapes
	            .stream()
	            .mapToDouble(shape -> shape.getArea())
	            .average().orElse(0.0);
		
		
		List<Double> distancesToMean = shapes.parallelStream().map(shape -> Math.abs(shape.getArea() - meanArea)).collect(Collectors.toList());
		Double minDistanceToMean = distancesToMean.stream().mapToDouble(distance -> distance).min().getAsDouble();
		return shapes.parallelStream().filter(shape -> Math.abs(shape.getArea() - meanArea) == minDistanceToMean).collect(Collectors.toList());
	}
}
