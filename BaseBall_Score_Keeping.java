
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
  
    public static int finalScore(String[] ops) {
    LinkedList<Integer> list = new LinkedList<>();
    for(String cur:ops){
        if(cur.equals("+")){
            int size = list.size();
            list.add(list.get(size-1)+list.get(size-2));
        }
        else if(cur.equals("X")){
            list.add(2 * (list.get(list.size()-1)));
        }
        else if(cur.equals("Z")){
            list.removeLast();
        }
        else{
            list.add(Integer.parseInt(cur));
        }
    }
    int sum = 0;
    for(int num:list)
        sum+= num;
    
    return sum;
    }
    
    public static void main(String[] args) {
//        System.out.println(finalScore(new String[]{"5", "2", "X", "Z", "+"}) + " = 14");
//        System.out.println(finalScore(new String[]{"10", "20", "X", "+"}) + " = 130");
        System.out.println(finalScore(new String[]{"10", "20", "Z", "30", "+"}));
    }
}