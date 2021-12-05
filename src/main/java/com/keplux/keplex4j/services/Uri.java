package com.keplux.keplex4j.services;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
public enum Uri {
    LIBRARY ("/library"),
    LIBRARY_SECTIONS ("/library/sections"),
    LIBRARY_SECTIONS_ALL ("/library/sections/all");

    private String uri;

    Uri(String uri) {
        this.uri = uri;
    }

    public String get() {
        return uri;
    }
}
