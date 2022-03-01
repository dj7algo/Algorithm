package a0301;

import java.util.*;
import java.io.*;


/*
 최대값의 최소값 -> 최소라는 표현은 의미가 없음 그냥 bfs처리하면됨 
 
 즉, 육지상의 어느지점간의 거리가 최대인지 찾는게 중요 
 -> L표시된곳에서 모두 bfs 돌려봐야할듯 
 
 */
public class 보물섬2589 {
	
	static int sero;
	static int garo;
	static char[][] arr;
	static int[][] visit;
	static int maxlen = 0;
	
	static boolean check(int i, int j) {
		if(0<=i&&i<sero && 0<=j&&j<garo)return true;
		return false;
	}
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	static void bfs(int starti, int startj) {
		
		Queue<int[]>q = new LinkedList<int[]>();
		q.add(new int[] {starti, startj, 0});				//bfs 큐에 넣을것: (좌표 + 시작점으로부터의 거리) 
		visit[starti][startj] = 1;
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			int nowi = now[0]; int nowj = now[1]; int nowlen = now[2];		//현재 좌표의 좌표와 시작점으로부터의 거리 
			
			maxlen = Math.max(maxlen, nowlen);
			
			for(int d=0; d<4; d++) {
				int ni = nowi+di[d];
				int nj = nowj+dj[d];
				
				if(check(ni,nj) && visit[ni][nj]==0 && arr[ni][nj]=='L') {		//조건 만족하는 육지로만 이동 한다 
					visit[ni][nj] = 1;
					q.add(new int[] {ni, nj, nowlen+1});						// 다음단계로 갈수록 길이는 1추가
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		sero = Integer.parseInt(ST.nextToken());
		garo = Integer.parseInt(ST.nextToken());
		arr = new char[sero][garo];
		
		
		for(int i=0; i<sero; i++) {
			String tmp = br.readLine();
			for(int j=0; j<garo; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				visit = new int[sero][garo];
				if(arr[i][j] == 'L')bfs(i, j);
			}
		}
		System.out.println(maxlen);
		
	}
}
