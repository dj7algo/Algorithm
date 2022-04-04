package a0403;

import java.util.*;
import java.io.*;

public class 백준1904_01타일 {

	static long[] arr = new long[1000001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		arr[0] = 1;
		arr[1] = 1;
		int n = sc.nextInt();

		for(int i=2; i<=n; i++) {
			arr[i]=(arr[i-1]+arr[i-2])%15746;
		}
		
		System.out.println(arr[n]);
	}

}
