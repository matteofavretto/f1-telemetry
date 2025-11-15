package org.matteofavretto.controller;

import org.matteofavretto.model.CarData;
import org.matteofavretto.service.CarDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car_data")
public class CarDataController {

    @Autowired
    public CarDataService carDataService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarData>> getCarData(
            @ModelAttribute CarData request
        )  {
        List<CarData> response = carDataService.getCarData(request);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }
}
