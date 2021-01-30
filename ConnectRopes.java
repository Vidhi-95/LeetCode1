import java.util.*;

public class Solution {
   

public static int connectRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : ropes) pq.add(rope);
        int cost = 0;
        while (pq.size() >= 2) {
            int a = pq.poll(), b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }
        return cost;
    }
}