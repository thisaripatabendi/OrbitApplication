package com.cloud.OrbitApplication.controller;


import org.springframework.web.bind.annotation.RestController;

import com.cloud.OrbitApplication.model.MockResponse;
import com.cloud.OrbitApplication.model.Orbit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Api(value = "orbit")
public interface OrbitController {
	
	@ApiOperation(value = "Control the Orbit", nickname = "controlOrbit", notes = "Returns the status", response = MockResponse.class, tags={ "orbit", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = MockResponse.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = MockResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = MockResponse.class) })
    @RequestMapping(value = "/orbit/control",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<MockResponse> controlOrbit(@RequestBody Orbit orbit);
	
	
	@ApiOperation(value = "Track the Orbit of the satellite", nickname = "trackOrbit", notes = "Returns the status", response = Orbit.class, tags={ "orbit", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Orbit.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = MockResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = MockResponse.class) })
    @RequestMapping(value = "/orbit/track/{satelliteID}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Orbit> trackOrbit(@ApiParam(value = "Satellite ID",required=true)
                                               @PathVariable("satelliteID") Long satelliteID);

	
}
