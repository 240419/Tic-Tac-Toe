
 
import java.util.*;
public class Computer extends Player {
  public Computer() {
    // random char goes here
    super("COMPUTER");
  }
  // computer logic & method here
  
  public ArrayList<Integer> compChoice(ArrayList<ArrayList<String>> board) {
    boolean checkIfConst = true;
    String compId = this.getId();
    ArrayList<String> playersWComps = new ArrayList<String>();
    int size = board.size();
    for (Player player : Player.getPlayers()) {
      playersWComps.add(player.getId());
    }
    int sizeP = playersWComps.size();
    int tempIND;
    int blanks = 0;
    ArrayList<ArrayList<Integer>> tBlanks = new ArrayList<ArrayList<Integer>>(); // temporary blanks for win conditions
    ArrayList<ArrayList<Integer>> pBlanks = new ArrayList<ArrayList<Integer>>(); // permanent blanks for position choosing, kinda redundant but its nice so keep it
    ArrayList<Integer> temp = new ArrayList<Integer>();
    ArrayList<Integer> playerCountsOriginalForResize = new ArrayList<Integer>(sizeP);
    ArrayList<Integer> playerCounts = new ArrayList<Integer>(sizeP);

    for (int x = 0; x < sizeP; x++){
      playerCountsOriginalForResize.add(0);
    }
    
    for (int x = 0; x < size; x++) { // horizontal
      blanks = 0;
      temp.clear();
      playerCounts = playerCountsOriginalForResize;
      for (int y = 0; y < size; y++){
        String val = board.get(x).get(y);
        if (val.isEmpty()){
          temp.clear();
          temp.add(x);
          temp.add(y);
          tBlanks.add(temp);
          pBlanks.add(temp);
        } else {
          int index = playersWComps.indexOf(val);
          int contents = playerCounts.get(playersWComps.indexOf(val)) + 1;
          playerCounts.set(index, contents);
        }
      }
      if (playerCounts.get(playersWComps.indexOf(compId)) == (size-1) && tBlanks.size()>0){
        return tBlanks.get(0);
      }
      for (int m = 0; m < playerCounts.size(); m++){
        if (playerCounts.get(m) == (size-1) && tBlanks.size()>0) {
          System.out.println(tBlanks);
          return tBlanks.get(0);
        }
      }
      tBlanks.clear();
    }
    for (int x = 0; x < size; x++){ // vertical 
      blanks = 0;
      temp.clear();
      playerCounts = playerCountsOriginalForResize;
      for (int y = 0; y < size; y++){
        String val = board.get(y).get(x);
        if (val.isEmpty()){
          temp.clear();
          temp.add(y);
          temp.add(x);
          tBlanks.add(temp);
        } else {
          int index = playersWComps.indexOf(val);
          int contents = playerCounts.get(playersWComps.indexOf(val)) + 1;
          playerCounts.set(index, contents);
        }
      }
      if (playerCounts.get(playersWComps.indexOf(compId)) == (size-1) && tBlanks.size()>0){
        return tBlanks.get(0);
      }
      for (int m = 0; m < playerCounts.size(); m++){
        if (playerCounts.get(m) == (size-1) && tBlanks.size()>0) {
          return tBlanks.get(0);
        }
      }
      tBlanks.clear();
    }
    //Diagonal 1
    blanks = 0;
    temp.clear();
    playerCounts = playerCountsOriginalForResize;
    for (int x = 0; x < size; x++){
      String val = board.get(x).get(x);
      if (val.isEmpty()){
        temp.clear();
        temp.add(x);
        temp.add(x);
        tBlanks.add(temp);
      } else {
        int index = playersWComps.indexOf(val);
        int contents = playerCounts.get(playersWComps.indexOf(val)) + 1;
        playerCounts.set(index, contents);
      }
      if (playerCounts.get(playersWComps.indexOf(compId)) == (size-1)  && tBlanks.size()>0){
        return tBlanks.get(0);
      }
      for (int m = 0; m < playerCounts.size(); m++){
        if (playerCounts.get(m) == (size-1) && tBlanks.size()>0 ) {
          return tBlanks.get(0);
        }
      }
      tBlanks.clear();
    }
    //Diagonal 1
    blanks = 0;
    temp.clear();
    playerCounts = playerCountsOriginalForResize;
    for (int x = 0; x < size; x++){
      String val = board.get(size-1-x).get(x);
      if (val.isEmpty()){
        temp.clear();
        temp.add(size-1-x);
        temp.add(x);
        tBlanks.add(temp);
        System.out.println(tBlanks);
      } else {
        int index = playersWComps.indexOf(val);
        int contents = playerCounts.get(playersWComps.indexOf(val)) + 1;
        playerCounts.set(index, contents);
      }
      if ((playerCounts.get(playersWComps.indexOf(compId)) == (size-1)) && tBlanks.size()>0){
        return tBlanks.get(0);
      }
      for (int m = 0; m < playerCounts.size(); m++){
        if (playerCounts.get(m) == (size-1)  && tBlanks.size()>0 ) {
          return tBlanks.get(0);
        }
      }
      tBlanks.clear();
    }
    temp.clear();
    double randomChoice = Math.random();
    for (int x = 0; x < size; x++){
      if ((randomChoice < ((x+1)/size)) && (randomChoice > (x/size))){
        return pBlanks.get(x);
      }
    }
    return pBlanks.get(0);
  }
}
