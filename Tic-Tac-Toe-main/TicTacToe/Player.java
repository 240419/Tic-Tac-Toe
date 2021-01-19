 

import java.util.ArrayList;

public class Player {
    private static ArrayList<Player> players = new ArrayList<Player>();
    // id is the player's tag when playing e.g. X or Os
    private String id;

    public Player(String id) {
        players.add(this);
        this.id = id;
    }

    public boolean canWin(ArrayList<ArrayList<String>> board) {
        boolean checkIfConst = true;
        int size = board.size();
        for (int x = 0; x < size; x++){ // horizontal
          checkIfConst = true;
          for (int y = 0; y < size; y++){
            if (!id.equals(board.get(x).get(y))) {
              checkIfConst = false;
            }
          }
          if (checkIfConst) {
            return true;
          }
    
          checkIfConst = true;
          for (int y = 0; y < size; y++) {
            if (!id.equals(board.get(y).get(x))) {
              checkIfConst = false; 
            }
          }
          if (checkIfConst) {
            return true;
          }
        }
        for (int x = 0; x < 2; x++){ // diagonal
          checkIfConst = true;
          if (x == 0){
            for (int y = 0; y < size; y++){
              if (!id.equals(board.get(y).get(y))){
                checkIfConst = false; 
              }
            }
            if (checkIfConst){
              return true;
            }
          } else {
            for (int y = 0; y < size; y++){
              if (!id.equals(board.get(size-1-y).get(y))){
                checkIfConst = false; 
              }
            }
            if (checkIfConst){
              return true;
            }
          }
        }
        return false;
      }


    public String getId() {
        return this.id;
    }

    public static int findPlayerIndexByID(String id) {
        for (Player player : players) {
            if (player.getId().equals(id)) {
                return players.indexOf(player);
            }
        }
        return -1;
    }

    public static ArrayList<Player> getPlayers() {
        return Player.players;
    }
}
