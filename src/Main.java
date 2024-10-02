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
        mainGame(p1, p2, sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);

    }

    public static void mainGame(Player1 p1, Player2 p2, Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares) {
        if ((a1.getValue().equals(a2.getValue()) && a2.getValue().equals(a3.getValue()) && !a1.getValue().equals(" ")) //each stands for any kind of winning (in a row och in a column)
                || (b1.getValue().equals(b2.getValue()) && b2.getValue().equals(b3.getValue()) && !b1.getValue().equals(" "))
                || (c1.getValue().equals(c2.getValue()) && c2.getValue().equals(c3.getValue()) && !c1.getValue().equals(" "))
                || (a1.getValue().equals(b1.getValue()) && b1.getValue().equals(c1.getValue()) && !c1.getValue().equals(" "))
                ||(a2.getValue().equals(b2.getValue()) && b2.getValue().equals(c2.getValue()) && !c2.getValue().equals(" "))
        || (a3.getValue().equals(b3.getValue()) && b3.getValue().equals(c3.getValue()) && !c3.getValue().equals(" "))
        ||(a3.getValue().equals(b2.getValue()) && b2.getValue().equals(c1.getValue()) && !c1.getValue().equals(" "))
        || (a1.getValue().equals(b2.getValue()) && b2.getValue().equals(c3.getValue()) && !c3.getValue().equals(" "))) {
            System.out.println("We have a winner"); //find a way to chech who won
        } else {
            if ((p1.getIsTurn() == false && p2.getIsTurn() == true) || (p1.getIsTurn() == true && p2.getIsTurn() == false)) {
                p2.move(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
            } else {
                p1.move(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
            } mainGame(p1, p2, sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
        }

    }

}




