package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class etc {
	public static void main(String[] args) {
		HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		hm.put("1", arr);
		ArrayList<Integer> temp;
		temp = hm.get("1");
		System.out.println(hm.get("1"));
		for(int i : temp) i = 0;
		System.out.println(hm.get("1"));
	}
}
