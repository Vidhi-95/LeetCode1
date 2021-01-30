import java.util.*;
import java.io.*;
import java.lang.*;

public class HelloWorld {

    // Storage Optimization - OA2 question
    //Question link: https://leetcode.com/discuss/interview-question/1021429/Amazon-OA-or-storage-optimization
    private static int storageOpt(int n, int m, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);

        // try to find the longest consecutive sequence
        // for both h and v separators
        int prev=0,seq=0;
        int mxh=0;
        for (int i=0;i<h.length;i++) {
            if (h[i]-prev == 1) {
                seq++;
            } else {
                seq = 1;
            }
            mxh = Math.max(seq, mxh);
            prev = h[i];
        }
        prev=0;seq=0;
        int mxv=0;
        for (int i=0;i<v.length;i++) {
            if (v[i]-prev == 1) {
                seq++;
            } else {
                seq = 1;
            }
            mxv = Math.max(seq, mxv);
            prev = v[i];
        }
        return (mxh+1)*(mxv+1);
    }        

    
     public static void main(String []args){
        int[] arr_h = {1,2,3};
        int[] arr_v = {1,2};
       HelloWorld hw = new HelloWorld();
       System.out.println(storageOpt(3,2,arr_h, arr_v));
     }  
}
