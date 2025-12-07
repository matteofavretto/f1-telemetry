package org.matteofavretto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URL;

@Data
public class Driver {
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonProperty(value = "broadcast_name")
    private String broadcastName;
    @JsonProperty(value = "name_acronym")
    private String nameAcronym;
    @JsonProperty(value = "driver_number")
    private String driverNumber;
    @JsonProperty(value = "headshot_url")
    private URL headshotUrl;
    @JsonProperty(value = "team_name")
    private String teamName;
    @JsonProperty(value = "team_colour")
    private String teamColour;
}