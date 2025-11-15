package org.matteofavretto.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarData {

    private String sessionKey;

    private String driverNumber;
    private LocalDateTime timestamp;
    private Integer brake;
    private Integer drsState;
    private Integer rpm;
    private Integer speed;
    private Integer throttle;
    private Integer gear;
    private Integer meetingKey;
}
