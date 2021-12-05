package com.keplux.keplex4j.services;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
public enum FilterUris {
    ALL ("/all"),
    UNWATCHED ( "/unwatched"),
    NEWEST ( "/newest"),
    RECENTLY_ADDED ( "/recentlyAdded"),
    RECENTLY_VIEWED ( "/recentlyViewed"),
    ON_DECK ( "/onDeck");

    private String uri;

    FilterUris(String uri) {
        this.uri = uri;
    }

    public String get() {
        return uri;
    }

    public void set(String uri) {
        this.uri = uri;
    }
}
