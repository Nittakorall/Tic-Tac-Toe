import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;



// add tolowercase!!!!


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //moved Player objects here to prevent name changing if the game restarts. Full restart needed to change names
     Game game = new Game();
        System.out.println("Welcome to the game!");
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
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
            System.out.println("Nice to meet you too, " + p2.getName() + "! \n Let's begin!");
        }
     game.game(firstPlayerScore, secondPlayerScore, p1, p2);
    }

}




