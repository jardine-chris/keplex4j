package com.keplux.keplex4j.services;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
public enum Uri {
    LIBRARY ("/library"),
    SECTIONS ("library/sections/"),
    RECENTLY_ADDED ("library/recentlyAdded/"),
    ON_DECK ("library/onDeck/");

    private String uri;

    Uri(String uri) {
        this.uri = uri;
    }

    public String get() {
        return uri;
    }

    public void set(String uri) {
        this.uri = uri;
    }
}
