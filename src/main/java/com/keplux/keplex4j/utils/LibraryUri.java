package com.keplux.keplex4j.utils;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
public enum LibraryUri {
    ALL ("/all"),
    SECTIONS ("/library/sections/"),
    RECENTLY_ADDED ("/recentlyAdded");

    private final String uri;

    LibraryUri(String uri) {
        this.uri = uri;
    }

    public String get() {
        return uri;
    }
}
