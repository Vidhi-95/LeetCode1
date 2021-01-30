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
  
      private static int getCount(int n, int[] nums, int reviews, int min, int max) {
          int count = 0, result = 0;
          for(int num: nums){
              if(min<=num && max>= num){
                  count++;
              }
          }
          for (int i = reviews; i <= count; i++) {
            result += combReviews(count, i);
        }
        return result;
      }
          private static int combReviews(int n, int r){
              if(n == r) return 1;
              int top = fact(n, r+1);
              int bottom = fact(n-r, 1);
              return top / bottom;
          }
          
          private static int fact(int from, int end){
              int result = 1;
              for( int i = from; i>= end; i--){
                  result *= i;
              }
              return result;
          }
    public static void main(String[] args) {
        System.out.println(getCount(8, new int[]{6, 13, 3, 10, 12, 4, 2, 15}, 3, 4, 10));
    }
}