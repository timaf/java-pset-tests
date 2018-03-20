package at.refugeescode.javapsettests.pset1.controller;

import at.refugeescode.javapsettests.pset1.model.Actor;
import at.refugeescode.javapsettests.pset1.model.Gender;
import at.refugeescode.javapsettests.pset1.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MovieDatabaseSummarizerTest {
    private List <Movie> movies;
    private List <Actor> actors;
    private MovieDatabaseSummarizer movieDatabaseSummarizer;


    @BeforeEach
    void setUp() {
        movies = new LinkedList <Movie>();
        Set <String> geners1 = new HashSet ();
        Set <String> geners2 = new HashSet ();
        Set <String> geners3 = new HashSet ();
        geners1.addAll(Arrays.asList("History", "Drama", "Adventure"));
        geners2.addAll(Arrays.asList("Comedy", "History", "Crime"));
        geners3.addAll(Arrays.asList("Romance", "History" ,"Comedy"));
        this.movies.addAll(Arrays.asList(
                new Movie("Avatar",geners1,3.5 ),
                new Movie("Baby Boss",geners2,10.0 ),
                new Movie("Star War",geners3,7.0 )
        ));

        actors = new LinkedList <Actor>();
        this.actors.addAll(Arrays.asList(
                new Actor("Anjelina Jolie", Gender.FEMALE),
                new Actor("Brad Pet", Gender.MALE),
                new Actor("Julia Roberts", Gender.FEMALE),
                new Actor("Anjelina Jolie", Gender.FEMALE),
                new Actor("Brad Pet", Gender.MALE)
        ));

        movieDatabaseSummarizer = new MovieDatabaseSummarizer();

    }


    @Test
    void testMostRatedMovies(){
        List <String> mostRated = movieDatabaseSummarizer.getUtil().getMostRated(movies);
        String[] myList = {
                "Baby Boss (10.0)",
                "Star War (7.0)",
                "Avatar (3.5)"};
        assertArrayEquals(mostRated.toArray(new String[mostRated.size()]), myList);
    }

    @Test
    void testMostAppearingGenres(){
        List <String> mostAppearingGenres = movieDatabaseSummarizer.getUtil().getMostAppearingGenres(movies);
        List<String> myGenres = new LinkedList <String>();
        myGenres.addAll(Arrays.asList("History (3)", "Comedy (2)"));
        assertEquals(mostAppearingGenres, myGenres);
        }

    @Test
    void testMostHired(){
        List <String> mostHired = movieDatabaseSummarizer.getUtil().getMostHired(actors);
        List <String> myActors = new LinkedList <String>();
        myActors.addAll(Arrays.asList("Brad Pet (2)", "Anjelina Jolie (2)", "Julia Roberts (1)"));
        assertEquals(mostHired, myActors);
    }

    @Test
    void testMaleFemaleRatio (){
        String maleFemaleRatio = movieDatabaseSummarizer.getUtil().getMaleFemaleRatio(actors);
        assertEquals(maleFemaleRatio, "60.0 %female, 40.0 %male");
    }
}

