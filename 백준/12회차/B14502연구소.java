package a0320;

import java.util.*;
import java.io.*;

/*
 모든 방법 생각해봤으나 다 안될거같음 
 최후의 수단 -> 모든 좌표에서 조합으로 3개뽑아서 완전탐색 돌리기 -> 15퍼쯤에서 시간초과 뜸
 
 */

public class B14502연구소 {
	static ArrayList<int[]> list;
	static int[] result = new int[3];
	static int maxcnt = 0;
	static int arr[][];
	static int sero ;
	static int garo ;
	static int nowcnt;
	static int cnt2;
	static ArrayList<int[]> tmpq = new ArrayList<>();
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	static boolean check(int i, int j) {
		if(0<=i&&i<sero && 0<=j&&j<garo)return true;
		return false;
	}
	
	static int[][] visit;
	
	static int getcnt(int[][] tmp) {
		
		for(int i=0; i<3; i++) {
			int[] now = list.get(result[i]); 		//result 조합
			int nowi = now[0];	int nowj = now[1];
			tmp[nowi][nowj] = 1;					//선택된 조합에 벽쌓기
		}
		
		visit = new int[sero][garo];
		
		Queue<int[]> q = new LinkedList<>();
			
		for(int i=0; i<tmpq.size(); i++) {
			q.add(tmpq.get(i));
		}
		
		nowcnt = list.size();
		
		//System.out.println(q.size());
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowi = now[0];	int nowj = now[1];
			
			for(int d=0; d<4; d++) {
				int ni = nowi+di[d];
				int nj = nowj+dj[d];
				if(check(ni,nj) && visit[ni][nj]==0 && tmp[ni][nj]==0) {
					visit[ni][nj] = 1;
					tmp[ni][nj] = 2;
					nowcnt--;
					q.add(new int[] {ni, nj});
				}
			}
		}
		
		return nowcnt-3;
	}
	
	
	static void combination(int cnt, int idx) {
		
		if(cnt==3) {
			int[][] temp = new int[sero][garo];
			for(int i=0; i<sero; i++) {
				for(int j=0; j<garo; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			int nowcnt = getcnt(temp);
			maxcnt = Math.max(maxcnt, nowcnt);
			return;
		}
		
		
		for(int i=idx; i<list.size(); i++) {
			result[cnt] = i;
			combination(cnt+1, idx+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		sero = Integer.parseInt(ST.nextToken());
		garo = Integer.parseInt(ST.nextToken());
		list = new ArrayList<>();
		
		
		arr = new int[sero][garo];
		
		for(int i=0; i<sero; i++) {
			ST = new StringTokenizer(br.readLine());
			
			for(int j=0; j<garo; j++) {
				arr[i][j] = Integer.parseInt(ST.nextToken());
				if(arr[i][j]==0)list.add(new int[] {i,j});
				else if(arr[i][j]==2)tmpq.add(new int[] {i,j});
			}
		}
		
		combination(0, 0);
		
		
		System.out.println(maxcnt);
		
	}
}
