// "static void main" must be defined in a public class.
// input is a list of records and o/p is a list of records
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
    
   
    static List<String> minimumDebtMembers(List<debtRecord> records){
      if(records.isEmpty()) return Arrays.asList("None");
      
      Map<String,Integer> map = new HashMap<>();
      for(debtRecord record: records){
          int borrower = map.getOrDefault(record.borrower, 0);
          int lender = map.getOrDefault(record.lender,0);
          
          borrower -= record.amount;
          lender += record.amount;
          
          map.put(record.borrower, borrower);
          map.put(record.lender, lender);
      }
          int min = map.values().stream().mapToInt(i -> i).min().getAsInt();
          if (min >= 0) return Arrays.asList("Nobody has a negative balance");
          
          List<String> result = new ArrayList<>();
          for(Map.Entry<String, Integer> entry: map.entrySet()){
              if(entry.getValue() == min){
                  result.add(entry.getKey());
              }
          }
          Collections.sort(result);
      return result;
    }
    
    static class debtRecord {
        String borrower = ""; // importer
        String lender = ""; //exporter
        int amount = 0;

        public debtRecord(String borrower, String lender, int amount) {
            this.borrower = borrower;
            this.lender = lender;
            this.amount = amount;
        }
    }

   
    
    public static void main(String[] args) {
        System.out.println(minimumDebtMembers(Arrays.asList(
                new debtRecord("Alex", "Blake", 2),
                new debtRecord("Alex", "Blake", 4),
                new debtRecord("Alex", "Casey", 4),
                new debtRecord("Blake", "Alex", 2),
                new debtRecord("Blake", "Casey", 7),
                new debtRecord("Casey", "Alex", 5)
        )));
    
    }
}