import java.util.ArrayList;
import java.util.Scanner;

public class ComputerPlayer implements Move {
    protected String name = "Computer";
    protected String symbol = "O";
    protected boolean isTurn;

    public boolean getIsTurn() {
        return isTurn;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setIsTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    @Override
    public void move(Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares) {
        int randomSquareIndex = (int) (Math.random() * allSquares.size());//randomizer for computer-player
        String randomSquare = allSquares.get(randomSquareIndex).getPlace();
        loopThroughTheField(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares, randomSquare);
        isTurn = !isTurn;
    }

    void loopThroughTheField(Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares, String randomSquare) {
        while (true) {

            for (TicTacToeSquare s : allSquares) {
                if (randomSquare.equals(s.getPlace())) {
                    if (s.getValue().equals(" ")) {
                        s.setValue(symbol);
                        System.out.println(" " + a1.getValue() + " | " + a2.getValue() + " | " + a3.getValue() + " ");
                        System.out.println("---+---+---");
                        System.out.println(" " + b1.getValue() + " | " + b2.getValue() + " | " + b3.getValue() + " ");
                        System.out.println("---+---+---");
                        System.out.println(" " + c1.getValue() + " | " + c2.getValue() + " | " + c3.getValue() + " \n");
                        return; // Avsluta både loopen och metoden när en giltig och ledig plats är vald (Aizo)

                    }
                }

            }
        }
    }
}