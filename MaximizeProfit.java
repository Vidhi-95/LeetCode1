
package com.mycompany.leetcodeoa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class LeetCode {
  
    private static int maxProfit(int n, int[] arr, int k) {
    int[] counts = new int[100001];
    int max = 0;
    // finding the max value
    for(int num:arr){
        counts[num]++;
        max=Math.max(num, max);
    }
    int item = 0, profit = 0;
    for(int i = max; i>=0 && item <k; i--){
        int curCount = counts[i];
        if(curCount == 0) continue;
        int taken = Math.min(k-item, curCount);
        profit+= i * taken;
        item+= taken;
        counts[i]-= taken;
        if(i>0) counts[i-1]+= taken;
    }
    return profit;
    }
    
    public static void main(String[] args) {
        System.out.println(maxProfit(5, new int[]{3, 5, 7, 10, 6}, 20) + " = 107");
    }
}