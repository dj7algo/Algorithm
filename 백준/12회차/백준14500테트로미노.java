package a0320;

import java.util.*;
import java.io.*;

/*
 2차원배열의 각좌표마다 bfs 4단계까지 돌려서 그합의 최대값을 구하자
 
 ***
  *		-> 단순히 bfs로 풀면 이모양을 뽑아낼 수 없음 
 
 -> bfs말고 dfs로 나머지 처리해야함 
 
 */


public class 백준14500테트로미노 {

	static int[][] arr;
	static int[][] visit;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	static int maxsum = 0;
	static int sero;
	static int garo;
	
	static boolean check(int i, int j) {
		if(0<=i&&i<sero && 0<=j&&j<garo)return true;
		return false;
	}
	
	static void dfs(int i, int j, int sum, int cnt) {
		
		//System.out.println("i:"+i+" j:"+j+" sum:"+sum);
		if(cnt==4) {
			maxsum = Math.max(maxsum, sum);
			//System.out.println("종료");
			return;
		}
			
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(check(ni,nj) && visit[ni][nj]==0) {
				visit[ni][nj] = 1;
				dfs(ni,nj,sum+arr[ni][nj],cnt+1);
				visit[ni][nj] = 0;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer ST = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(ST.nextToken());
		garo = Integer.parseInt(ST.nextToken());
		
		arr = new int[sero][garo];
		
		for(int i=0; i<sero; i++) {
			ST = new StringTokenizer(br.readLine());
			for(int j=0; j<garo; j++) {
				arr[i][j] = Integer.parseInt(ST.nextToken());
			}
		}
		visit = new int[sero][garo];
		
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				visit[i][j] = 1;
				dfs(i, j, arr[i][j], 1);
				visit[i][j] = 0;
			}
		}
		
		//  *
		// ***	-> 이모양은 4방향으로 직접 계산 
		
		int sum = 0;
		
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				if(check(i+1,j) && check(i+1,j-1) && check(i+1,j+1)) {
					sum=arr[i][j]+arr[i+1][j]+arr[i+1][j-1]+arr[i+1][j+1];
					maxsum = Math.max(sum, maxsum);
				}
				
				if(check(i+1,j) && check(i+2,j) && check(i+1,j+1)) {
					sum = arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j+1];
					maxsum = Math.max(sum, maxsum);
				}
				
				if(check(i,j+1) && check(i,j+2) && check(i+1,j+1)) {
					sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1];
					maxsum = Math.max(sum, maxsum);
				}
				
				if(check(i,j+1) && check(i-1,j+1) && check(i+1,j+1)) {
					sum = arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i+1][j+1];
					maxsum = Math.max(sum, maxsum);
				}
			}
		}
		
		System.out.println(maxsum);
		
	}
}
