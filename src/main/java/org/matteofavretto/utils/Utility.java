package org.matteofavretto.utils;

import lombok.experimental.UtilityClass;
import org.matteofavretto.model.CarData;
import org.matteofavretto.model.Driver;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@UtilityClass
public class Utility {

    public URI getCarDataRequestBuilder(CarData request) {
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromHttpUrl(Constants.F1_TELEMETRY_API + "/car_data")
                .queryParam("session_key", request.getSessionKey());

        if (request.getTimestamp() != null) {
            componentsBuilder.queryParam("date", request.getTimestamp());
        }
        if (request.getDriverNumber() != null) {
            componentsBuilder.queryParam("driver_number", request.getDriverNumber());
        }
        if (request.getBrake() != null) {
            componentsBuilder.queryParam("brake", request.getBrake());
        }
        if (request.getDrsState() != null) {
            componentsBuilder.queryParam("drs", request.getDrsState());
        }
        if (request.getMeetingKey() != null) {
            componentsBuilder.queryParam("meeting_key", request.getMeetingKey());
        }
        if (request.getGear() != null) {
            componentsBuilder.queryParam("gear", request.getGear());
        }
        if (request.getRpm() != null) {
            componentsBuilder.queryParam("rpm", request.getRpm());
        }
        if (request.getSpeed() != null) {
            componentsBuilder.queryParam("speed", request.getSpeed());
        }
        if (request.getThrottle() != null) {
            componentsBuilder.queryParam("throttle", request.getThrottle());
        }

        return componentsBuilder.build().toUri();
    }

    public URI getDriverRequestBuilder(Driver request) {
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromHttpUrl(Constants.F1_TELEMETRY_API + "/drivers")
                .queryParam("driver_number", request.getDriverNumber());

        if (request.getBroadcastName() != null) {
            componentsBuilder.queryParam("broadcast_name", request.getBroadcastName());
        }
        if (request.getFirstName() != null) {
            componentsBuilder.queryParam("first_name", request.getFirstName());
        }
        if (request.getLastName() != null) {
            componentsBuilder.queryParam("last_name", request.getLastName());
        }
        if (request.getSessionKey() != null) {
            componentsBuilder.queryParam("session_key", request.getSessionKey());
        }
        if (request.getMeetingKey() != null) {
            componentsBuilder.queryParam("meeting_key", request.getMeetingKey());
        }
        if (request.getMeetingKey() != null) {
            componentsBuilder.queryParam("meeting_key", request.getMeetingKey());
        }
        if (request.getNameAcronym() != null) {
            componentsBuilder.queryParam("name_acronym", request.getNameAcronym());
        }
        if (request.getTeamName() != null) {
            componentsBuilder.queryParam("team_name", request.getTeamName());
        }

        return componentsBuilder.build().toUri();
    }
}
