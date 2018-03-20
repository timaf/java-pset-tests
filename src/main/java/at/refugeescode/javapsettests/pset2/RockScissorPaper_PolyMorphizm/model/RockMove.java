package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model;

public class RockMove implements Move {

    RockMove() {
    }

    @Override
    public String sayWhichMove() {
        return "Rock";
    }

    @Override
    public boolean wins(Move move) {
        return move.getClass() == ScissorsMove.class;
    }
}


