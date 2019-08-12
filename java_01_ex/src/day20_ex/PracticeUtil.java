package day20_ex;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class PracticeUtil {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		Random rand = new Random();
		//rand.setSeed(54);
		System.out.println(rand.nextInt());
		System.out.println("==============================");
		int[] arr = {1,2,3,4,5,6};
		
		List<int[]> li = Arrays.asList(arr);
		
		char[] arr2 = {'a','b','c'};
		List<char[]> li2 = Arrays.asList(arr2);
		
		Iterator it = li.iterator();
		while(it.hasNext()) {
			int[] data = (int[]) it.next();
			System.out.println(Arrays.toString(data));
		}
		System.out.println("============================");
		String str = "Hello";
		System.out.println(str.getBytes("utf-8"));
		String encode = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
		System.out.println(encode);
		byte[] asBytes = Base64.getDecoder().decode(encode);
		System.out.println(new String(asBytes,"utf-8"));
	}
}
