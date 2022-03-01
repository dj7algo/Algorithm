package a0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
a만 재배열 가능, b는 고정 -> a순열 돌려보면서 minsum 구하면 될듯?  
 
 */

public class 보물1026_첫풀이{

	static int size;
	static int A[];
	static int B[];
	static int visit[];
	static int minsum = Integer.MAX_VALUE;
	
	static void permutation(int cnt, int sum) {					// 순열 돌리는 함수 
		
		if(cnt == size) {										// A[] 다 선택했으면 최소값 비교
			minsum = Math.min(minsum, sum);
			return;
		}
		
		if(sum>minsum)return;
		
		
		for(int i=0; i<size; i++) {								// B배열 원소들과 이번에 곱할 원소를 A[]배열에서 고르는 작업
			if(visit[i]==0) {
				visit[i] = 1;
				permutation(cnt+1, sum+A[i]*B[cnt]);
				visit[i] = 0;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		A = new int[size];
		B = new int[size];
		visit = new int[size];
		
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		for(int i=0; i<size; i++) {
			A[i] = Integer.parseInt(ST.nextToken());
		}
		
		ST = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			B[i] = Integer.parseInt(ST.nextToken());
		}																		//조건 입력
		

		permutation(0,0);														//최소값 찾는 순열 돌리기
		System.out.println(minsum);												//결과 출력
	}

}
