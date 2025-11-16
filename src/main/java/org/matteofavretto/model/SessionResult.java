package org.matteofavretto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SessionResult {
    @JsonProperty("dnf")
    private Boolean dnf;
    @JsonProperty("dns")
    private Boolean dns;
    @JsonProperty("dsq")
    private Boolean dsq;
    @JsonProperty("driver_number")
    private int driverNumber;
    @JsonProperty("duration")
    private float duration;
    @JsonProperty("gap_to_leader")
    private String gapToLeader;
    @JsonProperty("number_of_laps")
    private int numberOfLaps;
    @JsonProperty("meeting_key")
    private String meetingKey;
    @JsonProperty("position")
    private int position;
    @JsonProperty("session_key")
    private String sessionKey;
}
