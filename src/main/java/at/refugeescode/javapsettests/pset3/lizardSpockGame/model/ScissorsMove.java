package at.refugeescode.javapsettests.pset3.lizardSpockGame.model;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.PaperMove;

public class ScissorsMove implements Move {
    @Override
    public String sayWhichMove() {
        return "Scissors";
    }

    @Override
    public boolean wins(Move move) {
        return (move.getClass() == PaperMove.class || move.getClass() == LizardMove.class);
    }
}
