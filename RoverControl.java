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

    // Rover Control - OA2 question
    // rover cannot move diagonally can move in 4 directions only
    //Question link: https://leetcode.com/discuss/interview-question/985703/Amazon-or-OA-or-Rover-Control
   
   public static int roverMove(String[] cmnds, int n){
	int row = 0;
        int col = 0;
        for(String cmnd: cmnds){
            if(cmnd == "RIGHT"){
                if(col<n-1) col = col+1;
            }
            if(cmnd == "LEFT"){
                if(col>0) col = col-1;
            }
            if(cmnd == "UP"){
                if(row>0) row = row-1;
            }
            if(cmnd == "DOWN"){
                if(row<n-1) row = row+1;
            }
        }
                
     return (n*row)+col;           
}

    
     public static void main(String []args){
       
        String[] cmnds = {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
//        System.out.println("Hello World");
       HelloWorld hw = new HelloWorld();
       System.out.println(hw.roverMove(cmnds,4));
     }  
}
