package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import at.refugeescode.javapsettests.pset3.lizardSpockGame.model.*;


public class GroupOfMoves {

    private static Set<Move> moves = Stream.of(
            new PaperMove(),
            new RockMove(),
            new ScissorsMove()
    ).collect(Collectors.toSet());

    private  static Set<Move> newMoves = Stream.of(
            new PaperMove(),
            new RockMove(),
            new ScissorsMove(),
            new LizardMove(),
            new SpockMove()
    ) .collect(Collectors.toSet());

    public GroupOfMoves(){
    }

    public static Set<Move> getMoves()  {
        return new HashSet <Move>(moves);
    }
    public static Set<Move> getNewMoves(){ return new HashSet <Move>(newMoves); }
}
