import java.util.ArrayList;
import java.util.Scanner;

public class Player2 extends Player implements Move {
    public Player2(String name) {
        super(name, "O", false);
    }

    @Override
    public void move(Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares, int a) {
        System.out.println(name + ", what's your next move?");
        String answer = sc.nextLine();
        //answer = a3;
        //crate a list with strings and loop, when match replace strings value with players symbol
        for (TicTacToeSquare s : allSquares) {

            if (answer.equals(s.getPlace())) {
                s.setValue(symbol);


                System.out.println(" " + a1.getValue() + " | " + a2.getValue() + " | " + a3.getValue() + " ");
                System.out.println("--- --- ---");
                System.out.println(" " + b1.getValue() + " | " + b2.getValue() + " | " + b3.getValue() + " ");
                System.out.println("--- --- ---");
                System.out.println(" " + c1.getValue() + " | " + c2.getValue() + " | " + c3.getValue() + " ");

                isTurn = !isTurn;
a++;
            }

        }


    }
}
