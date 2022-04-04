package a0403;

import java.util.*;
import java.io.*;

public class 백준1932정수삼각형 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		long[][] arr = new long[size][size];
		long[][] sum = new long[size][size];
		
		for(int i=0; i<size; i++) {
			StringTokenizer ST = new StringTokenizer(br.readLine());		
			for(int j=0; j<=i; j++) {
				arr[i][j] = Integer.parseInt(ST.nextToken());
			}
		}
		
		sum[0][0] = arr[0][0];
		
		for(int i=1; i<size; i++) {
			
			for(int j=0; j<size; j++) {
				long tmp1 = 0;
				long tmp2 = sum[i-1][j];
				if(j-1>=0)tmp1=sum[i-1][j-1];
				
				long tmpmax = Math.max(tmp1, tmp2);
				sum[i][j] = tmpmax+arr[i][j];
			}
		}
		
//		for(int i=0; i<size; i++) {
//			for(int j=0; j<=i; j++) {
//				System.out.print(sum[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		long maxnum = 0;
		for(int j=0; j<size; j++) {
			maxnum = Math.max(maxnum, sum[size-1][j]);
		}
		
		System.out.println(maxnum);
	}
}
