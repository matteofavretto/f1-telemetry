package org.matteofavretto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Session extends Event {
    @JsonProperty("date_end")
    private String dateEnd;
    @JsonProperty("session_name")
    private String sessionName;
    @JsonProperty("session_key")
    private String sessionKey;
    @JsonProperty("meeting_type")
    private String sessionType;
}
