import java.util.*;
import java.io.*;
public class Main_bj_7569_토마토 {
	static int[][][] arr;
	static int C;
	static int R;
	static int H;
	
	static int dz[] = {0, 0, 0, 0, 1, -1}; // 상 하 좌 우 앞 뒤
	static int di[] = {-1, 1, 0, 0, 0, 0}; // 상 하 좌 우 앞 뒤
	static int dj[] = {0, 0, -1, 1, 0, 0}; // 상 하 좌 우 앞 뒤

	static int BFS(Queue<int[]> q, boolean[][][] visited) {
		int dayday = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			//육방탐색
			for (int a = 0 ; a < 6; a++) {
				int nz = cur[0] + dz[a];
				int ni = cur[1] + di[a];
				int nj = cur[2] + dj[a];
				if ( (nz >= 0) && (nz < H) && (ni >= 0) && (ni < R) && (nj >= 0) && (nj < C) && (!visited[nz][ni][nj]) && (arr[nz][ni][nj] == 0)) {
					arr[nz][ni][nj] = 1;
					visited[nz][ni][nj] = true;
					q.offer(new int[] {nz, ni, nj, (cur[3] + 1)});
				}
			}
			dayday = cur[3]; //마지막날짜
		}
		return dayday;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//위 ,  아래, 왼쪽, 오른쪽, 앞, 뒤 익어버려요 (6개)
		//빼박 BFS구만
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken()); //세로
		R = Integer.parseInt(st.nextToken()); //가로
		H = Integer.parseInt(st.nextToken()); //높이
		
		arr = new int[H][R][C];
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][][] visited = new boolean[H][R][C];
		for (int a = 0 ; a < H; a++) {
			for (int b = 0 ; b < R; b++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0 ; c < C; c++) {
					arr[a][b][c] = Integer.parseInt(st.nextToken());
					if (arr[a][b][c] == 1) {
						q.offer(new int[]{a, b, c, 0});
						visited[a][b][c] = true;
					}
				}
			}
		}

		
		int day = BFS(q,visited);
		boolean findzero = false;
		
//		for (int a = 0 ; a < H; a++) {
//			System.out.println(a + "층: ");
//			for (int b = 0 ; b < R; b++) {
//				for (int c = 0 ; c < C; c++) {
//					System.out.print(arr[a][b][c] + " ");
//				}
//				System.out.println();
//			}
//		}
		
		
		for (int a = 0 ; a < H; a++) {
			for (int b = 0 ; b < R; b++) {
				for (int c = 0 ; c < C; c++) {
					if (arr[a][b][c] == 0) {
						findzero = true;
						break;
					}
				}
			}
		}
		if (findzero) {
			System.out.println(-1);
		}else {
			System.out.println(day);
		}
		br.close();
	}
}
