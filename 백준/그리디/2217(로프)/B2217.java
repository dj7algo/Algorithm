package Greedy;

import java.util.*;

public class B2217 {

	public static void main(String[] args) {
		// 무게 / 로프의갯수 만큼 모든 로프가 동일하게 힘을 받는다 
		// weight / n 만큼 받는다 
		// 제일 약한 로프를 구하고 * n 하면 될듯?
		// -> 이렇게 풀고 틀림 문제조건 잘보자. 
		// 로프를 모두 쓸필요는 없다는 조건!!
		
		Scanner sc = new Scanner(System.in);
		int lopenum = sc.nextInt();
		
		// 모두 쓸필요가 없으면 어떻게 풀까 
		// 임의의 로프 집합에서 들수있는 최대 무게 = 최약체로프 * n개
		// 배열로 입력받고 정렬후 index를 n과의 관계를 이용해서 풀면될듯?
		
		int[] lopes = new int[lopenum];
		
		for(int i=0; i<lopenum; i++) {
			lopes[i] = sc.nextInt();
		}
		
		Arrays.sort(lopes); 						//배열 오름차순 정렬 
		
		int max = 0;
		
		for(int i=0; i<lopes.length; i++) {			// 최약체로프 * n 의 최대값을 찾는 과정 		
			int weight = lopes[i] * (lopenum-i);	
			
			if(weight > max)max=weight;
		}
		System.out.println(max);
		
	}
}
