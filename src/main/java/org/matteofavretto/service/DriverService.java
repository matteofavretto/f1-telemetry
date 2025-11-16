package org.matteofavretto.service;

import org.matteofavretto.model.Driver;
import org.matteofavretto.utils.Constants;
import org.matteofavretto.utils.Utility;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DriverService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Driver> getDriver(Driver request) {
        if (request.getDriverNumber() == null) {
            throw new IllegalArgumentException("driverNumber is required");
        }
        URI uri = Utility.getDriverRequestBuilder(request);
        Driver[] apiResponse = restTemplate.getForObject(uri, Driver[].class);

        if(apiResponse == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(apiResponse);
    }

    public List<Driver> getDriversInSession(String sessionKey) {
        URI uri = UriComponentsBuilder.fromHttpUrl(Constants.F1_TELEMETRY_API + "/drivers")
                .queryParam("session_key", sessionKey)
                .build()
                .toUri();
        Driver[] apiResponse = restTemplate.getForObject(uri, Driver[].class);

        if(apiResponse == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(apiResponse);
    }
}
