package com.keplux.keplex4j.components;

import com.keplux.keplex4j.utils.FilterUri;
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

//    public List<Directory> getBaseDirectories() {
//        return requestService.getBaseDirectories();
//    }
//
//    public List<Directory> getSectionDirectories(String key) {
//        return requestService.getSectionDirectories(key);
//    }
//
//    public List<Media> getSectionMedia(String key,
//                                              FilterUri filterUri) {
//        return requestService.getSectionMedia(key, filterUri);
//    }
//
//    public List<Media> getRecentlyAdded() {
//        return requestService.getRecentlyAdded();
//    }
//
//    public List<Media> getRecentlyAdded(String key) {
//        return requestService.getRecentlyAdded(key);
//    }
//
//    public List<Media> getOnDeck() {
//        return requestService.getOnDeck();
//    }
//
//    public List<Media> getOnDeck(String key) {
//        return requestService.getOnDeck(key);
//    }
//
//    public List<Media> search(String query) {
//        return requestService.search(query);
//    }

    public List<Movie> getMovies(String sectionId) {
        return requestService.getMoviesBySectionId(sectionId);
    }

    public MovieDetails movieDetails(Movie movie) {
        return requestService.getMovieDetails(movie.getKey());
    }
}
