import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    protected String name;
    protected String symbol;
    protected boolean isTurn;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;

    }

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
                        System.out.println(" " + a1.getValue() + " | " + a2.getValue() + " | " + a3.getValue() + " ");
                        System.out.println("---+---+---");
                        System.out.println(" " + b1.getValue() + " | " + b2.getValue() + " | " + b3.getValue() + " ");
                        System.out.println("---+---+---");
                        System.out.println(" " + c1.getValue() + " | " + c2.getValue() + " | " + c3.getValue() + " \n");
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

    public boolean getIsTurn() {
        return isTurn;
    }


    public String getSymbol() {
        return symbol;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
