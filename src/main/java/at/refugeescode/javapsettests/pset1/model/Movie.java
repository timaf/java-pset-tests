package at.refugeescode.javapsettests.pset1.model;

import java.util.Set;

public class Movie {

    private String title;
    private Set<String> genres;
    private Double rating;

    public Movie(String title, Set <String> genres, Double rating) {
        this.title = title;
        this.genres = genres;
        this.rating = rating;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genres=" + genres +
                ", rating=" + rating +
                '}';
    }
}
