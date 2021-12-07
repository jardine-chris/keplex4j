package com.keplux.keplex4j.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Media {
    private String key;
    private String title;
    private String tagline;
    private String summary;
    private Integer year;
    private String contentRating;
    private Integer audienceRating;
    private Integer duration; // TODO: getter needs to convert ms to HH:MM

    @JsonProperty("thumb")
    private String poster;
}
