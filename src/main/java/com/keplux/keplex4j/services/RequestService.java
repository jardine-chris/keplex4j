package com.keplux.keplex4j.services;

import com.keplux.keplex4j.components.Directory;
import com.keplux.keplex4j.components.MediaContainer;
import com.keplux.keplex4j.config.ClientConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keplux.keplex4j.services.Uri;

import java.util.List;
import java.util.Map;

import static com.keplux.keplex4j.services.Uri.*;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
@Service
public class RequestService {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ClientConfiguration config;

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
        logger.info(String.format("[GET - \"%s\"] -> [RESPONSE - %s]", uri.get(),
                container.getClientService().getDirectories()));

        return container;
    }

    public List<Directory> getDirectories(Uri uri) {
        MediaContainer container = getRequest(uri);
        return container.getClientService().getDirectories();
    }
}
