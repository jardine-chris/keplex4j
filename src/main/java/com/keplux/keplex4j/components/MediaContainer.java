package com.keplux.keplex4j.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.keplux.keplex4j.services.ClientService;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MediaContainer {
    @JsonProperty("MediaContainer")
    private ClientService clientService;
}
