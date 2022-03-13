package week11;
import java.util.*;
import java.io.*;
public class Main_bj_14503_로봇청소기_대전_5반_송보근 {
	
	static int backward(int dir) {
		switch(dir) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		default:
			return 1;
		}
	}
	static int dirLeft(int dir) {
		switch(dir) {
		case 0:
			return 3;
		case 1:
			return 0;
		case 2:
			return 1;
		default :
			return 2;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] di = {-1,0,1,0}; // 0 : 북 1: 동 2: 남 3:서
		int[] dj = {0,1,0,-1};
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int curX = Integer.parseInt(st.nextToken());
		int curY = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		//0. 맵넣기
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//1. BFS
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {curX, curY, dir});
		int clean = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = 2; //청소하기!
			
			int check4 = 0;
			for (int i = 0 ; i < 4; i++) {
				//4방탐색
				int ni2 = cur[0] + di[i];
				int nj2 = cur[1] + dj[i];
				if (ni2 >= 0 && ni2 < N && nj2 >= 0 && nj2 < M && map[ni2][nj2] != 0 ) {
					check4++;
				}
			}
			if (check4 == 4) { //4방향 모두 청소되어있거나 벽인경우 방향유지한채로 후진
				int dir3 = backward(cur[2]);
				int ni3 = cur[0] + di[dir3];
				int nj3 = cur[1] + dj[dir3];
				if (ni3 >= 0 && ni3 < N && nj3 >= 0 && nj3 < M && map[ni3][nj3] != 1) {
					q.offer(new int[] {ni3, nj3, cur[2]}); //3조건
				}else {
					break;
				}
			}else {
				//1-1. 왼쪽방향 보세요
				int leftdir = dirLeft(cur[2]);
				int ni = cur[0] + di[leftdir]; //왼쪽x좌
				int nj = cur[1] + dj[leftdir]; //왼쪽y좌
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0 ) {
					q.offer(new int[] {ni, nj, leftdir}); //회전, 전진, 방향
					continue;
				}
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 0 ) {
					q.offer(new int[] {cur[0], cur[1], leftdir}); //회전, 전진, 방향
					continue;
				}
			}

			
			
		}
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j <M; j++) {
				if (map[i][j] == 2) clean++;
			}
		}
		System.out.println(clean);
		
		
		br.close();
	}
}
