import java.util.Scanner;

// add empty user name??
//weird move function
//no try catch
//for many function inputs

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //moved Player objects here to prevent name changing if the game restarts. Full restart needed to change names
     Game game = new Game();

     game.game();
    }

}




