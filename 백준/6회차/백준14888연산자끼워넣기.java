package a0222;

import java.util.*;

public class 연산자끼워넣기 {
	
	static int[] nums;
	static int maxnum = Integer.MIN_VALUE;
	static int minnum = Integer.MAX_VALUE;
	static int[] opercnt;
	static int allopercnt;
	static int n;
	
	static void find(int cnt, int sum) {
		
		if(cnt==n) {
			maxnum = Math.max(maxnum, sum);
			minnum = Math.min(minnum, sum);
			return;
		}
		
		
		for(int i=0; i<4; i++) {
			if(opercnt[i]!=0) {
				opercnt[i]--;
				if(i==0)find(cnt+1, sum+nums[cnt]);
				else if(i==1)find(cnt+1, sum-nums[cnt]);
				else if(i==2)find(cnt+1, sum*nums[cnt]);
				else if(i==3)find(cnt+1, sum/nums[cnt]);
				opercnt[i]++;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		allopercnt = 0;
		nums = new int[n];
		for(int i=0; i<n; i++)nums[i]=sc.nextInt();
		
		
		opercnt = new int[4];
		for(int i=0; i<4; i++) {
			opercnt[i]=sc.nextInt();
			allopercnt+=opercnt[i];		//모든 연산자 갯수의 합 
		}
		
		find(1, nums[0]);
		
		
		System.out.println(maxnum);
		System.out.println(minnum);
	}
}
