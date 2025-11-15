package org.matteofavretto.service;

import org.matteofavretto.model.Meeting;
import org.matteofavretto.utils.Utility;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MeetingsService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Meeting> getMeeting(Meeting request) {
        if (request.getCountryName() == null) {
            throw new IllegalArgumentException("countryName is required");
        }
        URI uri = Utility.getMeetingRequestBuilder(request);
        System.out.println(uri);
        Meeting[] apiResponse = restTemplate.getForObject(uri, Meeting[].class);

        if(apiResponse == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(apiResponse);
    }
}
