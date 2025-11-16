package org.matteofavretto.service;

import org.matteofavretto.model.CarData;
import org.matteofavretto.utils.Utility;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarDataService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<CarData> getCarData(CarData request) {
        URI uri = Utility.getCarDataRequestBuilder(request);
        CarData[] apiResponse = restTemplate.getForObject(uri, CarData[].class);

        if(apiResponse == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(apiResponse);
    }
}
