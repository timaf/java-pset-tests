package at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.players;


import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.GroupOfMoves;
import at.refugeescode.javapsettests.pset2.RockScissorPaper_PolyMorphizm.model.Move;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class HumanPlayer implements Player {

    @Override
    public Move makeAmove(Set <Move> moves) {
        Optional <Move> move = Optional.empty();
        while (!move.isPresent()) {
            System.out.println("Player1: I have chosen, your turn . ");
            System.out.println("You have the following moves: ");
            show(moves);
            System.out.println("-----  ----  --------");
            System.out.println("Please pick your move: ");
            Scanner scanner = new Scanner(System.in);
            String humanMove = scanner.nextLine();
            move = toMove(humanMove, moves);
        }
        return move.get();
    }

    private void show(Set <Move> moves) {
        String movesList = moves.stream()
                .map(move -> move.sayWhichMove())
                .collect(joining(", "));
        System.out.println(movesList);
    }

    private Optional <Move> toMove(String humanMove, Set <Move> moves) {
        return moves.stream()
                .filter(move -> move.sayWhichMove().equalsIgnoreCase(humanMove))
                .findFirst();
    }

}
