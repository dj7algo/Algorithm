package a0301;
import java.util.*;
import java.io.*;
/*
 치즈 겉부분은 녹는다 -> 겉부분을 어떻게 구분?
 내부에 구멍이 없으면 사방탐색 바로적용가능한데 내부구멍과 구분을 해야함
 
 가장자리에는 치즈가 놓이지않음 -> (0,0)에서부터 dfs or bfs 돌려서
 -1로 표현 -> 계속 0으로 남아있는 부분은 내부 치즈임 
 ->-1과 맞닿아있는 1은 모두 -1로 변경  
 */
public class 치즈2636 {

	static int[][] arr;
	static int sero ;
	static int garo ;
	
	static int cheezecnt() {				//현재 남아있는 치즈개수 구하는 함수
		int cnt = 0;
		
		for(int i=0; i<sero; i++){
			for(int j=0; j<garo; j++) {
				if(arr[i][j]==1)cnt++;
			}
		}
		return cnt;
	}
	
	static boolean check(int i, int j) {
		if(0<=i&&i<sero && 0<=j&&j<garo)return true;
		return false;
	}
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int[][] visit;
	
	static void dfs(int i, int j) {			//dfs를 통한 공기부분 구분작업
		
		arr[i][j] = -1;
		visit[i][j] = 1;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(check(ni, nj) && visit[ni][nj]==0 && (arr[ni][nj]==0 || arr[ni][nj]==-1)) {	//공기가 들어갈수도있음
				dfs(ni, nj);
			}
		}
	}
	
	static void melt() {
		Queue<int[]>q = new LinkedList<>();			// 바로 -1로 값을 변경해주면 다음것이 영향받을 수 있으므로
													// 큐를 이용하여 한번에 바꿔준다
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				
				if(arr[i][j]==1) {						//만약 1이고
					for(int d=0; d<4; d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						if(arr[ni][nj]==-1)q.add(new int[] {i, j});	//사방에 -1이 하나라도 있으면
					}
				}
			}
		}
		
		while(!q.isEmpty()) {			//공기와 맞닿아 있는것들 -1로 변경작업
			int[] now = q.poll();
			int nowi = now[0];
			int nowj = now[1];
			
			arr[nowi][nowj] = -1;
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
		
		int time = 0;
		int precnt = 0;
		int nowcnt = 0;
		
		while(true) {	
			
			nowcnt = cheezecnt();
			if(nowcnt==0) {
				break;
			}else {
				precnt = nowcnt;
				time++;
				visit = new int[sero][garo];
				dfs(0,0);			//공기부분 작업
				melt();				//맞닿아 있는부분 녹이는 작업
			}
		}
		
		System.out.println(time+"\n"+precnt);
		
	}

}
