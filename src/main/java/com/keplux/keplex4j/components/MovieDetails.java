package com.keplux.keplex4j.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("MediaContainer")
@Component
public class MovieDetails {
    private String key;
    private String title;
    private String tagline;
    private String summary;
    private String contentRating;
    private Integer year;
    private String studio;
    private Integer duration;

    @JsonProperty("Genre")
    private List<Genre> genres;

    @JsonProperty("Director")
    private List<Director> directors;

    @JsonProperty("Writer")
    private List<Writer> writers;

    @JsonProperty("Producer")
    private List<Producer> producers;

    @JsonProperty("Role")
    private List<Role> roles;

    @Override
    public String toString() {
        return "MovieDetails{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", tagline='" + tagline + '\'' +
                ", summary='" + summary + '\'' +
                ", contentRating='" + contentRating + '\'' +
                ", year=" + year +
                ", studio='" + studio + '\'' +
                ", duration=" + duration +
                ", genres=" + genres +
                ", directories=" + directors +
                ", writers=" + writers +
                ", producers=" + producers +
                ", roles=" + roles +
                '}';
    }
}
