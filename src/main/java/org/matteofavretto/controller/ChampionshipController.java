package org.matteofavretto.controller;

import org.matteofavretto.model.DriverStanding;
import org.matteofavretto.service.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/championship")
public class ChampionshipController {

    @Autowired
    public ChampionshipService championshipService;

    @GetMapping("/standings/drivers")
    public ResponseEntity<List<DriverStanding>> getDriversStandings(
            @RequestParam int year
    )  {
        List<DriverStanding> response = championshipService.getDriverStandings(year);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }
}
