package com.keplux.keplex4j.components;

import com.keplux.keplex4j.services.RequestService;
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

    public List<String> getLibraries() throws IOException, InterruptedException {
        return requestService.getLibraries();
    }
}
