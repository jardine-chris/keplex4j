package com.keplux.keplex4j.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
@Getter
@Setter
@Builder
public class PlexUri {
    private LibraryUri libraryUri;
    private String key;
    private FilterUri filterUri;

    public String get() {
        String uri = "";
        if (libraryUri != null) {
            uri = uri + libraryUri.get();
        }
        if (key != null) {
            uri = uri + key;
        }
        if (filterUri != null) {
            uri = uri + filterUri.get();
        }
        return uri;
    }
}
