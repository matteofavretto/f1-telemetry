package org.matteofavretto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Meeting extends Event {
    @JsonProperty("meeting_name")
    private String meetingName;
    @JsonProperty("meeting_official_name")
    private String meetingOfficialName;
}
