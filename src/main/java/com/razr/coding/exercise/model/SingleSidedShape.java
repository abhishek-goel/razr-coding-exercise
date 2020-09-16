package com.razr.coding.exercise.model;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public abstract class SingleSidedShape implements Comparable<SingleSidedShape> {

	@JsonView(Views.Create.class)
	protected Double sideLength = 0.0;
	
	@JsonView(Views.GetDetails.class)
	protected String shapeName;
	
	@JsonView(Views.GetDetails.class)
	protected String sideName;

	@JsonView(Views.GetDetails.class)
	public abstract Double getArea();
	
	public String toString() {
		return String.format("%s: %s = %.2f, Area = %.2f", shapeName, sideName, getSideLength(), getArea());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shapeName == null) ? 0 : shapeName.hashCode());
		result = prime * result + ((sideLength == null) ? 0 : sideLength.hashCode());
		result = prime * result + ((sideName == null) ? 0 : sideName.hashCode());
		return result;
	}

	@Override
    public boolean equals(Object input) {
        return ((SingleSidedShape) input).getArea().equals(getArea());
    }

    @Override
    public int compareTo(SingleSidedShape input) {
        return getArea().compareTo(input.getArea());
    }
}