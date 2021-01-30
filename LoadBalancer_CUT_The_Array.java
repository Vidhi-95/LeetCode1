import java.util.*;

 public class Solution {
	public boolean loadBalance(int[] arr) {
		int sum = 0;
		int len = arr.length;
		if(len < 5){
		    return false;
		}
		for(int i =0;i<len;i++) {
		    sum += arr[i];
		}
		int prefixSum = arr[0], suffixSum = arr[len-1];
		int left = 1, right = len - 2;
		boolean flag = false;
		while(left < right - 1) {
		    int midSum = sum - prefixSum - suffixSum - arr[left] - arr[right];
		    if(prefixSum == midSum && suffixSum == midSum) {
		        flag = true;
		        break;
		    } else {
		        if(prefixSum < suffixSum) {
		            prefixSum += arr[left];
		            left++;
		        } else if(prefixSum > suffixSum) {
		            suffixSum += arr[right];
		            right--;
		        } else {
		            prefixSum += arr[left];
		            suffixSum += arr[right];
		            left++;
		            right--;
		        }
		    }
		}
		return flag;
	}
}
