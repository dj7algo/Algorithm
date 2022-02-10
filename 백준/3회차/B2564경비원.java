package a0210;

import java.util.*;

public class 경비원 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int garo = sc.nextInt();		//가로 크기
		int sero = sc.nextInt();		//세로 크기
		int cnt = sc.nextInt();			//지점 개수 
	
		int[][] arr = new int[cnt][2];
		
		for(int i=0; i<cnt; i++) {
			arr[i][0] = sc.nextInt();		//방향
			arr[i][1] = sc.nextInt();		//기준점으로부터의 거리 
		}
		
		int stddir = sc.nextInt();			//기준점 방향
		int len = sc.nextInt();				//기준점으로부터 거리 
		
		int[] pair = new int[5];			//밎은편 구분을 위한 배열	
		pair[1] = 2; pair[2] = 1; pair[3] =4; pair[4]=3;
		
		
		// 북:1, 남:2, 서:3, 동:4
		int sum = 0;
		for(int i=0; i<cnt; i++) {
			int nowdir = arr[i][0];
			int nowlen = arr[i][1];
			
			if(stddir==nowdir)sum+=Math.abs(len-nowlen);
			else if(stddir==1) {
				if(nowdir==3)sum+=(len+nowlen);
				else if(nowdir==4)sum+=(garo-len+nowlen);
				else if(nowdir==2) {
					sum+=Math.min(len+sero+nowlen, garo-len+sero+garo-nowlen);
				}
			}else if(stddir==2) {
				if(nowdir==1) {
					sum+=Math.min(len+sero+nowlen, garo-len+sero+garo-nowlen);
				}else if(nowdir==3)sum+=(len+sero-nowlen);
				 else if(nowdir==4)sum+=(garo-len+sero-nowlen);
			}else if(stddir==3) {
				if(nowdir==1)sum+=len+nowlen;
				else if(nowdir==2)sum+=(sero-len+nowlen);
				else if(nowdir==4) {
					sum+=Math.min(len+garo+nowlen, sero-len+garo+sero-nowlen);
				}
			}else if(stddir==4) {
				if(nowdir==1)sum+=len+garo-nowlen;
				else if(nowdir==2)sum+=(garo-nowlen+sero-len);
				else if(nowdir==3) {
					sum+=Math.min(len+garo+nowlen, garo+sero-len+sero-nowlen);
				}
			}
		}
		System.out.println(sum);
	}
}
