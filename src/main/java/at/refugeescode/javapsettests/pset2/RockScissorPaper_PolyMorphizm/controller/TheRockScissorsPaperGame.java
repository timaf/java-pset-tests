package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.controller;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.players.HumanPlayer;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.players.Player;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.players.ComputerPlayer;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.view.Display;

import java.util.Set;


public class TheRockScissorsPaperGame {

    private Player player1 = new HumanPlayer();
    private Player player2 = new ComputerPlayer();
    private Judge judge = new Judge();
    private Display display = new Display();

    public void play(Set<Move> moves){

        Move move1 = player1.makeAmove(moves);
        Move move2 = player2.makeAmove(moves);
        Result result = this.judge.judge(move1, move2);
        display.display(result);
        System.out.println("*********");

    }
}
