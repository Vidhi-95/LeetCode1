package com.mycompany.leetcodeoa2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/interview-question/tagging-system
 */

public class LeetCode {
    
    private static String taggingSystem(String str, int limit){
        int[] count = new int[26];
        for(char c : str.toCharArray()) count[c-'a']++;
        //        0: char, 1: count
        PriorityQueue<int[]> pq = new PriorityQueue<>((c1,c2)-> c1[0] == c2[0] ? Integer.compare(c2[1],c2[1]):Integer.compare(c2[0],c1[0]));
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<26; i++){
          if(count[i]>0) pq.add(new int[]{i,count[i]}); 
        }
        if(pq.isEmpty()) return sb.toString();
        
        int[] arr = pq.poll();
        while(!pq.isEmpty()){
            int[] c = pq.poll();
            // Take the max of limit or count from the pre.
            if(arr[1]>limit){
                arr[1]-= limit;
                pq.add(arr);
                sb.append(getString(arr[0],limit));
            }
            else{
                 sb.append(getString(arr[0],arr[1]));
            }
            arr = c;
        }
        sb.append(getString(arr[0], Math.min(limit, arr[1])));
        return sb.toString();
    }

    private static String getString(int c, int count) {
        return ("" + (char) ('a' + c)).repeat(count);
    
    }
    
    public static void main(String[] args) {
          System.out.println(taggingSystem("cbdded", 3));
    }

}