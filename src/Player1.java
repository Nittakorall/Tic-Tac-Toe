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
        isTurn = !isTurn;
    }

    void loopThroughTheField(Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares) {
        while (true) {
            String answer = sc.nextLine();
            boolean validInput = false;
            String answerLowerCase = answer.toLowerCase();
            for (TicTacToeSquare s : allSquares) {
                if (answerLowerCase.equals(s.getPlace())) {
                    validInput = true;
                    if (s.getValue().equals(" ")) {
                        s.setValue(symbol);
                        System.out.println("a(1-3)   " + a1.getValue() + " | " + a2.getValue() + " | " + a3.getValue() + " ");
                        System.out.println("        ---+---+---");
                        System.out.println("b(1-3)   " + b1.getValue() + " | " + b2.getValue() + " | " + b3.getValue() + " ");
                        System.out.println("        ---+---+---");
                        System.out.println("c(1-3)   " + c1.getValue() + " | " + c2.getValue() + " | " + c3.getValue() + " \n");
                        return; // Avsluta både loopen och metoden när en giltig och ledig plats är vald (Aizo)
                    } else {
                        System.out.println("Square is taken. Please pick another one.");
                    }
                    break; // Avsluta loopen när en matchande plats hittas (Aizo)
                }
            }

            if (!validInput) {
                System.out.println("Please pick a valid square from a1 to c3.");
            }
        }
    }

}
