package com.keplux.keplex4j.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.keplux.keplex4j.components.Directory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class LibraryService {
    @JsonProperty("size")
    private Integer size;

    @JsonProperty("Directory")
    private List<Directory> directories;


    public List<String> getDirectoryKeys() {
        List<String> keys = new ArrayList<>();
        for (Directory directory : directories) {
            keys.add(directory.getKey());
        }
        return keys;
    }

    public Map<String, String> getLibraryKeys(String key) {
        Map<String, String> kvMap = new HashMap<>();
        for (Directory directory : directories) {
            kvMap.put("key", directory.getKey());
            kvMap.put("title", directory.getTitle());
        }
        return kvMap;
    }
}
