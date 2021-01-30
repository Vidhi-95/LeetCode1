/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practice_lc;

/**
 *
 * @author vidhi
 */
public class HelloWorld {

      public int cutOffRank(int cutOffRank, int num, int[] scores) {
          int[] freq = new int[100001];
          int max= Integer.MIN_VALUE;
          // Finding the max logic
          for(int score: scores){
              freq[score]++; // counting freq of each score
              if(max<score) max = score;
          }
          //since i = max, we start from the highest number and count those first
          int i = max, res = 0, rank = 1;
          while(i>=0 && rank<=cutOffRank){
              if(freq[i]!=0){
                 res+= freq[i];
                 rank+= freq[i];
              }
              i--;
          }
          return res;
    }

    
     public static void main(String []args){
        int[] arr = {25,25,100,100,100,50,50,25};
//        int[][] arra = { { 1, 2 }, { 3, 4 } };
        //String[] cmnds = {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
//        System.out.println("Hello World");
       HelloWorld hw = new HelloWorld();
       System.out.println(hw.cutOffRank(3,7,arr));
     }  
}
