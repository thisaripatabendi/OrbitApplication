package com.cloud.OrbitApplication.controller;

import org.springframework.http.ResponseEntity;

import com.cloud.OrbitApplication.model.MockResponse;
import com.cloud.OrbitApplication.model.Orbit;
import com.cloud.OrbitApplication.service.OrbitService;

import io.swagger.annotations.Api;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Api(tags = {"orbit"})
public class OrbitControllerImpl implements OrbitController{
	
	@Autowired
    private OrbitService orbitService;

    @Override
    public ResponseEntity<MockResponse> controlOrbit(@RequestBody Orbit orbit) {
    	
        if(orbitService.controlOrbit(orbit) > 0) {
        	System.out.println("test build");
            return new ResponseEntity<>(new MockResponse(204 ,"Successfully updated the orbit"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MockResponse(404, "Satellite not found"), HttpStatus.NOT_FOUND);
        }

    }

	@Override
	public ResponseEntity<Orbit> trackOrbit(Long satelliteID) {
		
		Optional<Orbit> orbit = orbitService.trackOrbit(satelliteID);
        return orbit.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new Orbit(), HttpStatus.NOT_FOUND));
   
	}
	

}
