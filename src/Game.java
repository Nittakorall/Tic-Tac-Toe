import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    public Game() {
    }

    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game!");
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        System.out.println("Press 1 for one player \nPress 2 for two players");
        String oneOrTwoPlayers;
        while (true) {
            oneOrTwoPlayers = sc.nextLine();
            if (oneOrTwoPlayers.equals("1") || oneOrTwoPlayers.equals("2")) {
                break;
            } else {
                System.out.println("Invalid input, try again");
            }
        }
        System.out.println("First player, what's your name?");
        String playerName;
        playerName = sc.nextLine();
        Player p1 = new Player(playerName, "X", false);


        if (oneOrTwoPlayers.equals("2")) {
            System.out.println("Nice to meet you, " + playerName + "! Second player, what's your name?");
            playerName = sc.nextLine();
            Player p2 = new Player(playerName, "O", false);
            if (p1.getName().equals(p2.getName())) {
                p1.setName(p1.getName() + " (X)");
                p2.setName(p2.getName() + " (O)");
                System.out.println("Oh no, you have same names! First player will be " + p1.getName() + " and second player will be " + p2.getName());
            } else {
                System.out.println("Nice to meet you too, " + p2.getName() + "! \nLet's begin! \n \nYou can pick between a1-a3, b1-b3 and c1-c3: \n");
            }
            System.out.println(" a1| a2| a3");
            System.out.println("---+---+---");
            System.out.println(" b1| b2| b3 ");
            System.out.println("---+---+---");
            System.out.println(" c1| c2| c3 \n");

            gameStart(firstPlayerScore, secondPlayerScore, p1, p2, sc);
        } else if (oneOrTwoPlayers.equals("1")) {

            System.out.println("Nice to meet you, " + playerName + "! ");
            Player p2 = new Player("Computer", "O", true);
            if (p1.getName().equals(p2.getName())) {
                p1.setName(p1.getName() + " (X)");
                p2.setName(p2.getName() + " (O)");
                System.out.println("Oh no, you have same names! First player will be " + p1.getName() + " and second player will be " + p2.getName());
            }
            System.out.println("Let's begin! \n \nYou can pick between a1-a3, b1-b3 and c1-c3: \n");
            System.out.println(" a1| a2| a3");
            System.out.println("---+---+---");
            System.out.println(" b1| b2| b3 ");
            System.out.println("---+---+---");
            System.out.println(" c1| c2| c3 \n");

            gameStart(firstPlayerScore, secondPlayerScore, p1, p2, sc);
        }
    }


    public static void gameStart(int firstPlayerScore, int secondPlayerScore, Player p1, Player p2, Scanner sc) {

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
        int randomSquareIndex = (int) (Math.random() * allSquares.size());//randomizer for computer-player

        boolean isFirstPlayer = true; // checks which player was last, need to find the winner.
        mainGame(p1, p2, sc, allSquares, isFirstPlayer, firstPlayerScore, secondPlayerScore, randomSquareIndex);
    }

    public static void mainGame(Player p1, Player p2, Scanner sc, ArrayList<TicTacToeSquare> allSquares, boolean isFirstPlayer,
                                int firstPlayerScore, int secondPlayerScore, int randomSquareIndex) {
        if ((allSquares.get(0).getValue().equals(allSquares.get(1).getValue()) && allSquares.get(1).getValue().equals(allSquares.get(2).getValue()) && !allSquares.get(0).getValue().equals(" ")) //each stands for any kind of winning (in a row och in a column)
                || (allSquares.get(3).getValue().equals(allSquares.get(4).getValue()) && allSquares.get(4).getValue().equals(allSquares.get(5).getValue()) && !allSquares.get(3).getValue().equals(" "))
                || (allSquares.get(6).getValue().equals(allSquares.get(7).getValue()) && allSquares.get(7).getValue().equals(allSquares.get(8).getValue()) && !allSquares.get(6).getValue().equals(" "))
                || (allSquares.get(0).getValue().equals(allSquares.get(3).getValue()) && allSquares.get(3).getValue().equals(allSquares.get(6).getValue()) && !allSquares.get(6).getValue().equals(" "))
                || (allSquares.get(2).getValue().equals(allSquares.get(4).getValue()) && allSquares.get(4).getValue().equals(allSquares.get(7).getValue()) && !allSquares.get(7).getValue().equals(" "))
                || (allSquares.get(2).getValue().equals(allSquares.get(5).getValue()) && allSquares.get(5).getValue().equals(allSquares.get(8).getValue()) && !allSquares.get(8).getValue().equals(" "))
                || (allSquares.get(2).getValue().equals(allSquares.get(4).getValue()) && allSquares.get(6).getValue().equals(allSquares.get(4).getValue()) && !allSquares.get(6).getValue().equals(" "))
                || (allSquares.get(0).getValue().equals(allSquares.get(4).getValue()) && allSquares.get(4).getValue().equals(allSquares.get(8).getValue()) && !allSquares.get(8).getValue().equals(" "))) {
            if (isFirstPlayer == true) {
                System.out.println(p1.getName() + " wins!");
                firstPlayerScore++;
                System.out.println("Total score is " + firstPlayerScore + ":" + secondPlayerScore);
                playAgainQuestion(p1, p2, sc, firstPlayerScore, secondPlayerScore);


            } else {
                System.out.println(p2.getName() + " wins!");
                secondPlayerScore++;
                System.out.println("Total score is " + firstPlayerScore + ":" + secondPlayerScore);
                playAgainQuestion(p1, p2, sc, firstPlayerScore, secondPlayerScore);
            }
        } else if (!allSquares.get(0).getValue().equals(" ") && !allSquares.get(1).getValue().equals(" ") && !allSquares.get(2).getValue().equals(" ") && //no square is empty
                !allSquares.get(3).getValue().equals(" ") && !allSquares.get(4).getValue().equals(" ") && !allSquares.get(5).getValue().equals(" ") &&
                !allSquares.get(6).getValue().equals(" ") && !allSquares.get(7).getValue().equals(" ") && !allSquares.get(8).getValue().equals(" ")) {
            System.out.println("No one wins");
            System.out.println("Total score is " + firstPlayerScore + ":" + secondPlayerScore);
            playAgainQuestion(p1, p2, sc, firstPlayerScore, secondPlayerScore);
        } else {
            if ((p1.getIsTurn() == false && p2.getIsTurn() == true) || (p1.getIsTurn() == true && p2.getIsTurn() == false)) {
                p2.move(sc, allSquares, randomSquareIndex);
                isFirstPlayer = false;
            } else {

                p1.move(sc, allSquares, randomSquareIndex);
                isFirstPlayer = true;
            }
            mainGame(p1, p2, sc, allSquares, isFirstPlayer, firstPlayerScore, secondPlayerScore, randomSquareIndex);
        }

    }

    static void playAgainQuestion(Player p1, Player p2, Scanner sc, int firstPlayerScore, int secondPlayerScore) {
        System.out.println("Would you like to play one more time? yes/no");
        while (true) {
            String playAgainAnswer = sc.nextLine();
            String playAgainAnswerLowerCase = playAgainAnswer.toLowerCase();// doesn't work

            if (playAgainAnswerLowerCase.equals("yes") || playAgainAnswerLowerCase.equals("no")) {

                if (playAgainAnswerLowerCase.equals("yes")) {
                    System.out.println("\nLet's play one more time!");
                    gameStart(firstPlayerScore, secondPlayerScore, p1, p2, sc);
                    return;
                } else {
                    System.out.println("That was fun. Come again!");
                }
                break;
            }

            System.out.println("Invalid answer. Would you like to play again? yes/no");
        }
    }

}
