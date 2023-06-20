package org.lessons.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BotyController {

    @GetMapping("/")
    public String home(Model model) {
        String name = "Daniel";
        model.addAttribute("name", name);
        return "index";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Wolf of Wall Street"));
        movies.add(new Movie(2, "Interstellar"));
        movies.add(new Movie(3, "Inception"));
        movies.add(new Movie(4, "Catch me if you can"));

        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Darkroom"));
        songs.add(new Song(2, "Freedom"));
        songs.add(new Song(3, "GTA"));
        songs.add(new Song(4, "Get up off the floor"));

        return songs;
    }

    @GetMapping("/movies")
    public String movieTitles(Model model) {
        List<Movie> movies = getBestMovies();
        List<String> movieTitles = new ArrayList<>();
        for (Movie m : movies) {
            movieTitles.add(m.getTitle());
        }

        String titles = String.join(", ", movieTitles);
        model.addAttribute("titles", titles);
        return "movies";
    }

    @GetMapping("/songs")
    public String songTitles(Model model) {
        List<Song> songs = getBestSongs();
        List<String> songTitles = new ArrayList<>();
        for (Song s : songs) {
            songTitles.add(s.getTitle());
        }

        String titles = String.join(", ", songTitles);
        model.addAttribute("titles", titles);
        return "songs";
    }

    public class Movie {
        private int id;
        private String title;

        public Movie(int id, String title) {
            this.id = id;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public class Song {
        private int id;
        private String title;

        public Song(int id, String title) {
            this.id = id;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}