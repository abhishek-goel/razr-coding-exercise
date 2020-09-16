/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.razr.coding.exercise.api;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.razr.coding.exercise.model.Circle;
import com.razr.coding.exercise.model.Views;
import com.razr.coding.exercise.repo.ShapeRepository;

@RestController
public class CircleController {

	@Autowired
	ShapeRepository shapeRepository;
	
    @GetMapping(value = "/circles/{radius}",
    produces = { "application/json" })
    public ResponseEntity<Circle> getCircleByRadius(@PathVariable("radius") Double radius) {
    	Circle circle = shapeRepository.getCircle(radius);
    	if( circle != null ) {
    		return new ResponseEntity<Circle>(circle, HttpStatus.OK);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }

    @PostMapping(value = "/circle",
    consumes = { "application/json" },
    produces = { "application/json" })
    @JsonView(Views.Create.class)
    public ResponseEntity createCircle(@RequestBody @JsonView(Views.Create.class) Circle circle) throws URISyntaxException {
        shapeRepository.addCircle(circle);
        return ResponseEntity.created(new URI("/circle/" + circle.getSideLength())).build();
    }

    @DeleteMapping(value = "/circles/{radius}",
    produces = { "application/json" })
    public ResponseEntity deleteCircle(@PathVariable("radius") Double radius) throws URISyntaxException {
    	Circle circle = shapeRepository.deleteCircle(radius);
    	if( circle != null ) {
    		return ResponseEntity.ok().build();
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
}