package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.controller;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;

import java.util.Scanner;
import java.util.Set;

public class Rounds {

    public void playAgain(Set <Move> moves) {

        String answer;
        do{
            new TheRockScissorsPaperGame().play(moves);
            System.out.print("Do you want to play?? ");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.next();
        } while (answer.toLowerCase().startsWith("y"));

        System.out.print("Game over ");
        System.exit(0);
    }
}