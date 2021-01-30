import java.util.*;
import java.io.*;
import java.lang.*;

// Question: https://leetcode.com/discuss/interview-question/1023609/amazon-oa-shopping-options
public class HelloWorld {

    public static void main(String[] args) {
        int[] jeans = new int[]{2,3};
        int[] shoes = new int[]{4};
        int[] skirts = new int[]{2,3};
        int[] tops = new int[]{1,2};
        List<Integer> jeans_l = Arrays.asList(2,3);
        List<Integer> shoes_l = Arrays.asList(4);
        List<Integer> skirts_l = Arrays.asList(2,3);
        List<Integer> tops_l = Arrays.asList(1,2);
    System.out.println(getNumberOfOptions(jeans_l,shoes_l,skirts_l,tops_l,10));
    }

    public static long getNumberOfOptions(List priceOfJeans, List priceOfShoes, List priceOfSkirts, List priceOfTops, int dollars) {
		long res = 0;
		List<List<Integer>> list = new ArrayList<>();
		list.add(priceOfJeans);
		list.add(priceOfShoes);
		list.add(priceOfSkirts);
		list.add(priceOfTops);

		int n = list.size();
		int[] index = new int[n];
		for(int i=0; i<n; i++)
			index[i]=0;

		while(true)
		{
		   int count=0;
		   for(int i=0; i<n; i++)
		   {
			   count+=list.get(i).get(index[i]);
			   if(count>dollars)
				break;
		   } 
		   if(count<=dollars)
				res+=1;
			int n_=n-1;
			while(n_>=0 && index[n_]+1>=list.get(n_).size())
				n_-=1;
			if(n_<0)
				break;
			index[n_]+=1;
			for(int i=n_+1; i<n; i++)
				index[i]=0;
		}
		return res;

		}
		}
