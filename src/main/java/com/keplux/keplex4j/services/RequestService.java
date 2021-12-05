package com.keplux.keplex4j.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keplux.keplex4j.components.Directory;
import com.keplux.keplex4j.components.MediaContainer;
import com.keplux.keplex4j.config.ClientConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
@Service
public class RequestService {
    protected final Log logger = LogFactory.getLog(getClass());
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ClientConfiguration config;

    private MediaContainer getRequest(String uri) {
        return config.webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(uri)
                        .queryParam("X-Plex-Token", config.getToken())
                        .build())
                .retrieve()
                .bodyToMono(MediaContainer.class)
                .block();
    }

    /**
     * Get a list of the available keys from the {@code "/library"} resource.
     *
     * @return A list of available keys from the {@code "/library"} resource.
     */
    public List<String> getLibraries() {
        String uri = "/library";
        MediaContainer container = getRequest(uri);
        logger.info(String.format("[GET - \"%s\"] -> [RESPONSE - %s]", uri,
                container.getDirectories()));
        Map<Directory, Map<String, String>> map;
        return container.getDirectories();
    }
}
