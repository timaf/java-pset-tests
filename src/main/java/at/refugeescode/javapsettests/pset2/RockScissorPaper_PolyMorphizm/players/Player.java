package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.players;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.GroupOfMoves;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;

import java.util.Set;


public interface Player {
    Move makeAmove(Set <Move> moves);
}
