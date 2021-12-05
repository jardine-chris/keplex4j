package com.keplux.keplex4j.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keplux.keplex4j.components.Directory;
import com.keplux.keplex4j.components.Response;
import com.keplux.keplex4j.config.ClientConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>A service that sends requests to Plex Media Server. This service
 * implements
 * Spring's
 * <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html">{@code WebClient}</a> interface, all requests are made with the
 * {@code block()} method. Therefore, all requests are
 * <strong>synchronous</strong>.</p>
 *
 * <p>Requests are configured by the {@link ClientConfiguration} class. If
 * you are
 * getting errors, please see the documentation for configuration information
 * .</p>
 *
 * @author Chris Jardine
 * @version 0.1
 * @see ClientConfiguration
 */
@Service
public class RequestService {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ClientConfiguration config;

    /**
     * Helper method to reduce code duplication.
     *
     * @param uri The location of the resource being requested.
     * @return The response transformed into a POJO.
     */
    private Response getRequest(PlexUri uri) {
        ObjectMapper mapper = new ObjectMapper();
        Response response = config.webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(uri.get())
                        .queryParam("X-Plex-Token", config.getToken())
                        .build())
                .retrieve()
                .bodyToMono(Response.class)
                .block();
        logger.info(String.format("[GET - \"%s\"] -> [RESPONSE - %s]",
                uri.get(),
                response.getDirectory()));

        return response;
    }

    /**
     * Retrieve a list of directories referenced in the resource.
     *
     * @return A list of directories.
     */
    public List<Directory> getContent() {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.BASE)
                .build();
        return getRequest(uri).getDirectory();
    }

    public List<Directory> getContent(String key) {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.SECTIONS)
                .key(key)
                .build();
        return getRequest(uri).getDirectory();
    }

    public List<Directory> getContent(String key,
                                      FilterUri filterUri) {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.SECTIONS)
                .key(key)
                .filterUri(filterUri)
                .build();
        return getRequest(uri).getDirectory();
    }

    public List<Directory> getRecentlyAdded() {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.RECENTLY_ADDED)
                .build();
        return getRequest(uri).getDirectory();
    }

    public List<Directory> getRecentlyAdded(String key) {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.SECTIONS)
                .key(key)
                .filterUri(FilterUri.RECENTLY_ADDED)
                .build();
        return getRequest(uri).getDirectory();
    }

    public List<Directory> getOnDeck() {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.ON_DECK)
                .build();
        return getRequest(uri).getDirectory();
    }

    public List<Directory> getOnDeck(String key) {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.SECTIONS)
                .key(key)
                .filterUri(FilterUri.ON_DECK)
                .build();
        return getRequest(uri).getDirectory();
    }
}
