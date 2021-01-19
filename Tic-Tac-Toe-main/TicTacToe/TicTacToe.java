 
import java.util.ArrayList;

import java.io.*;

public abstract class TicTacToe {

  public static boolean gameOver(ArrayList<ArrayList<String>> board) {
    for (ArrayList<String> row : board) {
      for (String square : row) {
        if (square.isEmpty()) {
          return false;
        }
      }
    }
    return true;
  }
}