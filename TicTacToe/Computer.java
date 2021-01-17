package TicTacToe;

import java.util.*;

public class Computer extends Player {

  public Computer() {
    // random char goes here
    super("COMPUTER");
  }

  // computer logic & method here

  
  public ArrayList<Integer> compChoice(ArrayList<ArrayList<String>> board) {
    ArrayList<String> playersWComps = new ArrayList<String>();
    int size = board.size();
    int blanks = 0;

    ArrayList<ArrayList<Integer>> tBlanks = new ArrayList<ArrayList<Integer>>(); // temporary blanks for win conditions
    ArrayList<ArrayList<Integer>> pBlanks = new ArrayList<ArrayList<Integer>>(); // permanent blanks for position choosing, kinda redundant but its nice so keep it
    ArrayList<Integer> temp = new ArrayList<Integer>();
    ArrayList<Integer> playerCountsOriginalForResize = new ArrayList<Integer>();

    for (Player player : Player.getPlayers()) {
      playersWComps.add(player.getId());
    }
    int sizeP = playersWComps.size();
    for (int x = 0; x < sizeP; x++){
      playerCountsOriginalForResize.add(1);
    }

    ArrayList<Integer> playerCounts = new ArrayList<Integer>();
    playerCounts = playerCountsOriginalForResize;


    for (int x = 0; x < sizeP; x++) {
      if (this.getId().equals(playersWComps.get(x))){
        int wIM = x; 
      }
    }
    int i = 0;
    for (int x = 0; x < size; x++) { // horizontal
      blanks = 0;
      temp.clear();
      playerCounts = playerCountsOriginalForResize;

      for (int y = 0; y < size; y++){
        int a, b;
        switch (i++) {
          case 0:
          // horizontal - x, y
          a = x; b = y;
          break;

          case 1:
          // vertical - y, x 
          a = y; b = x;
          break;

          case 2:
          // Diagonal 1 - x, x
          a = x; b = x;
          break;
          
          default:
          // Diagonal 2 - size-1-x, x
          a = size-1-x; b = x;
          break;
        } 
        String val = board.get(a).get(b);
        if (val.isEmpty()) {
          temp.add(a);
          temp.add(b);
          tBlanks.add(temp);
          temp.clear();
        } else {
          int index = playersWComps.indexOf(val);
          int contents = playerCounts.get(playersWComps.indexOf(val)) + 1;
          playerCounts.set(index, contents);
        }
      }
      if ((playerCounts.get(playersWComps.indexOf(this.getId())) == (size - 1)) && (tBlanks.size() == 0)){
        return tBlanks.get(0);
      }

      for (int counts : playerCounts){
        if (counts == (size-1)) {
          return tBlanks.get(0);
        }
      }
    }

    temp.clear();
    for (int x = 0; x < size; x++){
      for (int y = 0; y < size; y++) {
        String val = board.get(x).get(y);
        if (val.isEmpty()){
          temp.add(size-1-x);
          temp.add(x);
          pBlanks.add(temp);
          temp.clear();
        }
      }
    }

    double randomChoice = Math.random();
    for (int x = 0; x < size; x++){
      if ((randomChoice < ((x+1)/size)) && (randomChoice > (x/size))){
        return pBlanks.get(x);
      }
    }
    return pBlanks.get(0);
  }
}d