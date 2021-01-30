package com.mycompany.leetcodeoa2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class LeetCode {
    
    private static String[] uniqueNames(int n, String[] devices){
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String device = devices[i];
            if(map.containsKey(devices[i])){
                // map.get will get the count
                devices[i]= devices[i] + map.get(devices[i]);
            }
            map.put(device, map.getOrDefault(device, 0)+1);
        }
        return devices;
    }

    public static void main(String[] args) {
        String[] ans = uniqueNames(6, new String[]{"switch", "tv", "switch", "tv","switch", "tv"});
        for (String a : ans){
            System.out.print(a + ", ");
        }

}
}