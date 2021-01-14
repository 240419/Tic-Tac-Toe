package TicTacToe;
import java.util.ArrayList;

import java.io.*;

public abstract class TicTacToe {
  public class Main {
    ArrayList<ArrayList<String>> testProd = new ArrayList<ArrayList<String>>();
    ArrayList<String> singl = new ArrayList<String>();
    ArrayList<String> doubl = new ArrayList<String>();
    ArrayList<String> tripl = new ArrayList<String>();
    singl.add("h");
    singl.add("h");
    singl.add("h");
    doubl.add("n");
    int size = 3;

    canWinOpt("h")

  }
  
  public static void computerThought(ArrayList<ArrayList<Integer>> board){
    ArrayList<Integer> single = new ArrayList<Integer>(); 
  //   if ()
  //   /*for (int x = 0; x < 9; x++){
  //     int y = x%3;
  //     int z = 0;
  //     if (x < 4){
  //       single = boardv.get(0);
  //       single.set(y, board.get(x));
  //       boardv.set(0, single);
  //     } else if (x < 7){
  //       single = boardv.get(1);
  //       single.set(y, board.get(x));
  //       boardv.set(1, single);
  //     } else if (x < 10){
  //       single = boardv.get(2);
  //       single.set(y, board.get(x));
  //       boardv.set(2, single);
  //     }
  //   } */
  }

  public static ArrayList<ArrayList<Integer>> canWinOpt(String target, ArrayList<ArrayList<String>> board, int size) {
    ArrayList<Integer> temp = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> finalz = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> results = new ArrayList<Integer>();
    int total = 0;
    int iter = 0;
    int RDV = 0;
    Boolean checkIfConst = true;

    for (int x = 0; x < size; x++){ // horizontal
      checkIfConst = true;
      for (int y = 0; y < size; y++){
        if (target.equals(board.get(x).get(y))) {
          total = 0; // just a passive statement
        } else {
          checkIfConst = false;
        }
        temp.add(x);
        temp.add(y);
        finalz.add(temp);
        temp.clear();
      }
      if (checkIfConst) {
        return finalz;
      } else {
        finalz.clear();
      }
      total = 0;
      temp.clear();
      finalz.clear();
    }
    for (int x = 0; x < size; x++){ // vertical
      checkIfConst = true;
      for (int y = 0; y < size; y++){
        if (target.equals(board.get(x).get(y)){
          total = 0; // just a passive statement
        } else {
          checkIfConst = false;
        }
        temp.add(x);
        temp.add(y);
        finalz.add(temp);
        temp.clear();
      }
      if (checkIfConst){
        return finalz;
      } else {
        finalz.clear();
      }
      total = 0;
      temp.clear();
      finalz.clear();
    }
    for (int x = 0; x < 2; x++){ //diagonal
      int tempINT_1 = x * size - 1;
      if (x == 0){
        checkIfConst = true;
        for (int y = 0; y < size; y++){
          if (target.equals(board.get(x).get(y)){
            total = 0; // just a passive statement
          } else {
            checkIfConst = false;
          }
          temp.add(y);
          temp.add(y);
          finalz.add(temp);
          temp.clear();
        }
        if (checkIfConst){
          return finalz;
        } else {
          finalz.clear();
        }
      } else {
        for (int y = size-1; y >= 0; y--){
          if (target.equals(board.get(x).get(y)){
            total = 0; // just a passive statement
          } else {
            checkIfConst = false;
          }
          temp.add(y);
          temp.add(y);
          finalz.add(temp);
          temp.clear();
        }
        if (checkIfConst){
          return finalz;
        } else {
          finalz.clear();
        }
      }
    }
    finalz.clear();
    temp.clear();
    temp.add(5);
    finalz.add(temp);
    return finalz;
  }
}
