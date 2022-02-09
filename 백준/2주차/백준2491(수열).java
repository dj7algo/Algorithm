package A0209;

import java.util.*;

/*
 배열을 입력받고 -> 방향으로 탐색 1회, <- 방향으로 탐색 1회를 한다. 
 len이라는 배열을 또 만들고 방향마다 증가하거나 수가 같으면 이전원소에 지금 원소값을 더한다

*/
public class B2491수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numsize = sc.nextInt();
		
		int[] nums = new int[numsize];						//입력으로 들어오는 수들을 저장할 배열
		int[] lens = new int[numsize];						//증가하는 범위를 저장할 배열 
		
		for(int i=0; i<numsize; i++) {
			nums[i] = sc.nextInt();
			lens[i] = 1;
		}
		
		int len = 0;
		int maxlen = 0;
		for(int i=1; i<numsize; i++) {
			if(nums[i]>=nums[i-1])lens[i]+=lens[i-1];
		}
		
		for(int i=0; i<numsize; i++) {
			if(lens[i]>maxlen)maxlen=lens[i];
			lens[i]=1;
		}
		
		for(int i=numsize-2; i>=0; i--) {
			if(nums[i]>=nums[i+1])lens[i]+=lens[i+1];
		}
		
		for(int i=0; i<numsize; i++) {
			if(lens[i]>maxlen)maxlen=lens[i];
		}
		
		System.out.println(maxlen);
	}
}
