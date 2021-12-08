package com.keplux.keplex4j.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Role {
    @JsonProperty("tag")
    private String actor;
    @JsonProperty("thumb")
    private String actorPhoto;
    private String role;

    @Override
    public String toString() {
        return "Role{" +
                "actor='" + actor + '\'' +
                ", actorPhoto='" + actorPhoto + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
