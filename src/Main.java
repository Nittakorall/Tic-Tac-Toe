import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToeSquare a1 = new TicTacToeSquare(" ", "a1");
        TicTacToeSquare a2 = new TicTacToeSquare(" ", "a2");
        TicTacToeSquare a3 = new TicTacToeSquare(" ", "a3");
        TicTacToeSquare b1 = new TicTacToeSquare(" ", "b1");
        TicTacToeSquare b2 = new TicTacToeSquare(" ", "b2");
        TicTacToeSquare b3 = new TicTacToeSquare(" ", "b3");
        TicTacToeSquare c1 = new TicTacToeSquare(" ", "c1");
        TicTacToeSquare c2 = new TicTacToeSquare(" ", "c2");
        TicTacToeSquare c3 = new TicTacToeSquare(" ", "c3");
        ArrayList<TicTacToeSquare> allSquares = new ArrayList<>();
        allSquares.add(a1);
        allSquares.add(a2);
        allSquares.add(a3);
        allSquares.add(b1);
        allSquares.add(b2);
        allSquares.add(b3);
        allSquares.add(c1);
        allSquares.add(c2);
        allSquares.add(c3);
        Player1 p1 = new Player1("P1");
        Player2 p2 = new Player2("P2");
        System.out.println("Welcome to the game!");

        while (p1.getIsTurn() == true || p2.getIsTurn() == false) {
            p1.move(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
            p2.move(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
        }
    }
}


