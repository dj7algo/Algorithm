package week13;
import java.util.*;
import java.io.*;


public class Main_bj_16234_인구이동 {
	static int N;
	static int left;
	static int right;
	static int[][] map;
	static int[] di = {-1,1,0,0}; //사방탐색 (상하좌우)
	static int[] dj = {0,0,-1,1};
	
	static boolean BFS(int startX, int startY, boolean[][] visited) {
		Queue<int[]> q = new ArrayDeque<>();
		//방문처리 후 큐 삽입
		visited[startX][startY] = true;
		q.offer(new int[] {startX, startY});
		
		List<int[]> change = new ArrayList<int[]>();
		int unionSum = 0; //총인구수
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			change.add(cur); // 나중에 값을 다 바꿔줘야할 좌표들을 저장한다.
			unionSum += map[cur[0]][cur[1]]; // BFS지점의 모든 합을 더해준다. (나중에 계산용)
			for (int i = 0 ; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
					// 인접한나라와의 차이
					int diff = Math.abs( map[ni][nj] - map[cur[0]][cur[1]]);
					if (diff >= left && diff <= right) {
						visited[ni][nj] = true;
						q.offer(new int[] {ni,nj});
					}
				}
			}
		}
		int changeVal = unionSum / change.size();// 인구수 / 연합이루는 칸의 개수
		for (int i = 0 ;i < change.size(); i++) {
			int[] cur = change.get(i);
			map[cur[0]][cur[1]] = changeVal;
		}
		if (change.size() == 1) return false; else return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		left = Integer.parseInt(st.nextToken());
		right = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0 ; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean movepeople = true;
		int day = -1;
		while (movepeople) {
			boolean[][] visited = new boolean[N][N];
			movepeople = false;
			for (int i = 0 ; i < N; i++) {
				for (int j = 0 ; j < N; j++) {
					if(!visited[i][j]) {
						boolean move = BFS(i,j,visited); //방문안한곳에서 시작해서 국경선표시하면서 값바꾸기
						if (move) {
							movepeople = true;
						}
					}
				}
			}
			day++;
		}
		System.out.println(day);
		br.close();
	}
}
