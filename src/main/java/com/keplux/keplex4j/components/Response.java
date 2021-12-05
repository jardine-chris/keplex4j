package com.keplux.keplex4j.components;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.keplux.keplex4j.components.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("MediaContainer")
public class Response {
    @JsonProperty("size")
    private Integer size;

    @JsonProperty("Directory")
    @JsonAlias("Metadata")
    private List<Content> content;
}
