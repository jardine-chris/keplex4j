package com.keplux.keplex4j.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.keplux.keplex4j.services.LibraryService;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MediaContainer {
    @JsonProperty("MediaContainer")
    private LibraryService libraryService;

    public List<String> getDirectories() {
        return libraryService.getDirectoryKeys();
    }
}
