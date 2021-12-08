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
public class Producer {
    private Long id;

    @JsonProperty("tag")
    private String producer;

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                '}';
    }
}
