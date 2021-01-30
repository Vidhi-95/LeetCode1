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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.*;
import java.io.*;

/**
 *
 * @author vidhi
 */
 
 // - List<Integer>
public class LeetCode {
      static int min;

public static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
         if (maxCacheSize == 0) return pages.size();
        LinkedHashSet<Integer> cache = new LinkedHashSet<>();
        int count = 0;
        for (int page : pages) {
            if (cache.contains(page)) {
//                Move the element to the end.
                cache.remove(page);
                cache.add(page);
            } else {
                if (cache.size() == maxCacheSize) {
//                    If cache is full, then get the first element and remove from cache
                    int first = cache.stream().findFirst().get();
                    cache.remove(first);
                }
                cache.add(page);
                count++;
            }
        }
        return count;
    
}
    
    public static void main(String[] args) {
       System.out.println(lruCacheMisses(6, Arrays.asList(1, 2, 1, 3, 1, 2), 2));
//        System.out.println(lruCacheMisses(10, Arrays.asList("1", "2", "1", "3", "1", "2", "5", "7", "1", "5", "7", "1"), 4));
       // System.out.println(lruCacheMisses(10, Arrays.asList("1", "2", "1", "3", "1", "2", "5", "3", "1", "5", "3", "1"), 6));
    }   
}
