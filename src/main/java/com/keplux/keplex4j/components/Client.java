package com.keplux.keplex4j.components;

import com.keplux.keplex4j.services.RequestService;
import com.keplux.keplex4j.services.LibraryUris;
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

    public List<Directory> getContent(LibraryUris libraryUris) {
        return requestService.getContent(libraryUris);
    }

    public List<Directory> getContent(LibraryUris libraryUris, String key) {
        return requestService.getContent(libraryUris, key);
    }
}
