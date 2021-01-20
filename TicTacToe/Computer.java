package TicTacToe;
 
import java.util.*;

public class Computer extends Player {
  private static int numOfComputers = 0;
  public Computer() {
    super("CPU" + ++numOfComputers);
  }
  // computer logic & method here
  
  public ArrayList<Integer> compChoice(ArrayList<ArrayList<String>> board) {
      // winning move available
    if (this.aboutToWin(board, 1) != null) {
      System.out.println("WINNING MOVE");
      System.out.println(this.aboutToWin(board, 1).get(0) + " " + this.aboutToWin(board, 1).get(1));
      return this.aboutToWin(board, 1);

      // threat winning pay
    } else if (playerCanWin(board) != null) {
      System.out.println("THREAT");
      return playerCanWin(board);

      // center square 
    } else if (board.size() % 2 == 1 && board.get(board.size()/2).get(board.size()/2).isEmpty()) {
      System.out.println("CENTER SQUARE");
      return new ArrayList<Integer>(Arrays.asList(board.size()/2, board.size()/2));
      
      // random
    } else {
      System.out.println("RANDOM SQUARE");
      Random rand = new Random();
      String text = "temp";
      int r1 = 0, r2 = 0;
      while (!text.isEmpty()) {
        r1 = rand.nextInt(board.size());
        r2 = rand.nextInt(board.size());
        text = board.get(r1).get(r2);
      }
      return new ArrayList<Integer>(Arrays.asList(r1, r2));
    }
  }

  private ArrayList<Integer> playerCanWin(ArrayList<ArrayList<String>> board) {
    for (Player player : Player.getPlayers()) {
      if (player != this && player.aboutToWin(board, 1) != null) {
        return player.aboutToWin(board, 1);
      }
    }
    return null;
  }

  public static void setNumOfComputers(int numOfComputers) {
    Computer.numOfComputers = numOfComputers;
  }
}