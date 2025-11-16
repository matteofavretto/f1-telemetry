package org.matteofavretto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URL;

@Data
public class Driver {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("broadcast_name")
    private String broadcastName;
    @JsonProperty("name_acronym")
    private String nameAcronym;
    @JsonProperty("driver_number")
    private String driverNumber;
    @JsonProperty("headshot_url")
    private URL headshotUrl;
    @JsonProperty("team_name")
    private String teamName;
    @JsonProperty("team_colour")
    private String teamColour;
}
