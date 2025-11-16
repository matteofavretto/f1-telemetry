package org.matteofavretto.service;

import lombok.RequiredArgsConstructor;
import org.matteofavretto.model.Driver;
import org.matteofavretto.model.DriverStanding;
import org.matteofavretto.model.Session;
import org.matteofavretto.model.SessionResult;
import org.matteofavretto.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChampionshipService {

    private final SessionService sessionService;
    private final DriverService driverService;

    public List<DriverStanding> getDriverStandings(int year) {

        // First, get all the session keys for the races in the specified year
        List<Session> racesInYear = sessionService.getRacesByYear(year);
        Map<String, Session> sessionKeysMap = racesInYear.stream().collect(Collectors.toMap(Session::getSessionKey, session -> session));

        // Then get all the drivers by aggregating the participants in each race
        Map<String, Driver> drivers = new HashMap<>();
        for(String sessionKey : sessionKeysMap.keySet()) {
            List<Driver> driversInRace = driverService.getDriversInSession(sessionKey);
            driversInRace.forEach(driver -> drivers.putIfAbsent(driver.getDriverNumber(), driver));
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        // Then get all the results for each driver, using their numbers as keys
        Map<String, List<SessionResult>> driverResultsMap = new HashMap<>();
        for(String sessionKey : sessionKeysMap.keySet()) {
            List<SessionResult> resultsForRace = sessionService.getSessionResult(sessionKey);
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            for (SessionResult sessionResult : resultsForRace) {
                String driverNumber = String.valueOf(sessionResult.getDriverNumber());
                driverResultsMap.computeIfAbsent(driverNumber, k -> new ArrayList<>()).add(sessionResult);
            }
        }

        // Finally compute the points for each driver
        List<DriverStanding> standings = new ArrayList<>();
        for(Map.Entry<String, List<SessionResult>> driverResults : driverResultsMap.entrySet()) {
            String driverNumber = driverResults.getKey();
            Float points = 0.0F;
            for(SessionResult result : driverResults.getValue()) {
                int position = result.getPosition();
                if(position > 0 && position <= 10) {
                    points += Constants.pointsByPosition.get(position - 1);
                }
            }
            DriverStanding standing = new DriverStanding(drivers.get(driverNumber), points);
            standings.add(standing);
        }
        return standings;
    }
}
