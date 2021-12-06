package com.keplux.keplex4j;

import com.keplux.keplex4j.components.Client;
import com.keplux.keplex4j.components.Directory;
import com.keplux.keplex4j.services.FilterUri;
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
        List<Directory> baseDirectory = client.getBaseDirectories();
        List<Directory> sectionDirectory = client.getSectionDirectories("1");
        List<Directory> directory = client.getSection("1", FilterUri.NEWEST);
        List<Directory> recentlyAdded = client.getRecentlyAdded();
        List<Directory> recentlyAddedMovies = client.getRecentlyAdded("1");
        List<Directory> onDeck = client.getOnDeck();
        List<Directory> moviesOnDeck = client.getOnDeck("1");
        List<Directory> searchHell = client.search("ass");
    }
}
