package com.keplux.keplex4j.components;

import com.keplux.keplex4j.services.RequestService;
import com.keplux.keplex4j.services.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

    public List<Directory> getDirectories(Uri uri) {
        return requestService.getDirectories(uri);
    }
}
