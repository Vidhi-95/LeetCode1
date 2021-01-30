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
    public int scheduleTasks(int num,int[] power, int tasks){
        //
        int total_time = 0;
        int idx = 0;
        int max = Integer.MIN_VALUE;
        while(tasks>0){
        for(int i=0;i<power.length;i++){
            if(power[i]>max){
                max = power[i];
                idx = i;
            }
        tasks -= max;
        total_time += 1;
        power[idx] = (int)(Math.ceil(power[idx]/2.0));    
//            max = Math.max(max, power[i]);
        }
        }
        return total_time -1;
    }
    
    public static void main(String []args){
//        String[] arr = {"88 99 200", "88 99 300", "99 32 100", "12 22 15"};
        int[] arr1 = {3,1,7,2,4};
//        int[] arr2 = {2};
       LeetCode lc = new LeetCode();
//       System.out.println(lc.winningSequence(2,arr));
       System.out.println(lc.scheduleTasks(5, arr1,15));
     }  
}
