package a0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
 3차원 bfs 활용 
 익은 토마토 = 1, 안익은 = 0, 없는곳 = -1
 
 시작점이 따로 없음 -> for문 3개 돌려서 1인곳 모두 큐에 넣기
 큐에서 빼고 그 좌표 주변에 0이었던곳 1로 바꾸고 그곳을 또 큐에넣기
 
 시작 -> 모두 익어있는지 판단
 중간 -> bfs 돌리기
 끝 -> 전체 for문돌면서 안익은곳 있는지 판단  -> -1출력
 
 */
public class 백준7569토마토 {

	static int garo ;
	static int sero ;
	static int h ;
	static int[][][] arr ;
	static int[][][] visit ;
	static int maxday;
	
	static int search() {		// 0이 하나라도 있으면 1반환, 0이 없으면 0 반환
		
		int flag = 0;
		for(int k=0; k<h; k++) {
			for(int i=0; i<sero; i++) {
				for(int j=0; j<garo; j++) {
					if(arr[k][i][j] == 0) {
						flag = 1;
						return flag;
					}
				}
			}
		}
		return flag;
	}
	
	static int[] dh = {1, -1, 0, 0, 0, 0};
	static int[] di = {0, 0, -1, 0, 1, 0};
	static int[] dj = {0, 0, 0, 1, 0, -1};			//방향 6개 (위,아래,상우하좌)
	
	static boolean check(int k, int i, int j) {
		if(0<=k&&k<h && 0<=i&&i<sero && 0<=j&&j<garo)return true;
		return false;
	}
	
	
	static void bfs() {
		
		Queue<int[]> q = new LinkedList<int[]>();		//좌표 큐 선언
		
		for(int k=0; k<h; k++) {						//초기설정
			for(int i=0; i<sero; i++) {
				for(int j=0; j<garo; j++) {
					if(arr[k][i][j] == 1) {
						q.add(new int[] {k,i,j,0});		//좌표 + day
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowh = now[0]; int nowi = now[1]; int nowj = now[2]; int day = now[3];
			
			maxday = Math.max(maxday, day);
			
			for(int d=0; d<6; d++) {
				int nh = nowh+dh[d];
				int ni = nowi+di[d];
				int nj = nowj+dj[d];
				
				if(check(nh,ni,nj) && arr[nh][ni][nj]==0 && visit[nh][ni][nj]==0) {
					visit[nh][ni][nj] = 1;
					arr[nh][ni][nj] = 1;
					q.add(new int[] {nh, ni, nj, day+1});
				}
			}
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		garo = Integer.parseInt(ST.nextToken());
		sero = Integer.parseInt(ST.nextToken());
		h = Integer.parseInt(ST.nextToken());
		arr = new int[h][sero][garo];
		visit = new int[h][sero][garo];
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<sero; i++) {
				ST = new StringTokenizer(br.readLine());
				for(int j=0; j<garo; j++) {
					arr[k][i][j] = Integer.parseInt(ST.nextToken());
				}
			}
		}
		
		if(search()==0)System.out.println(0);	//처음부터 모두 익어있는 경우
		else {
			bfs();
			if(search()==1)System.out.println(-1);		//bfs 다 돌렸는데도 안익은곳 있는경우
			else {
				System.out.println(maxday);
			}
		}
		
	}

}
