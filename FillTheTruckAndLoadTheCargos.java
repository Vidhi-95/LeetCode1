import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int loadTheCargo(int num, int[] containers, int itemSize, int[] itemsPerContainer, long cargoSize) {
        
      PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c2[1], c1[1]));
//        0: counts, 1: items
        for (int i = 0; i < num; i++) {
            pq.add(new int[]{containers[i], itemsPerContainer[i]});
        }
        long totalItems = 0, totalCargos = 0;
        while (totalCargos < cargoSize && !pq.isEmpty()) {
            int[] poll = pq.poll();
            if (totalCargos + poll[0] <= cargoSize) {
//                Then take all the items
                totalItems += poll[0] * poll[1];
                totalCargos += poll[0];
            } else {
                long canLoad = cargoSize - totalCargos;
                totalItems += canLoad * poll[1];
                totalCargos += canLoad;
            }
        }
        return (int) totalItems;
    }
}