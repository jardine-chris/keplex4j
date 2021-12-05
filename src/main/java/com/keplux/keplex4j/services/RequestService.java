package com.keplux.keplex4j.services;

import com.keplux.keplex4j.components.Content;
import com.keplux.keplex4j.components.MediaContainer;
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
 * <p>Requests are configured by the {@link ClientConfiguration} class. If you are
 * getting errors, please see the documentation for configuration information.</p>
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
     * @param uri The location of the resource being requested.
     * @return The response transformed into a POJO.
     */
    private MediaContainer getRequest(Uri uri) {
        MediaContainer container = config.webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(uri.get())
                        .queryParam("X-Plex-Token", config.getToken())
                        .build())
                .retrieve()
                .bodyToMono(MediaContainer.class)
                .block();
        logger.info(String.format("[GET - \"%s\"] -> [RESPONSE - %s]",
                uri.get(),
                container.getClientService().getContent()));

        return container;
    }

    /**
     * Retrieve a list of directories referenced in the resource.
     *
     * @param uri The location of the resource being requested.
     * @return A list of directories.
     */
    public List<Content> getContent(Uri uri) {
        MediaContainer container = getRequest(uri);
        return container.getClientService().getContent();
    }

    public List<Content> getContent(Uri uri, String key) {
        uri.set(uri.get() + key);
        MediaContainer container = getRequest(uri);
        return container.getClientService().getContent();
    }
}
