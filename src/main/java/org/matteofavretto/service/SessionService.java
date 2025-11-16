package org.matteofavretto.service;

import org.matteofavretto.model.Session;
import org.matteofavretto.model.SessionResult;
import org.matteofavretto.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SessionService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Session> getSession(String sessionKey) {
        URI uri = UriComponentsBuilder.fromHttpUrl(Constants.F1_TELEMETRY_API + "/sessions")
                .queryParam("session_key", sessionKey)
                .build()
                .toUri();

        Session[] apiResponse = restTemplate.getForObject(uri, Session[].class);

        if(apiResponse == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(apiResponse);
    }

    public List<SessionResult> getSessionResult(String sessionKey) {
        URI uri = UriComponentsBuilder.fromHttpUrl(Constants.F1_TELEMETRY_API + "/session_result")
                .queryParam("session_key", sessionKey)
                .build()
                .toUri();

        SessionResult[] apiResponse = restTemplate.getForObject(uri, SessionResult[].class);

        if(apiResponse == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(apiResponse);
    }

    public List<Session> getRacesByYear(int year) {
        URI uri = UriComponentsBuilder.fromHttpUrl(Constants.F1_TELEMETRY_API + "/sessions")
                .queryParam("session_name", "Race")
                .queryParam("year", year)
                .build()
                .toUri();

        Session[] apiResponse = restTemplate.getForObject(uri, Session[].class);

        if(apiResponse == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(apiResponse);
    }
}
