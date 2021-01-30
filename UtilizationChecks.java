/*import java.util.*;
import java.io.*;
import java.lang.*;
 */
package com.mycompany.practice_lc;


/**
 *
 * @author vidhi
 */
public class HelloWorld {

      public int finalInstances(int instances, int[] averageUtil) {
          //Utilization Checks
          // Question: https://aonecode.com/amazon-online-assessment-utilization-checks
          for(int i = 0; i<averageUtil.length; i++){
              if(averageUtil[i]<25 && instances>1){
                  // Below line is very important. Also do instances/2.0 and not 2
                  instances = (int)(Math.ceil(instances/2.0));
                  i+=10;
                   
              }
              else if(averageUtil[i]>60 && instances < 200000000){
              instances = instances*2;
                  i+=10;
                 
          }
              
          }
          return instances;
    }

    
     public static void main(String []args){
        int[] arr = {30,5,4,8,19,89};
//        int[][] arra = { { 1, 2 }, { 3, 4 } };
        //String[] cmnds = {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
//        System.out.println("Hello World");
       HelloWorld hw = new HelloWorld();
       System.out.println(hw.finalInstances(5,arr));
     }  
}
