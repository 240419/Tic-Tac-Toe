import java.util.ArrayList;

import java.io.*;

public class tictactoeexperimental {
  
  public static void computerThought(ArrayList<Integer> board){
    ArrayList<ArrayList<Integer>> boardv = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> single = new ArrayList<Integer>();
    
    if ()
    
    
    
    
    
    
    
    
    
    
    /*for (int x = 0; x < 9; x++){
      int y = x%3;
      int z = 0;
      if (x < 4){
        single = boardv.get(0);
        single.set(y, board.get(x));
        boardv.set(0, single);
      } else if (x < 7){
        single = boardv.get(1);
        single.set(y, board.get(x));
        boardv.set(1, single);
      } else if (x < 10){
        single = boardv.get(2);
        single.set(y, board.get(x));
        boardv.set(2, single);
      }
    } */
  }

  public static ArrayList<Integer> canWinOpt(int canwin, ArrayList<Integer> board){
    ArrayList<Integer> temp = new ArrayList<Integer>();
    ArrayList<Integer> results = new ArrayList<Integer>();
    int total = 0;
    int iter = 0;
    int RDV = 0;

    //diagonal
    temp.add(0);
    temp.add(4);
    temp.add(8);
    if((board.get(0) + board.get(4) + board.get(8)) == canwin){
      return temp;
    } else {
      temp.clear();
    }
    temp.add(2);
    temp.add(4);
    temp.add(6);
    if((board.get(2) + board.get(4) + board.get(6)) == canwin){
      return temp;
    } else {
      temp.clear();
    }
    temp.clear(); // i like over-clearing just to make sure its clean
    //horizontal
    for(int x = 0; x < 3; x++){
      temp.add(x*3);
      temp.add(x*3+1);
      temp.add(x*3+2);
      if((board.get(3*x) + board.get(3*x+1) + board.get(3*x+2)) == canwin){
        return temp;
      } else {
        temp.clear();
      }
      temp.clear();
    }

    for(int x = 0; x < 3; x++){
      temp.add(x);
      temp.add(x+3);
      temp.add(x+6);
      if((board.get(x) + board.get(x+3) + board.get(x+6)) == canwin){
        return temp;
      } else {
        temp.clear();
      }
      temp.clear();
    }
    temp.clear();
    temp.add(2);
    return temp;
  }
}
