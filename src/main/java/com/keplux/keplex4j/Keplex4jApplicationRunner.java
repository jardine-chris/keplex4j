package com.keplux.keplex4j;

import com.keplux.keplex4j.components.Client;
import com.keplux.keplex4j.components.Directory;
import com.keplux.keplex4j.components.Media;
import com.keplux.keplex4j.utils.FilterUri;
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
        List<Media> directory = client.getSectionMedia("1", FilterUri.NEWEST);
        List<Media> recentlyAdded = client.getRecentlyAdded();
        List<Media> recentlyAddedMovies = client.getRecentlyAdded("1");
        List<Media> onDeck = client.getOnDeck();
        List<Media> moviesOnDeck = client.getOnDeck("1");
        List<Media> search = client.search("house of");
    }
}
