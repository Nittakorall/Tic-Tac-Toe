import java.util.ArrayList;
import java.util.Scanner;

public class Player1 extends Player implements Move {
    public Player1(String name) {
        super(name, "X", true);
    }


    @Override
    public void move(Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares) {
        System.out.println(name + ", what's your next move?");
        String answer = sc.nextLine();
        //  boolean correctAnswerFound = false;//Needs for loop that checks if users answer fits to the game, true when right answer found
        //    boolean firstLoop = true; // checks if player already played, if false, for loop breaks and player 2 can play.

        for (TicTacToeSquare s : allSquares) {
            if (answer.equals(s.getPlace()) && s.getValue().equals(" ")) {
                s.setValue(symbol);

                System.out.println(" " + a1.getValue() + " | " + a2.getValue() + " | " + a3.getValue() + " ");
                System.out.println("---+---+---");
                System.out.println(" " + b1.getValue() + " | " + b2.getValue() + " | " + b3.getValue() + " ");
                System.out.println("---+---+---");
                System.out.println(" " + c1.getValue() + " | " + c2.getValue() + " | " + c3.getValue() + " ");

            }

        }
        isTurn = !isTurn;
    }
}

