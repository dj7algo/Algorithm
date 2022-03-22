package week13;
import java.util.*;
import java.io.*;
public class Main_bj_14502_연구소 {
	static int N;
	static int M;
	static List<int[]> input = new ArrayList<>();
	static List<int[]> start = new ArrayList<>();
	static int[][] result = new int[3][2];
	static int[][] origin;
	static int zerosum;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1}; //상하좌우
	static int max = Integer.MIN_VALUE;
	static int BFS(int[][] map) {
		//1. 시작좌표 큐에 넣기
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0 ; i < start.size(); i++) {
			visited[start.get(i)[0]][start.get(i)[1]] = true; //방문처리 후
			q.offer(start.get(i));//큐에넣기
		}
		int safetyzone = zerosum-3; //벽3개 빼고
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0 ; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visited[ni][nj] && map[ni][nj] == 0) {
					visited[ni][nj] = true;
					map[ni][nj] = 2;
					safetyzone--;
					q.offer(new int[]{ni, nj});
				}
			}
		}
		return safetyzone;
	}
	static void comb(int start, int count) {
		if (count == 3) {
			//좌표 3개 뽑았다. 그러면 이거 좌표에 넣고, BFS
			int[][] temp = new int[N][M];
			for (int i = 0 ; i < N; i++) {
				temp[i] = Arrays.copyOf(origin[i], M);
			} //복사완료
			for (int i = 0 ; i < 3; i++) {
				temp[result[i][0]][result[i][1]] = 1; //벽을 세우기
			}
			//만든거를가지고 BFS
			int safetyzone = BFS(temp);
			max = Math.max(safetyzone, max);
			return;
		}
		for (int i = 0 ; i < input.size(); i++) {
			result[count] = input.get(i);
			comb(i+1,count+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		origin = new int[N][M];
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0 ; j < M ; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if (origin[i][j] == 0) {
					zerosum++;
					input.add(new int[] {i,j});
				}else if (origin[i][j] == 2) {
					start.add(new int[] {i,j});
				}
			}
		}
		comb(0,0);
		System.out.println(max);
		
		
		br.close();
	}
}
