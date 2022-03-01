package a0301;

import java.util.*;
import java.io.*;
/*
 처음 떠오르는 풀이 -> 그냥 완탐?
 n,m이 최대값 = 50이니까 최대연산 -> 64 * 42 * 42번
 
 근데 언제 최소가 되지? -> 8*8크기의 첫원소가 W일때랑 B일때로 나눠야할듯?
 
 
 */

public class 체스판다시칠하기 {

	static char[][] arr;
	static int mincnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer ST = new StringTokenizer(br.readLine());
		int sero = Integer.parseInt(ST.nextToken());
		int garo = Integer.parseInt(ST.nextToken());
		
		arr = new char[sero][garo];
		
		for(int i=0; i<sero; i++) {
			String tmp = br.readLine();
			for(int j=0; j<garo; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i=0; i<=sero-8; i++) {
			for(int j=0; j<=garo-8; j++) {
				
				int nowcnt = count(i,j,'B');
				mincnt = Math.min(nowcnt, mincnt);
				
				nowcnt = count(i,j,'W');
				mincnt = Math.min(nowcnt, mincnt);
			}
		}
		
		System.out.println(mincnt);
		
	}
	
	static int count(int iidx, int jidx, char std) {
		
		int cnt = 0;
		for(int i=iidx; i<iidx+8; i++) {
			for(int j=jidx; j<jidx+8; j++) {
				if(i%2==0) {
					if(j%2==0) {
						if(arr[i][j]!=std)cnt++;	//짝수번째 i줄, 짝수번째j열 원소
					}else {
						if(arr[i][j]==std)cnt++;	//짝수번째 i줄, 홀수번째j열 원소
					}
				}else {
					if(j%2==0) {
						if(arr[i][j]==std)cnt++;	// 홀수번째 i줄, 짝수번째j열 원소
					}else {
						if(arr[i][j]!=std)cnt++;	// 홀수번째 i줄, 홀수번째j열 원소
					}
				}
			}
		}
		return cnt;
	}

}
