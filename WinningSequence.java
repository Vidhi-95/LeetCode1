/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leetcodeoa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vidhi
 */
public class LeetCode {
    public static List<Integer> winningSequence(int num, int lower, int upper){
        // lower = 5, upper = 10, lower = 3 --> [9,10,9,8,7]
        List<Integer> list = new ArrayList<>();
        int delta = upper - lower;
        if(num>2*delta + 1) return null; // we cannot form a sequence if there are not enough nums between lower and upper
        
        int start_num = upper - 1;
        // move to the left until we can form a sequence
        while((((upper-start_num)+1)+delta)<num){
            start_num --;
        }
        int[] res = new int[num];
        int i = 0;
        // this will fill the elements in the increasing order
        while(start_num<upper){
            res[i++]=start_num++;
        }
        // we need to place the upper number
        res[i++] = start_num--;
        
        // this will fill the elements in the decreasing order
        while (i < num) {
        res[i++] = start_num--;
}   
        for(int number:res){
            list.add(number);
        }
        return list;
    }
    
    public static void main(String []args){
//        String[] arr = {"88 99 200", "88 99 300", "99 32 100", "12 22 15"};
//       LeetCode lc = new LeetCode();
//       System.out.println(lc.winningSequence(2,arr));
       System.out.println(winningSequence(5, 1, 3));
     }  
}
