package at.refugeescode.javapsettests.pset1.controller;

import at.refugeescode.javapsettests.pset1.model.Actor;
import at.refugeescode.javapsettests.pset1.model.Gender;
import at.refugeescode.javapsettests.pset1.model.Movie;
import at.refugeescode.javapsettests.pset1.model.Summary;
import at.refugeescode.javapsettests.pset1.parser.ActorParser;
import at.refugeescode.javapsettests.pset1.parser.MovieParser;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieDatabaseSummarizer {

    public Summary summarize() {
        MovieParser movieParser = new MovieParser();
        ActorParser actorParser = new ActorParser();

        List <Movie> movies = movieParser.asList("src\\main\\java\\at\\refugeescode\\javapsettests\\pset1\\data\\movies.csv");
        List <Actor> actors = actorParser.asList("src\\main\\java\\at\\refugeescode\\javapsettests\\pset1\\data\\actors.csv");

        Summary summary = new Summary();
        summary.setNumberOfMovies(movies.size());
        summary.setNumberOfActors(actors.size());
        summary.setMostRatedMovies(util.getMostRated(movies));
        summary.setMostHiredActors(util.getMostHired(actors));
        summary.setMostAppearingGenres(util.getMostAppearingGenres(movies));
        summary.setMaleFemaleRatio(util.getMaleFemaleRatio(actors));
        return summary;
    }

    public class Util {

        public List <Movie> movies;
        public List <Actor> actors;

        public List <String> getMostRated(List <Movie> movies) {
            return movies.stream()
                    .sorted((e1, e2) -> e2.getRating().compareTo(e1.getRating()))
                    .limit(5)
                    .map(e -> e.getTitle() + " (" + e.getRating() + ")")
                    .collect(Collectors.toList());
        }

        public List <String> getMostHired(List <Actor> actors) {
            return actors.stream()
                    .map(actor -> actor.getName())
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .limit(5)
                    .map(e -> e.getKey() + " (" + e.getValue() + ")")
                    .collect(Collectors.toList());
        }

        public List <String> getMostAppearingGenres(List <Movie> movies) {
            return movies.stream()
                    .map(movie -> movie.getGenres())
                    .flatMap(genres -> genres.stream())
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .limit(2)
                    .map(e -> e.getKey() + " (" + e.getValue() + ")")
                    .collect(Collectors.toList());
        }

        public String getMaleFemaleRatio(List <Actor> actors) {
            double size = actors.size();
            return actors.stream()
                    .map(actor -> actor.getGender())
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .map(e -> getPercentage(size, e) + e.getKey().toString().toLowerCase())
                    .collect(Collectors.joining(", "));
        }

        private String getPercentage(double size, Map.Entry <Gender, Long> e) {
            double percentage = e.getValue() / size;
            NumberFormat formatter = new DecimalFormat("0.0 %");
            return formatter.format(percentage);
        }
    }

    private Util util = new Util();

    public Util getUtil() {
        return util;
    }
}
