package com.keplux.keplex4j.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.keplux.keplex4j.components.Directory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ClientService {
    @JsonProperty("size")
    private Integer size;

    @JsonProperty("Directory")
    private List<Directory> directories;


    public List<Directory> getDirectories() {
        return directories;
    }
}
