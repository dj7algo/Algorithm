import java.util.*;
import java.io.*;
public class Main_bj_5014_스타트링크 {
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static boolean[] visited;
	static int min;
	//1. 혹시모르니까 부분집합으로 해볼까?
	//2. 안되네 ^-^ 그냥 BFS 쓰장
	static void BFS(int cur, int count) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited[cur] = true;
		q.offer(new int[] {cur, count});
		while(!q.isEmpty()) {
			int[] floor = q.poll();
			if (floor[0] == G) {
				min = Math.min(min, floor[1]);
			}
			int up  = floor[0]+U;
			int down = floor[0]-D;
			if (up >= 1 && up <= F && !visited[up]) {
				visited[up] = true;
				q.offer(new int[] {up , floor[1]+1});
			}
			if (down >= 1 && down <= F && !visited[down]) {
				visited[down] = true;
				q.offer(new int[] {down , floor[1]+1});
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// F : 층수 S: 강호의 층수 G : 목적지 U 몇번 올라가나 D 아래로버튼
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[F+1];
		min = Integer.MAX_VALUE;
		BFS(S,0);
		if (min == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		}else {
			System.out.println(min);
		}
		
		
		
		br.close();
	}
}
