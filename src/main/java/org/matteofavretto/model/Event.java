package org.matteofavretto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Event {
    @JsonProperty("circuit_key")
    private String circuitKey;
    @JsonProperty("circuit_short_name")
    private String circuitShortName;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("country_key")
    private String countryKey;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("date_start")
    private String dateStart;
    @JsonProperty("gmt_offset")
    private String gmtOffset;
    @JsonProperty("location")
    private String location;
    @JsonProperty("meeting_key")
    private String meetingKey;
    @JsonProperty("year")
    private String year;
}
