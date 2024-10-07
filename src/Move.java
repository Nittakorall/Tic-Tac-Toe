import java.util.ArrayList;
import java.util.Scanner;

public interface Move {
void move(Scanner sc, ArrayList<TicTacToeSquare> allSquares, int randomSquareIndex);
}
