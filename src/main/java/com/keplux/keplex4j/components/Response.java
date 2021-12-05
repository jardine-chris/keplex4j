package com.keplux.keplex4j.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {
    @JsonProperty("MediaContainer")
    private Container container;
}
