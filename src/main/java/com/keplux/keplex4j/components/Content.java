package com.keplux.keplex4j.components;

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
@Component
public class Content {
    private String key;
    private String title;
}
