package com.keplux.keplex4j.components;

import com.keplux.keplex4j.services.FilterUri;
import com.keplux.keplex4j.services.LibraryUri;
import com.keplux.keplex4j.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * {Description}
 *
 * @author Chris Jardine
 * @version 0.1
 */
@Component
public class Client {
    @Autowired
    private RequestService requestService;

    public List<Directory> getContent() {
        return requestService.getContent();
    }

    public List<Directory> getContent(String key) {
        return requestService.getContent(key);
    }

    public List<Directory> getContent(String key,
                                      FilterUri filterUri) {
        return requestService.getContent(key, filterUri);
    }

    public List<Directory> getRecentlyAdded() {
        return requestService.getRecentlyAdded();
    }

    public List<Directory> getRecentlyAdded(String key) {
        return requestService.getRecentlyAdded(key);
    }

    public List<Directory> getOnDeck() {
        return requestService.getOnDeck();
    }

    public List<Directory> getOnDeck(String key) {
        return requestService.getOnDeck(key);
    }
}
