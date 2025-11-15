package org.matteofavretto.service;

import org.matteofavretto.model.Driver;
import org.matteofavretto.utils.Utility;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DriversService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Driver> getDriver(Driver request) {
        if (request.getDriverNumber() == null) {
            throw new IllegalArgumentException("driverNumber is required");
        }
        URI uri = Utility.getDriverRequestBuilder(request);
        System.out.println(uri);
        Driver[] apiResponse = restTemplate.getForObject(uri, Driver[].class);

        // TODO: meetings

        if(apiResponse == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(apiResponse);
    }
}
