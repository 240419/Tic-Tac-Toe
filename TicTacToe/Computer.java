package TicTacToe;

public class Computer extends Player {

  public Computer() {
    // random char goes here
    super("");
  }
 
  // computer logic & method here
  
  public static ArrayList<ArrayList<Integer>> compChoice(String thisComp, ArrayList<String> playersWComps, ArrayList<ArrayList<String>> board) {
    boolean checkIfConst = true;
    int size = board.size();
    int sizeP = playersWComps();
    int tempIND;
    int blanks = 0;
    ArrayList<ArrayList<Integer>> tBlanks = new ArrayList<ArrayList<Integer>>(); // temporary blanks for win conditions
    ArrayList<Integer> temp = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> pBlanks = new ArrayList<ArrayList<Integer>>(); // permanent blanks for position choosing
    ArrayList<Integer> playerCountsOriginalForResize = new ArrayList<Integer>(sizeP);
    ArrayList<Integer> playerCounts = new ArrayList<Integer>(sizeP);
    for (int x = 0; x < sizeP; x++){
      if (thisComp.equals(playersWComps.get(x)){
        int wIM = x; 
      }
    }
          
    
    for (int x = 0; x < size; x++){ // horizontal
      blanks = 0;
      temp.clear();
      playerCounts.clear();
      playerCounts = playerCountsOriginalForResize;
      for (int y = 0; y < size; y++){
        String val = board.get(x).get(y);
        if (val.isEmpty){
          temp.add(x);
          temp.add(y);
          tBlanks.add(temp);
          pBlanks.add(temp);
          temp.clear();
        } else {
          playerCounts.set(playersWComps.indexOf(val), playerCounts.get(val) + 1);
        }
      }
    }
    
  }
  
}
