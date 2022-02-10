package a0210;

import java.util.*;
public class 빙고 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int cnt=1; cnt<=25; cnt++) {
			int num = sc.nextInt();						//지금 부른번호
			
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(arr[i][j]==num)arr[i][j]=0;		//부른 숫자는 0처리
				}
			}
			
			int bingcnt = 0;
			if(cnt>=12) {								//빙고 3개될 최소조건
				for(int i=0; i<5; i++) {
					int j = 0;
					while(arr[i][j]==0) {
						j++;
						if(j==5) {
							bingcnt++;
							break;
						}
					}
				}	
				
				for(int j=0; j<5; j++) {
					int i=0;
					while(arr[i][j]==0) {
						i++;
						if(i==5) {
							bingcnt++;
							break;
						}
					}
				}
				
				if(arr[0][0]==0&&arr[1][1]==0&&arr[2][2]==0&&arr[3][3]==0&&arr[4][4]==0)bingcnt++;
				if(arr[0][4]==0&&arr[1][3]==0&&arr[2][2]==0&&arr[3][1]==0&&arr[4][0]==0)bingcnt++;
			}
			
			if(bingcnt>=3) {								// ==3으로 해서 처음에 틀림, 빙고2개에서 동시에 빙고 -> 빙고4개 되는경우도 있음 
				System.out.println(cnt);
				break;
			}
		}
	}
}
