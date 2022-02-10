package ps;

import java.util.*;
import java.io.*;

public class robot14503 {
	static int xsize, ysize;
	
	static boolean bind(int x, int y) {								//범위체크
		if(1<=x&&x<xsize-1 && 1<=y && y<ysize-1)return true;
		else return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		xsize = sc.nextInt(); 
		ysize = sc.nextInt();
		
		
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, 1, 0, -1};
		char[] d = {'북', '동', '남', '서'};
		
		int[][] arr = new int[xsize][ysize];		//입력받을 배열
		int[][] visit = new int[xsize][ysize];		//방문체크 배열
		
		
		int xnow = sc.nextInt();
		int ynow = sc.nextInt();
		int dir = sc.nextInt();
		
		for(int i=0; i<xsize; i++) {					//배열 입력
			for(int j=0; j<ysize; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int flag = 0;
		int sum = 0;
		int flag2 = 0;
		
		while(true) {		
			if(flag2==0) {
				flag = 0;
				visit[xnow][ynow] = 1;
				sum++;
			}
			flag2 = 0;
			//System.out.println("xnow: " + xnow + "ynow: "+ynow);
			
			for(int i=0; i<4; i++) {
				if(dir-1 < 0)dir=3;					// 사방탐색 과정
				else dir-=1;							
				
				int checkx = xnow + di[dir];
				int checky = ynow + dj[dir];
				
				if(bind(checkx, checky)&&visit[checkx][checky]==0 && arr[checkx][checky]==0) {		// 탐색과정에서 방문 안한곳은 이동
					xnow = checkx;
					ynow = checky;
					flag = 1;
					break ;
				}				
			}
			
			if(flag==1)continue;
			else {
				
				int backx = xnow - di[dir];
				int backy = ynow - dj[dir];
				
				if(arr[backx][backy]==1) {
					System.out.println(sum);
					return;
				}else {
					xnow = backx;
					ynow = backy;
					flag2 = 1;
				}
			}
		}
		
		
		
	}
}
