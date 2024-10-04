import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    public Game() {
    }

    public static void game(int firstPlayerScore, int secondPlayerScore) {
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
        System.out.println("First player, what's your name?");
        String playerName = sc.nextLine();
        Player1 p1 = new Player1(playerName);
        System.out.println("Nice to meet you, " + playerName + "! Second player, what's your name?");
        playerName = sc.nextLine();
        Player2 p2 = new Player2(playerName);
        if (p1.getName().equals(p2.getName())) {
            p1.setName(p1.getName() + " (X)");
            p2.setName(p2.getName() + " (O)");
            System.out.println("Oh no, you have same names! First player will be " + p1.getName() + " and second player will be " + p2.getName());
        }
        else {
            System.out.println("Nice to meet you too, " + p2.getName());
        }
        boolean isFirstPlayer = true; // checks which player was last, need to find the winner.
        System.out.println("Time to start!");
        mainGame(p1, p2, sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares, isFirstPlayer, firstPlayerScore, secondPlayerScore);
    }

    public static void mainGame(Player1 p1, Player2 p2, Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares, boolean isFirstPlayer, int firstPlayerScore, int secondPlayerScore) {
        if ((a1.getValue().equals(a2.getValue()) && a2.getValue().equals(a3.getValue()) && !a1.getValue().equals(" ")) //each stands for any kind of winning (in a row och in a column)
                || (b1.getValue().equals(b2.getValue()) && b2.getValue().equals(b3.getValue()) && !b1.getValue().equals(" "))
                || (c1.getValue().equals(c2.getValue()) && c2.getValue().equals(c3.getValue()) && !c1.getValue().equals(" "))
                || (a1.getValue().equals(b1.getValue()) && b1.getValue().equals(c1.getValue()) && !c1.getValue().equals(" "))
                || (a2.getValue().equals(b2.getValue()) && b2.getValue().equals(c2.getValue()) && !c2.getValue().equals(" "))
                || (a3.getValue().equals(b3.getValue()) && b3.getValue().equals(c3.getValue()) && !c3.getValue().equals(" "))
                || (a3.getValue().equals(b2.getValue()) && b2.getValue().equals(c1.getValue()) && !c1.getValue().equals(" "))
                || (a1.getValue().equals(b2.getValue()) && b2.getValue().equals(c3.getValue()) && !c3.getValue().equals(" "))) {
            if (isFirstPlayer == true) {
                System.out.println(p1.getName() + "wins!");
                firstPlayerScore++;
                System.out.println("Total score is " + firstPlayerScore + ":" + secondPlayerScore);
                playAgainQuestion(p1, p2, sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares, isFirstPlayer, firstPlayerScore, secondPlayerScore);


            } else {
                System.out.println(p2.getName() + "wins!");
               secondPlayerScore++;
                System.out.println("Total score is " + firstPlayerScore + ":" + secondPlayerScore);
                playAgainQuestion(p1, p2, sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares, isFirstPlayer, firstPlayerScore, secondPlayerScore);
            }
        } else if (!a1.getValue().equals(" ") && !a2.getValue().equals(" ") && !a3.getValue().equals(" ") && //no square is empty
                !b1.getValue().equals(" ") && !b2.getValue().equals(" ") && !b3.getValue().equals(" ") &&
                !c1.getValue().equals(" ") && !c2.getValue().equals(" ") && !c3.getValue().equals(" ")) {
            System.out.println("No one won");
            System.out.println("Total score is " + firstPlayerScore + ":" + secondPlayerScore);
            playAgainQuestion(p1, p2, sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares, isFirstPlayer, firstPlayerScore, secondPlayerScore);
        } else {
            if ((p1.getIsTurn() == false && p2.getIsTurn() == true) || (p1.getIsTurn() == true && p2.getIsTurn() == false)) {
                p2.move(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
                isFirstPlayer = false;
            } else {

                p1.move(sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares);
                isFirstPlayer = true;
            }
            mainGame(p1, p2, sc, a1, a2, a3, b1, b2, b3, c1, c2, c3, allSquares, isFirstPlayer, firstPlayerScore, secondPlayerScore);
        }

    }

    static void playAgainQuestion(Player1 p1, Player2 p2, Scanner sc, TicTacToeSquare a1, TicTacToeSquare a2, TicTacToeSquare a3, TicTacToeSquare b1, TicTacToeSquare b2, TicTacToeSquare b3, TicTacToeSquare c1, TicTacToeSquare c2, TicTacToeSquare c3, ArrayList<TicTacToeSquare> allSquares, boolean isFirstPlayer, int firstPlayerScore, int secondPlayerScore) {
        System.out.println("Would you like to play one more time? yes/no");
        while (true) {
            String playAgainAnswer = sc.nextLine();
            playAgainAnswer.toLowerCase();// doesn't work
            boolean validInput = false;
            if (playAgainAnswer.equals("yes") || playAgainAnswer.equals("no")) {
                validInput = true;
                if (playAgainAnswer.equals("yes")) {
                    System.out.println("Let's play one more time!");
                    game(firstPlayerScore, secondPlayerScore);
                    return;
                } else {
                    System.out.println("That was fun. Come again!");
                }break;
            }

            System.out.println("Invalid answer. Would you like to play again? yes/no");
        }
    }
}
