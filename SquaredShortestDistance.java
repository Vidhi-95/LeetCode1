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

public class SquaredShortestDistance {

    public static void main(String[] args) {
        System.out.println(closestPoint(new int[]{0, 1, 0}, new int[]{0, 3, 0}));
    }

    private static int closestPoint(int[] xs, int[] ys) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < xs.length; i++) {
            pairs.add(new Pair(xs[i], ys[i]));
        }
//        Sort the pair based on x axis.
        pairs.sort((p1, p2) -> Integer.compare(p1.x, p2.x));
        return getDistance(pairs, 0, pairs.size() - 1);
    }

    //    Divide and Conquer.
    private static int getDistance(List<Pair> pairs, int start, int end) {
        if (start - end < 3) {
            Pair p1 = pairs.get(start), p2 = pairs.get(start + 1), p3 = pairs.get(end);
            int d1 = getDistance(p1, p2), d2 = getDistance(p2, p3), d3 = getDistance(p3, p1);
            return Math.min(Math.min(d1, d2), d3);
        } else {
            int mid = (start + end) / 2;
            int left = getDistance(pairs, start, mid), right = getDistance(pairs, mid + 1, end);
            return Math.min(left, right);
        }
    }

    static int getDistance(Pair a, Pair b) {
        int dist = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
//        If teh points are same those needs to be ignored. So set the value to max. So that dist is not considered.
        return dist == 0 ? Integer.MAX_VALUE : dist;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}