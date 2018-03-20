package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model;

public class ScissorsMove implements Move {

    ScissorsMove() {
    }

    @Override
    public String sayWhichMove() {
        return "Scissors";
    }

    @Override
    public boolean wins(Move move) {
        return move.getClass() == PaperMove.class;
    }
}

