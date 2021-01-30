/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practice_lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 *
 * @author vidhi
 */
 // Transaction Logs - method signature is different
 // Link to question - https://aonecode.com/amazon-online-assessment-transaction-logs
public class HelloWorld {

       private static List<String> getUsers(int k, String[] transactions){
        
        Map<String,Integer> map = new HashMap<>();
        for(String s: transactions){
            String[] split = s.split(" ");
            if(split[0]==split[1]){
                map.put(split[0],map.getOrDefault(split[0],0)+1);
            }
            else{
               map.put(split[0],map.getOrDefault(split[0],0)+1);
               map.put(split[1],map.getOrDefault(split[1],0)+1);
            }
        }
        List<String> ans = new ArrayList();
        for(String user: map.keySet()){
            if(map.get(user)>=k){
                ans.add(user);
            }
        }
        ans.sort((a,b)->{
            return a.compareTo(b);
        });
        return ans;
    }

    
     public static void main(String []args){
        String[] arr = {"88 99 200", "88 99 300", "99 32 100", "12 22 15"};
//        int[][] arra = { { 1, 2 }, { 3, 4 } };
        //String[] cmnds = {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
//        System.out.println("Hello World");
       HelloWorld hw = new HelloWorld();
       System.out.println(hw.getUsers(2,arr));
     }  
}
