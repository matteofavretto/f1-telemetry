package org.matteofavretto.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DriverStanding extends Driver {
    private Float points;

    public DriverStanding(Driver driver, Float points) {
        this.setFirstName(driver.getFirstName());
        this.setLastName(driver.getLastName());
        this.setBroadcastName(driver.getBroadcastName());
        this.setNameAcronym(driver.getNameAcronym());
        this.setDriverNumber(driver.getDriverNumber());
        this.setHeadshotUrl(driver.getHeadshotUrl());
        this.setTeamName(driver.getTeamName());
        this.setTeamColour(driver.getTeamColour());
        this.setPoints(points);
    }
}
