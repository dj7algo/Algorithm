package a0403;

import java.util.*;
import java.io.*;

public class 백준9461_파도반수열 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		long[] arr = new long[101];
		arr[0] = 0;	arr[1] = 1;
		arr[2] = 1;	arr[3] = 1;
		arr[4] = 2;
		
		for(int i=5; i<=100; i++) {
			arr[i] = arr[i-1]+arr[i-5];
		}
		
		for(int i=0; i<tc; i++) {
			int n = sc.nextInt();
			System.out.println(arr[n]);
		}
	}

}
