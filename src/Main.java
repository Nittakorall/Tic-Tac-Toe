import java.util.Scanner;

// add empty user name??


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //moved Player objects here to prevent name changing if the game restarts. Full restart needed to change names
     Game game = new Game();
        System.out.println("Welcome to the game!");
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        System.out.println("First player, what's your name?");
        String playerName;
            playerName = sc.nextLine();
        Player p1 = new Player(playerName, "X");
        System.out.println("Nice to meet you, " + playerName + "! Second player, what's your name?");
        playerName = sc.nextLine();
        Player p2 = new Player(playerName, "O");
        if (p1.getName().equals(p2.getName())) {
            p1.setName(p1.getName() + " (X)");
            p2.setName(p2.getName() + " (O)");
            System.out.println("Oh no, you have same names! First player will be " + p1.getName() + " and second player will be " + p2.getName());
        }
        else {
            System.out.println("Nice to meet you too, " + p2.getName() + "! \nLet's begin! \n \nYou can pick between a1-a3, b1-b3 and c1-c3: \n");
            System.out.println(" a1| a2| a3");
            System.out.println("---+---+---");
            System.out.println(" b1| b2| b3 ");
            System.out.println("---+---+---");
            System.out.println(" c1| c2| c3 \n");
        }
     game.game(firstPlayerScore, secondPlayerScore, p1, p2);
    }

}




