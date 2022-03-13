package week11;
import java.util.*;
import java.io.*;
public class Main_bj_3085_사탕게임 {
	static int N;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static int max = Integer.MIN_VALUE;
	static void BFS(char[][] map, int startX, int startY) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][N];
		visited[startX][startY] = true;
		q.offer(new int[] {startX, startY});
		int eating = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			eating++;
			for (int i = 0 ; i < 2; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj] && map[cur[0]][cur[1]] == map[ni][nj]) {
					visited[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
		max = Math.max(max, eating);
		
		q = new ArrayDeque<int[]>();
		visited = new boolean[N][N];
		visited[startX][startY] = true;
		q.offer(new int[] {startX, startY});
		eating = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			eating++;
			for (int i = 2 ; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj] && map[cur[0]][cur[1]] == map[ni][nj]) {
					visited[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
		max = Math.max(max, eating);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		for (int i = 0 ; i < N; i++) {
			String line = br.readLine();
			for (int j = 0 ; j < N; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0 ; i < N; i++) { //왼쪽과 오른쪽 교환 후 BFS
			for (int j = 0 ;j < N-1; j++) {
				//바꾸기 전 BFS
				BFS(arr, i, j);
				//바꾸고 난 후 BFS
				char temp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
				BFS(arr, i, j);
				BFS(arr, i, j+1);
				//다시 되돌리고 다음턴으로
				temp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
			}
		}
		
		for (int i = 0 ; i < N-1; i++) { //왼쪽과 오른쪽 교환 후 BFS
			for (int j = 0 ;j < N; j++) {
				//바꾸기 전 BFS
				BFS(arr, i, j);
				//바꾸고 난 후 BFS
				char temp = arr[i][j];
				arr[i][j] = arr[i+1][j];
				arr[i+1][j] = temp;
				BFS(arr, i, j);
				BFS(arr, i+1, j);
				//다시 되돌리고 다음턴으로
				temp = arr[i][j];
				arr[i][j] = arr[i+1][j];
				arr[i+1][j] = temp;
			}
		}
		System.out.println(max);
		br.close();
	}
}
