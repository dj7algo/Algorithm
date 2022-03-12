package a0303;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;

/*
 아이디어 -> 
 초기 좌표 50,50으로 설정하고 좌표상에서 움직인곳은 모두 1로 처리
 움직일때마다 x의 최소 최대좌표, y의 최소 최대좌표를 구한다. 
 -> 나중에 for문으로 최소 최대를 범위로 잡고 배열 돌면서 
 1로 표시된 곳은 "."을 출력, 아닌곳은 "#"을 출력한다. 
 */

public class B1347미로탐색 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int move = Integer.parseInt(br.readLine());
		String tmp = br.readLine();
		
		int[][] arr = new int[100][100];
		
		int nowi = 50; int nowj = 50;
		int mini = 50; int maxi = 50;
		int minj = 50; int maxj = 50;
		
		arr[nowi][nowj] = 1;
		
		int[] di = {1, 0, -1, 0};
		int[] dj = {0, -1, 0, 1};		//하 좌 상 우
		int d = 0;
		
		for(int i=0; i<move; i++) {
			char ch = tmp.charAt(i);
			
			if(ch=='R')d=(d+1)%4;
			else if(ch=='L') {
				d--;
				if(d<0)d+=4;
			}else if(ch=='F') {
				nowi = nowi+di[d];
				nowj = nowj+dj[d];
				arr[nowi][nowj] = 1;
				
				mini = Math.min(mini, nowi);
				minj = Math.min(minj, nowj);
				
				maxi = Math.max(maxi, nowi);
				maxj = Math.max(maxj, nowj);
			}
		}
		
		for(int i=mini; i<=maxi; i++) {
			for(int j=minj; j<=maxj; j++) {
				if(arr[i][j] == 1)System.out.print(".");
				else System.out.print("#");
			}
			System.out.println();
		}
		
	}
}
