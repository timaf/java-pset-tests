package at.refugeescode.javapsettests.pset3.lizardSpockGame;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.controller.Rounds;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.GroupOfMoves;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;

import java.util.Set;

public class TheLizardSpockMain {

    public static void main(String[] args) {
        Set <Move> moves = GroupOfMoves.getNewMoves();
        new Rounds().playAgain(moves);
    }
}

