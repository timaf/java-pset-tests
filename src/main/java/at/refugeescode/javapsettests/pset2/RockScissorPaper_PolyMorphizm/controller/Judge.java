package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.controller;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;

public class Judge {

    public Result judge(Move move1, Move move2){
        Result result = new Result();
        result.setMove1(move1);
        result.setMove2(move2);
        result.setWinner(findWinner(move1, move2));
        return result;
    }

    private String findWinner(Move move1, Move move2) {
        if(move1.wins(move2)){
            return "Player 1 wins";
        }
        if(move2.wins(move1)){
            return "Player 2 wins";
        }
        return "No one wins";
    }

}
