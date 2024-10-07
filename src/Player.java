import java.util.ArrayList;
import java.util.Scanner;

public class Player  {
    protected String name;
    protected String symbol;
    protected boolean isTurn;
    protected boolean isBot;

    public boolean getIsBot() {
        return isBot;
    }

    public void setIsBot(boolean isBot) {
        this.isBot = isBot;
    }

    public Player(String name, String symbol, boolean isBot) {
        this.name = name;
        this.symbol = symbol;
        this.isBot = isBot;
    }


    public void move(Scanner sc, ArrayList<TicTacToeSquare> allSquares, int randomSquareIndex) {
            loopThroughTheField(sc, allSquares, randomSquareIndex);
          isTurn = !isTurn;
        }


    void loopThroughTheField(Scanner sc, ArrayList<TicTacToeSquare> allSquares, int randomSquareIndex) {
        if (isBot == false) {
            System.out.println(name + ", your turn.");
            while (true) {
                String answer = sc.nextLine();
                boolean validInput = false;
                String answerLowerCase = answer.toLowerCase();
                for (TicTacToeSquare s : allSquares) {
                    if (answerLowerCase.equals(s.getPlace())) {
                        validInput = true;
                        if (s.getValue().equals(" ")) {
                            s.setValue(symbol);

                            System.out.println(" " + allSquares.get(0).getValue() + " | " + allSquares.get(1).getValue() + " | " + allSquares.get(2).getValue() + " ");
                            System.out.println("---+---+---");
                            System.out.println(" " + allSquares.get(3).getValue() + " | " + allSquares.get(4).getValue() + " | " + allSquares.get(5).getValue() + " ");
                            System.out.println("---+---+---");
                            System.out.println(" " + allSquares.get(6).getValue() + " | " + allSquares.get(7).getValue() + " | " + allSquares.get(8).getValue() + " \n");
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
         if (isBot == true) {  System.out.println("Now it's computers turn:");
            while (true) {

                String randomSquare = allSquares.get(randomSquareIndex).getPlace();
                for (TicTacToeSquare s : allSquares) {
                    if (randomSquare.equals(s.getPlace())) {
                        if (s.getValue().equals(" ")) {
                            s.setValue(symbol);
                            System.out.println(" " + allSquares.get(0).getValue() + " | " + allSquares.get(1).getValue() + " | " + allSquares.get(2).getValue() + " ");
                            System.out.println("---+---+---");
                            System.out.println(" " + allSquares.get(3).getValue() + " | " + allSquares.get(4).getValue() + " | " + allSquares.get(5).getValue() + " ");
                            System.out.println("---+---+---");
                            System.out.println(" " + allSquares.get(6).getValue() + " | " + allSquares.get(7).getValue() + " | " + allSquares.get(8).getValue() + " \n");
                            return; // Avsluta både loopen och metoden när en giltig och ledig plats är vald (Aizo)
                        } else if (!randomSquare.equals("")) {
                            randomSquareIndex = (int) (Math.random() * allSquares.size());
                        }
                    }
                }
            }
        }

    }

    public boolean getIsTurn() {
        return isTurn;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}