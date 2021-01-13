package com.cloud.OrbitApplication.service;

import org.springframework.stereotype.Service;
import com.cloud.OrbitApplication.model.Orbit;
import java.util.Optional;

@Service
public interface OrbitService {
	
	int controlOrbit(Orbit orbit);
	
	Optional<Orbit> trackOrbit(Long satelliteID);

}
