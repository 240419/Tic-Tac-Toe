package TicTacToe;

import java.util.ArrayList;

public class Player {
  private static ArrayList<Player> players = new ArrayList<Player>();
  // id is the player's tag when playing e.g. X or Os
  private String id;

  public Player(String id) {
    players.add(this);
    this.id = id;
  }

  public boolean wonGame(ArrayList<ArrayList<String>> board) {
    ArrayList<Integer> coordinates = this.aboutToWin(board, 0);
    return (coordinates != null && coordinates.get(0) == null && coordinates.get(1) == null)? true : false;
  }

  protected ArrayList<Integer> aboutToWin(ArrayList<ArrayList<String>> board, int num) {
    boolean wonAlready = true;
    int size = board.size();
    int emptySquares = 0;
    ArrayList<Integer> temp = new ArrayList<Integer>(2);
    temp.add(null); temp.add(null);
    for (int x = 0; x < size; x++){ // horizontal
      for (int y = 0; y < size; y++){
        if (!id.equals(board.get(x).get(y))) {
          wonAlready = false;
          if (board.get(x).get(y).isEmpty()) {
            emptySquares++;
            temp.set(0, x);
            temp.set(1, y);
          } else {
            emptySquares = 0;
            temp.set(0, null);
            temp.set(1, null);
            break;
          }
        } 
      }
      if (emptySquares == num && ((temp.get(0) != null && temp.get(1) != null) && !wonAlready)) {
        return temp;
      } else if (wonAlready) {
        temp.set(0, null);
        temp.set(1, null);
        return temp;
      }

      emptySquares = 0;
      wonAlready = true;
      for (int y = 0; y < size; y++) {
        if (!id.equals(board.get(y).get(x))) {
          wonAlready = false;
          if (board.get(y).get(x).isEmpty()) {
            emptySquares++;
            temp.set(0, y);
            temp.set(1, x);
          } else {
            emptySquares = 0;
            temp.set(0, null);
            temp.set(1, null);
            break;
          }
        }
      }
      if (emptySquares == num && ((temp.get(0) != null && temp.get(1) != null) && !wonAlready)) {
        return temp;
      } else if (wonAlready) {
        temp.set(0, null);
        temp.set(1, null);
        return temp;
      }
    }
    for (int x = 0; x < 2; x++){ // diagonal
      emptySquares = 0;
      wonAlready = true;
      if (x == 0){
        for (int y = 0; y < size; y++){
          if (!id.equals(board.get(y).get(y))) {
            wonAlready = false;
            if (board.get(y).get(y).isEmpty()) {
              emptySquares++;
              temp.set(0, y);
              temp.set(1, y);
            } else {
              emptySquares = 0;
              temp.set(0, null);
              temp.set(1, null);
              break;
            }
          }
        }
        if (emptySquares == num && ((temp.get(0) != null && temp.get(1) != null) && !wonAlready)) {
          return temp;
        } else if (wonAlready) {
          temp.set(0, null);
          temp.set(1, null);
          return temp;
        }
      } else {
        for (int y = 0; y < size; y++){
          if (!id.equals(board.get(size-1-y).get(y))) {
            wonAlready = false;
            if (board.get(size-1-y).get(y).isEmpty()) {
              emptySquares++;
              temp.set(0, size-1-y);
              temp.set(1, y);
            } else {
              emptySquares = 0;
              temp.set(0, null);
              temp.set(1, null);
              break;
            }
          }
        }
        if (emptySquares == num && ((temp.get(0) != null && temp.get(1) != null) && !wonAlready)) {
          return temp;
        } else if (wonAlready) {
          temp.set(0, null);
          temp.set(1, null);
          return temp;
        }
      }
    }

    if (num == 0) {
      temp.set(0, -1);
      temp.set(1, -1);
      return temp;
    } else {
      return null;
    }
  }

  public static int findPlayerIndexByID(String id) {
    for (Player player : players) {
        if (player.getId().equals(id)) {
            return players.indexOf(player);
        }
    }
    return -1;
  }

  public static boolean isValidChar(String tempId) {
    if (Player.findPlayerIndexByID(tempId) != -1 || tempId.isBlank() || tempId.length() == 1) {
      if (Character.isLetter(tempId.toCharArray()[0])) {
        return true;
      }
    }
    return false;
  }

  public String getId() {
    return this.id;
  }

  public static ArrayList<Player> getPlayers() {
    return Player.players;
  }
}
