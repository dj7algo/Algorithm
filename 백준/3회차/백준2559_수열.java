package TwoPointer;

import java.util.Scanner;

/*
앞에서부터 1씩증가 뒤는 1씩감소 하며 최대값을 찾는 과정
->투포인터 방식을 사용하여 중복되는 연산은 피한다 

*/
public class B2559 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		int range = sc.nextInt();
		
		int[] arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		int sidx = 1;
		int eidx = range;
		
		int sum = 0;
		
		
		for(int i=sidx; i<=eidx; i++) {
			sum+=arr[i];
		}
		int maxsum = sum;
		
		for(int i=1; i<=n-range; i++) {
			sum = sum-arr[i]+arr[i+range];
			if(sum>maxsum)maxsum=sum;
		}
		
		
//		while(true) {
//			if(++eidx>n)break;
//			sum+=arr[eidx];
//			sum-=arr[sidx++];
//			
//			if(maxsum<sum)maxsum=sum;
//		}
		System.out.println(maxsum);
	}
}
