package a0222;

import java.util.*;

public class 백준퇴사 {
	
	static int n;
	static int[] time;
	static int[] money;
	static int maxmoney;
	
	static void findmax(int cnt, int sum) {
		if(time[cnt] > n-cnt)return;
		
		maxmoney = Math.max(sum, maxmoney);
		//System.out.println("cnt:"+cnt+" maxmoney:"+maxmoney);
		for(int i=time[cnt]+cnt; i<n; i++) {
			findmax(i, sum+money[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		time = new int[n];
		money = new int[n];
		
		for(int i=0; i<n; i++) {
			time[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			findmax(i, money[i]);
		}
		
		System.out.println(maxmoney);
		
	}
}
