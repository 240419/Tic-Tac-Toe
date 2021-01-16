package TicTacToe;

import java.util.*;

public class Computer extends Player {

  public Computer() {
    // random char goes here
    super("COMPUTER");
  }

  // computer logic & method here

  
  public ArrayList<Integer> compChoice(String compId, ArrayList<ArrayList<String>> board) {
    boolean checkIfConst = true;
    ArrayList<String> playersWComps = new ArrayList<String>();
    int size = board.size();
    int sizeP = playersWComps.size();
    
    
    for (Player player : Player.getPlayers()) {
      playersWComps.add(player.getId());
    }

    int tempIND;
    int blanks = 0;
    ArrayList<ArrayList<Integer>> tBlanks = new ArrayList<ArrayList<Integer>>(); // temporary blanks for win conditions
    ArrayList<ArrayList<Integer>> pBlanks = new ArrayList<ArrayList<Integer>>(); // permanent blanks for position choosing, kinda redundant but its nice so keep it
    ArrayList<Integer> temp = new ArrayList<Integer>();
    ArrayList<Integer> playerCountsOriginalForResize = new ArrayList<Integer>(sizeP);
    ArrayList<Integer> playerCounts = new ArrayList<Integer>(sizeP);

    for (int x = 0; x < sizeP; x++) {
      if (compId.equals(playersWComps.get(x))){
        int wIM = x; 
      }
    }
    
    for (int x = 0; x < size; x++) { // horizontal
      blanks = 0;
      temp.clear();
      playerCounts = playerCountsOriginalForResize;
      for (int y = 0; y < size; y++){
        String val = board.get(x).get(y);
        if (val.isEmpty()){
          temp.add(x);
          temp.add(y);
          tBlanks.add(temp);
          temp.clear();
        } else {
          playerCounts.set(playersWComps.indexOf(val), playerCounts.get(playersWComps.indexOf(val)) + 1);
        }
      }
      if ((playerCounts.get(playersWComps.indexOf(compId)) == (size - 1)) && (tBlanks.size() == 0)){
        return tBlanks.get(0);
      }
      for (int counts : playerCounts){
        if (counts == (size-1)) {
          return tBlanks.get(0);
        }
      }
    }

    for (int x = 0; x < size; x++){ // vertical 
      blanks = 0;
      temp.clear();
      playerCounts = playerCountsOriginalForResize;
      for (int y = 0; y < size; y++){
        String val = board.get(y).get(x);
        if (val.isEmpty()){
          temp.add(y);
          temp.add(x);
          tBlanks.add(temp);
          temp.clear();
        } else {
          playerCounts.set(playersWComps.indexOf(val), playerCounts.get(playersWComps.indexOf(val)) + 1);
        }
      }
      if ((playerCounts.get(playersWComps.indexOf(compId)) == (size - 1)) && (tBlanks.size() == 0)){
        return tBlanks.get(0);
      }
      for (int counts : playerCounts){
        if (counts == (size-1)) {
          return tBlanks.get(0);
        }
      }
    }

    //Diagonal 1
    blanks = 0;
    temp.clear();
    playerCounts = playerCountsOriginalForResize;
    for (int x = 0; x < size; x++){
      String val = board.get(x).get(x);
      if (val.isEmpty()){
        temp.add(x);
        temp.add(x);
        tBlanks.add(temp);
        temp.clear();
      } else {
        playerCounts.set(playersWComps.indexOf(val), playerCounts.get(playersWComps.indexOf(val)) + 1);
      }
      if ((playerCounts.get(playersWComps.indexOf(compId)) == (size - 1)) && (tBlanks.size() == 0)){
        return tBlanks.get(0);
      }
      for (int counts : playerCounts){
        if (counts == (size-1)) {
          return tBlanks.get(0);
        }
      }
    }

    //Diagonal 1
    blanks = 0;
    temp.clear();
    playerCounts = playerCountsOriginalForResize;
    for (int x = 0; x < size; x++){
      String val = board.get(size-1-x).get(x);
      if (val.isEmpty()){
        temp.add(size-1-x);
        temp.add(x);
        tBlanks.add(temp);
        temp.clear();
      } else {
        playerCounts.set(playersWComps.indexOf(val), playerCounts.get(playersWComps.indexOf(val)) + 1);
      }
      if ((playerCounts.get(playersWComps.indexOf(compId)) == (size - 1)) && (tBlanks.size() == 0)){
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
}
