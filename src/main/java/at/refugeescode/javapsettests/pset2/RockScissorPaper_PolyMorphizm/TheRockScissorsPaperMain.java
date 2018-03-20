package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.controller.Rounds;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.GroupOfMoves;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;

import java.util.Set;

public class TheRockScissorsPaperMain {

    public static void main(String[] args) {
        Set <Move> moves = GroupOfMoves.getMoves();
        new Rounds().playAgain(moves);
    }
}
