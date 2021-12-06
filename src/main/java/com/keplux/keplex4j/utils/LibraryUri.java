package com.keplux.keplex4j.utils;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
public enum LibraryUri {
    BASE ("/library"),
    SECTIONS ("/library/sections/"),
    RECENTLY_ADDED ("/library/recentlyAdded"),
    ON_DECK ("/library/onDeck"),
    SEARCH ("/search");

    private final String uri;

    LibraryUri(String uri) {
        this.uri = uri;
    }

    public String get() {
        return uri;
    }
}
