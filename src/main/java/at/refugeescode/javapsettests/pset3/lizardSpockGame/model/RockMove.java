package at.refugeescode.javapsettests.pset3.lizardSpockGame.model;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;

public class RockMove implements Move {
    @Override
    public String sayWhichMove() {
        return "Rock";
    }

    @Override
    public boolean wins(Move move) {
        return (move.getClass() == ScissorsMove.class || move.getClass() == LizardMove.class);
    }
}

