package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.controller;

import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    private Judge judge = new Judge();
    private Move move1;
    private Move move2;

    @BeforeEach
    public void before() {
        move1 = Mockito.mock(Move.class);
        move2 = Mockito.mock(Move.class);
    }


    @Test
    void judgeMove1() {
        Mockito.when(move1.wins(move2)).thenReturn(true);
        Result result1 = this.judge.judge(move1, move2);
        assertEquals(result1.getWinner(), "Player 1 wins");
    }

    @Test
    void judgeMove2() {
        Mockito.when(move2.wins(move1)).thenReturn(true);
        Result result2 = this.judge.judge(move1, move2);
        assertEquals(result2.getWinner(), "Player 2 wins");
    }

    @Test
    void judgeEquel(){
        Result result2 = this.judge.judge(move1, move2);
        assertEquals(result2.getWinner(), "No one wins");
}




}