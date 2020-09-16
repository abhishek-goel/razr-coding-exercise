package com.razr.coding.exercise.business;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.razr.coding.exercise.model.SingleSidedShape;

@Service
public class ShapeSortingService {

	public List<SingleSidedShape> getSortedSingleSidedShapes(List<SingleSidedShape> singleSidedShapes) {
		List<SingleSidedShape> clonedSingleSidedShapes = singleSidedShapes.stream().collect(Collectors.toList()); 
		Collections.sort(clonedSingleSidedShapes, Collections.reverseOrder());
		return clonedSingleSidedShapes;
	}
}
