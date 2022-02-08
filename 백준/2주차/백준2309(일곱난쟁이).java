package a0204;

import java.io.*;
import java.util.*;

public class B일곱난쟁이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		
		int sum = 0;
		for(int i=1; i<=9; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		
		int findi = 0;
		int findj = 0;
		
		for(int i=1; i<=8; i++) {
			for(int j=i+1; j<=9; j++) {
				if(sum-arr[i]-arr[j]==100) {
					findi = i; findj = j;
					break;
				}
			}
		}
		
		int[] result = new int[7];
		int idx = 0;
		
		for(int i=1; i<=9; i++) {
			if(i!=findi && i!=findj) {
				result[idx] = arr[i];
				idx++;
			}
		}
		Arrays.sort(result);
		for(int i=0; i<7; i++) {
			System.out.println(result[i]);
		}
		
	}
}
