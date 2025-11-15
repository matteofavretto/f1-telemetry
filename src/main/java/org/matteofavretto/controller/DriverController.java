package org.matteofavretto.controller;

import org.matteofavretto.model.Driver;
import org.matteofavretto.service.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    public DriversService driversService;

    @GetMapping("/driver")
    public ResponseEntity<List<Driver>> getDriver(
            @ModelAttribute Driver request
    )  {
        List<Driver> response = driversService.getDriver(request);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }
}
