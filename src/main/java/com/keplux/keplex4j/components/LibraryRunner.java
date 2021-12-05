package com.keplux.keplex4j.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LibraryRunner implements CommandLineRunner {
    @Autowired
    private Client client;

    @Override
    public void run(String... args) throws Exception {
        client.getLibraries();
    }
}
