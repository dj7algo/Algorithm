package a0204;

import java.io.*;
import java.util.*;


/*
  index 짝: (1,6 / 2,4 / 3,5)
  
  -> 배열 돌면서 index 1,2,3만 확인하며 완전탐색?
  -> 1행에서 index 정해지면 해당 idx수와 짝이되는 수를 제외하고 최대값찾기
  -> 모든 행 반복하며 수행
  -> 총 3가지 경우가 나온다 
  
 */

public class B주사위쌓기 {
	static int maxsum = 0;
	static int pair = 0;
	static int down = 0;
	static int sero = 0;
	
	static int[][] arr; 
	
	static int pairfind(int picknum, int sero) {	
		int pair = 0;
		for(int i=1; i<=6; i++) {
			if(arr[sero][i]==picknum) {
				if(i==1)pair = arr[sero][6];
				else if(i==2)pair = arr[sero][4];
				else if(i==3)pair = arr[sero][5];
				else if(i==4)pair = arr[sero][2];
				else if(i==5)pair = arr[sero][3];
				else if(i==6)pair = arr[sero][1];
			}
		}
		return pair;
	}
	
	static void maxfind(int downside, int serocnt, int sum) {
		if(serocnt==sero+1) {
			if(maxsum<sum) {
				maxsum = sum;
			}
			return ;
		}
		
		int pair = pairfind(downside, serocnt);	
		int nowmax = 6;
		while(true) {									//지금 행에서 옆면최대값 찾는 과정 
			if(nowmax != pair&&nowmax != downside)break;
			else nowmax--;
		}
		maxfind(pair, serocnt+1, sum+nowmax);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sero = sc.nextInt();
		arr = new int[sero+1][7];

		for(int i=1; i<=sero; i++) {
			for(int j=1; j<=6; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=6; i++) {
			maxfind(arr[1][i], 1, 0);
		}		
		
		System.out.println(maxsum);
		sc.close();
	}
}
