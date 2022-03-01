package a0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
 문제 조건을 제대로 보지 않고 (N=50개까지) 처음에 완전탐색 돌려서 시간초과로 틀렸다.
 음의 양수만 배열에 들어오니 그리디로 풀어야한다. 
 한 배열의 가장 큰 수는 다른 배열의 가장 작은수와 계속 곱했을때 제일 작은 결과값을 갖는다.
 */

public class 보물1026_두번째풀이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int[] A = new int[size];
		Integer[] B = new Integer[size];
		
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		for(int i=0; i<size; i++) {
			A[i] = Integer.parseInt(ST.nextToken());
		}
		Arrays.sort(A);			//오름차순 정렬
		
		ST = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			B[i] = Integer.parseInt(ST.nextToken());
		}			
		
		Arrays.sort(B, Collections.reverseOrder());
		
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum+=A[i]*B[i];
		}
		System.out.println(sum);
		
	}

}
