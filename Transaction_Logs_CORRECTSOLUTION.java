import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Solution {
    public String[] processLogFile(String[] logs, int threshold) {
        
    Map<String,Integer> map = new HashMap<>();
        for(String log : logs)
    {
        String[] arr = log.split(" ");
        Integer val1 = map.getOrDefault(arr[0],0);
        Integer val2 = map.getOrDefault(arr[1],0);

        if(arr[0] == arr[1] && !map.containsKey(arr[0])) {
            map.put(arr[0], 1);
        }
        else if(!map.containsKey(arr[0]) && !map.containsKey(arr[1])) {
            map.put(arr[0], 1);
            map.put(arr[1], 1);
        }
        else if(!map.containsKey(arr[1])) {
            map.put(arr[1], 1);
            map.put(arr[0], val1 + 1);
        }
        else if(!map.containsKey(arr[0])) {
            map.put(arr[0], 1);
            map.put(arr[1], val2 + 1);
        }
        else
            map.put(arr[0], val1 + 1);
            map.put(arr[1], val2 + 1);

    }

    Map<String, Integer> result = map.entrySet().stream().filter(m -> m.getValue() >= threshold )
                                 .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));
    String[] arr =  result.keySet().toArray(new String[0]);
    Arrays.sort(arr);
    return arr;
    }
}