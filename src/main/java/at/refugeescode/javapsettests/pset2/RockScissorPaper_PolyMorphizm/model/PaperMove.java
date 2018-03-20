package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model;

public class PaperMove implements Move {

    PaperMove() {
    }

    @Override
    public String sayWhichMove() {
        return "Paper";
    }

    @Override
    public boolean wins(Move move) {
        return move.getClass() == RockMove.class;
    }

}