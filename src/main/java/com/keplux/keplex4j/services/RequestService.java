package com.keplux.keplex4j.services;

import com.keplux.keplex4j.components.Directory;
import com.keplux.keplex4j.components.Media;
import com.keplux.keplex4j.components.Response;
import com.keplux.keplex4j.config.ClientConfiguration;
import com.keplux.keplex4j.utils.FilterUri;
import com.keplux.keplex4j.utils.LibraryUri;
import com.keplux.keplex4j.utils.PlexUri;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    private Response directoryRequest(PlexUri uri) {
        Response response = config.webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(uri.get())
                        .queryParam("X-Plex-Token", config.getToken())
                        .build())
                .retrieve()
                .bodyToMono(Response.class)
                .block();
        logger.info(String.format("    Response: %s",
                Objects.requireNonNull(response).getDirectory()));

        return response;
    }

    private Response mediaRequest(PlexUri uri) {
        Response response = config.webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(uri.get())
                        .queryParam("X-Plex-Token", config.getToken())
                        .build())
                .retrieve()
                .bodyToMono(Response.class)
                .block();
        logger.info(String.format("    Response: %s",
                Objects.requireNonNull(response).getMedia()));

        return response;
    }

    private Response searchRequest(String query) {
        Response response = config.webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(LibraryUri.SEARCH.get())
                        .queryParam("query", query)
                        .queryParam("X-Plex-Token", config.getToken())
                        .build())
                .retrieve()
                .bodyToMono(Response.class)
                .block();
        logger.info(String.format("    Response: %s",
                Objects.requireNonNull(response).getMedia()));
        return response;
    }

    /**
     * Retrieve a list of directories in the base library resource.
     *
     * @return A directory of resources in the base library.
     */
    public List<Directory> getBaseDirectories() {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.BASE)
                .build();
        return directoryRequest(uri).getDirectory();
    }

    /**
     * Retrieve a list of directories in the section resource with the
     * specified key.
     *
     * @param key The key of the section being searched.
     * @return A directory of resources in the specified section.
     */
    public List<Directory> getSectionDirectories(String key) {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.SECTIONS)
                .key(key)
                .build();
        return directoryRequest(uri).getDirectory();
    }

    /**
     * Retrieve a list of directories in the section resource with the specified
     * key and filter.
     *
     * @param key       The key of the section being searched.
     * @param filterUri The filter being applied to the section results.
     * @return A filtered directory of resources in the specified section.
     */
    public List<Media> getSectionMedia(String key,
                                      FilterUri filterUri) {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.SECTIONS)
                .key(key)
                .filterUri(filterUri)
                .build();
        return mediaRequest(uri).getMedia();
    }

    /**
     * Retrieve a list of directories in the base library resource that have
     * been
     * recently added.
     *
     * @return A directory of resources that have been recently added to the
     * base library.
     */
    public List<Media> getRecentlyAdded() {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.RECENTLY_ADDED)
                .build();
        return mediaRequest(uri).getMedia();
    }

    /**
     * Retrieve a list of directories in the section resource with the specified
     * key that have been recently added.
     *
     * @param key The key of the section being searched.
     * @return A directory of resources that have been recently added to the
     * specified section.
     */
    public List<Media> getRecentlyAdded(String key) {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.SECTIONS)
                .key(key)
                .filterUri(FilterUri.RECENTLY_ADDED)
                .build();
        return mediaRequest(uri).getMedia();
    }

    /**
     * Retrieve a list of directories in the base library resource that are
     * on deck.
     *
     * @return A directory of resources that are on deck in the base library.
     */
    public List<Media> getOnDeck() {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.ON_DECK)
                .build();
        return mediaRequest(uri).getMedia();
    }

    /**
     * Retrieve a list of directories in the section resource with the
     * specified key
     * that are on deck.
     *
     * @param key The key of the section being searched.
     * @return A directory of resources that are on deck in the specified
     * section.
     */
    public List<Media> getOnDeck(String key) {
        PlexUri uri = PlexUri.builder()
                .libraryUri(LibraryUri.SECTIONS)
                .key(key)
                .filterUri(FilterUri.ON_DECK)
                .build();
        return mediaRequest(uri).getMedia();
    }

    public List<Media> search(String query) {
        // Replace spaces with + for the Uri.
        Response res = searchRequest(query.replaceAll(" ", "+"));
        return res.getMedia();
    }
}
