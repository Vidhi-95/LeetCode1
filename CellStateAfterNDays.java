import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-oa2-cell-state-after-n-days
 */

public class CellStateAfterNDays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(newState(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1)) + " = [0, 1, 0, 0, 1, 0, 1, 0]");
        System.out.println(Arrays.toString(newState(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2)) + " = [0, 0, 0, 0, 0, 1, 1, 0]");
        // System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 3)) + " = [0, 0, 1, 1, 1, 1, 1, 0]");
    }

    private static int[] newState(int[] nums, int k) {
        Map<String, Integer> stateMap = new HashMap<>();
        int day = 0;
        while (k > 0) {
            k--;
            day++;
            int[] next = new int[8];
            next[0] = nums[1];
            next[7] = nums[6];
            for (int i = 1; i < 7; i++) {
                next[i] = nums[i - 1] ^ nums[i + 1];
            }
            String nextStr = Arrays.toString(next);
            if (stateMap.containsKey(nextStr)) {
                int pre = stateMap.get(nextStr);
                k /= (day - pre);
            } else {
                stateMap.put(nextStr, k);
            }
            nums = next;
        }
        return nums;
    }
}