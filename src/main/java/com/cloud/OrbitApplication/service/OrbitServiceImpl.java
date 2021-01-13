package com.cloud.OrbitApplication.service;

import com.cloud.OrbitApplication.model.Orbit;
import com.cloud.OrbitApplication.repository.OrbitRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrbitServiceImpl implements OrbitService{

    @Autowired
    private OrbitRepository orbitRepository;

    @Override
    public int controlOrbit(Orbit orbit) {
        return orbitRepository.controlOrbit(orbit.getSatellite_id(), orbit.getLatitude(), orbit.getLongitude());
    }

	@Override
	public Optional<Orbit> trackOrbit(Long satelliteID) {
		return orbitRepository.findById(satelliteID);
	}

}
