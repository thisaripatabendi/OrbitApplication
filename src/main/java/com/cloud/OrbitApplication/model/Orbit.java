package com.cloud.OrbitApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="orbit")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Orbit {
	
	@Id
	@JsonProperty("satellite_id")
    @Column(name = "satellite_id", nullable = false)
    private Long satellite_id;

    @JsonProperty("latitude")
    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @JsonProperty("longitude")
    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

	public Long getSatellite_id() {
		return satellite_id;
	}

	public void setSatellite_id(Long satellite_id) {
		this.satellite_id = satellite_id;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
    
    

}
