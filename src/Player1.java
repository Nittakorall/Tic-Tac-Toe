import java.util.ArrayList;
import java.util.Scanner;

public class Player1 extends Player implements Move {
    public Player1(String name) {
        super(name, "X", true);
    }


    @Override
    public void move(Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares) {
        System.out.println(name + ", what's your next move?");
        loopThroughTheField(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
        isTurn =!isTurn;
    }

    void loopThroughTheField(Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares) {
        String answer = sc.nextLine();
        for (TicTacToeSquare s : allSquares) {
            if (answer.equals(s.getPlace()) && s.getValue().equals(" ")) {
                s.setValue(symbol);
                System.out.println(" " + a1.getValue() + " | " + a2.getValue() + " | " + a3.getValue() + " ");
                System.out.println("---+---+---");
                System.out.println(" " + b1.getValue() + " | " + b2.getValue() + " | " + b3.getValue() + " ");
                System.out.println("---+---+---");
                System.out.println(" " + c1.getValue() + " | " + c2.getValue() + " | " + c3.getValue() + " ");

            } else if (answer.equals(s.getPlace()) && !s.getValue().equals(" ")) {
                System.out.println("Square is taken");
                loopThroughTheField(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
            } else if (!answer.equals("a1") && !answer.equals("a2") && !answer.equals("a3")
                    && !answer.equals("b1") && !answer.equals("b2") && !answer.equals("b3")
                    && !answer.equals("c1") && !answer.equals("c2") && !answer.equals("c3")) {
                System.out.println("Please pick any empty square from a1 to c1");
                loopThroughTheField(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
            }
        }

    }

}


