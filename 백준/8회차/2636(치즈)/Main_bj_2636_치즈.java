package week8;
import java.util.*;
import java.io.*;

public class Main_bj_2636_치즈 {
	static int[] di = {-1,1,0,0}; //상, 하, 좌, 우
	static int[] dj = {0,0,-1,1}; // 상, 하, 좌, 우
	static int R;
	static int C;
	static boolean[][] visited;
	static int[][] arr;
	
	static void BFS() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited[0][0] = true;
		q.offer(new int[] {0,0});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int a = 0 ;  a < 4; a++) {
				int ni = cur[0] + di[a];
				int nj = cur[1] + dj[a];
				if (ni >= 0 && ni < R && nj >= 0 && nj < C && !visited[ni][nj] ) {
					visited[ni][nj] = true;
					if (arr[ni][nj] == 1) {
						arr[ni][nj] = 2;//익은거로 바꾸기
					}else if (arr[ni][nj] == 0) { //다음에 가야할 곳 저장
						q.offer(new int[] {ni, nj});
					}
					
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		//1. 배열담기
		int cheese = 0;
		for (int i = 0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					cheese++;
				}
			}
		}
		int time = 0;
		int lastcheese = 0;
		while(cheese > 0) {
			visited = new boolean[R][C];
			lastcheese = cheese;
			//2. 0인곳에서 상하좌우 탐색해서 1인거 못찾을때까지 반복해서 2로 익혀버리기 // 이걸 BFS또는 DFS로 하면될듯? DFS는 안될듯;
			BFS();
			//3. 익힌거 날려버리기
			for (int i = 0 ; i < R ; i++) {
				for (int j = 0 ; j < C; j++) {
					if (arr[i][j] == 2) {
						cheese--;//치즈 빼고
						arr[i][j] = 0; //날라간거 0으로
					}
				}
			}
			time++;
		}
		System.out.println(time);
		System.out.println(lastcheese);

		br.close();
	}
}	
