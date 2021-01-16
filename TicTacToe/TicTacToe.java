package TicTacToe;
import java.util.ArrayList;

import java.io.*;

public abstract class TicTacToe {
  public static boolean winOpt(String target, ArrayList<ArrayList<String>> board) {
    boolean checkIfConst = true;
    int size = board.size();
    for (int x = 0; x < size; x++){ // horizontal
      checkIfConst = true;
      for (int y = 0; y < size; y++){
        if (!target.equals(board.get(x).get(y))) {
          checkIfConst = false;
        }
      }
      if (checkIfConst) {
        return true;
      }

      checkIfConst = true;
      for (int y = 0; y < size; y++) {
        if (!target.equals(board.get(y).get(x))) {
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
          if (!target.equals(board.get(y).get(y))){
            checkIfConst = false; 
          }
        }
        if (checkIfConst){
          return true;
        }
      } else {
        for (int y = 0; y < size; y++){
          if (!target.equals(board.get(size-1-y).get(y))){
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

  public static boolean compChoice(String thisComp, ArrayList<String> playersWComps, ArrayList<ArrayList<String>> board) {
    boolean checkIfConst = true;
    int size = board.size();
    int sizeP = playersWComps();
    int tempIND;
    ArrayList<String> temp = new ArrayList<String>(sizeP);
    for (int x = 0; x < sizeP; x++){
      if (thisComp.equals(playersWComps.get(x)){
        int wIM = x; 
      }
    }
          
    
    for (int x = 0; x < size; x++){ // horizontal
      for (int y = 0; y < size; y++){
        String val = board.get(x).get(y);
        
      }
    }
    
  }
  
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
