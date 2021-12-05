package com.keplux.keplex4j;

import com.keplux.keplex4j.components.Client;
import com.keplux.keplex4j.components.Content;
import com.keplux.keplex4j.services.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Keplex4jApplicationRunner implements CommandLineRunner {
    @Autowired
    private Client client;

    @Override
    public void run(String... args) {
        List<Content> content = client.getContent(Uri.LIBRARY_SECTIONS_BY_KEY, "1/recentlyAdded");
    }
}
