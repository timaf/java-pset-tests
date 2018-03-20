package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.players;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ComputerPlayer implements Player {

    @Override
    public Move makeAmove(Set<Move> moves) {
        List <Move> theMoves = new ArrayList <>(moves);
        Collections.shuffle(theMoves);
        return theMoves.get(0);
    }
}