package com.keplux.keplex4j.services;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keplux.keplex4j.components.Content;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ClientService {
    @JsonProperty("size")
    private Integer size;

    @JsonProperty("Directory")
    @JsonAlias("Metadata")
    private List<Content> content;


    public List<Content> getContent() {
        return content;
    }
}
