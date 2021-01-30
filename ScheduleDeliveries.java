/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leetcodeoa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author vidhi
 */
public class LeetCode {
      static int min;

    public static int earliestTime(int numOfBuildings, List<Integer> buildingOpenTime, List<Integer> offloadTime) {
        // sort in ascending
        Collections.sort(buildingOpenTime);
        // sort in descending
        offloadTime.sort(Collections.reverseOrder());
        
        int max = 0;
        int j = 0;
        // if we used 4 docks move on the the next dock
        int numOfOffloadTimes = offloadTime.size();
        for(int i = 0; i<numOfOffloadTimes;i++){
            if((i+1)%4==0)
                j++;
            else{
                int time = offloadTime.get(i) + buildingOpenTime.get(j);
                if(max<time) max = time;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(earliestTime(2, new int[]{7,9}, new int[]{7,6,3,4,1,1,2,0}));
        System.out.println(getMinScore(5, 6, new int[]{1, 1, 2, 2, 3, 4}, new int[]{2, 3, 3, 4, 4, 5}) + " = 2");
    }   
}
