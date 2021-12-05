package com.keplux.keplex4j.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Content {
    private String key;
    private String title;
}
