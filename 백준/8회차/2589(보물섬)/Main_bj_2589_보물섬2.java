package week8;
import java.util.*;
import java.io.*;
public class Main_bj_2589_보물섬2 {
	static char[][] arr;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int R;
	static int C;
	static int[] di = {-1,1,0,0}; //상하좌우
	static int[] dj = {0,0,-1,1};
	static int min;
	static int max;
	
	static void find(int i , int j, List<int[]> duo) {
		duo.add(new int[] {i,j}); //짝궁 추가
		visited[i][j] = true;
		for (int a = 0 ; a < 4 ; a++) {
			int ni = i + di[a];
			int nj = j + dj[a];
			if (ni >= 0 && ni < R && nj >= 0 && nj < C && !visited[ni][nj] && arr[ni][nj] == 'L') {
				find(ni,nj,duo);
			}
		}
	}
	
	static void BFS(int i , int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited2[i][j] = true;
		q.offer(new int [] {i,j,0});
		int lastcount = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int a = 0 ; a < 4; a++) {
				int ni = cur[0] + di[a];
				int nj = cur[1] + dj[a];
				if (ni >= 0 && ni < R && nj >= 0 && nj < C && !visited2[ni][nj] && arr[ni][nj] == 'L') {
					visited2[ni][nj]= true;
					q.offer(new int[] {ni, nj, cur[2]+1});
				}
			}
			lastcount = cur[2];
		}
		max = Math.max(max, lastcount);
	}
	
	/*static void dfs(int i , int j , int destX, int destY, int dist) {
		if (dist > min) {
			return;
		}
		if (i == destX && j == destY) {
			min = Math.min(min, dist);
		}
		visited2[i][j] = true;
		for (int a = 0 ; a < 4 ; a++) {
			int ni = i + di[a];
			int nj = j + dj[a];
			if (ni >= 0 && ni < R && nj >= 0 && nj < C && !visited2[ni][nj] && arr[ni][nj] == 'L') {
				dfs(ni,nj,destX,destY,dist+1);
			}
		}
		visited2[i][j] = false;
	}*/
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		int allland = 0;
		for (int i = 0 ; i < R; i++) {
			String line = br.readLine();
			for (int j = 0 ; j < C; j++) {
				arr[i][j] = line.charAt(j);
				if (arr[i][j] == 'L') {
					allland++;
				}else if (arr[i][j] == 'W') {
					visited[i][j] = true;
				}
			}
		}
		
		//짝기리 뭉치기
		max = Integer.MIN_VALUE;
		for (int i = 0 ; i < R; i++) {
			for (int j = 0 ; j < C; j++) {
				if (!visited[i][j]) {
//					System.out.println("짝꿍=============");
					List<int[]> duo = new ArrayList<int[]>();
					find(i,j,duo);
//					for(int[] ar : duo) {
//						System.out.println(Arrays.toString(ar));
//					}
					//짝궁 찾았으니까 BFS로 최단거리 찾기
					
					for (int a = 0 ; a < duo.size(); a++) {
						visited2 = new boolean[R][C];
						BFS(duo.get(a)[0],duo.get(a)[1]);
					}
					
				}
			}
		}
		System.out.println(max);
		
		
		
		/*
		//땅과 땅사이의 거리를 계산해서 가장 큰걸 찾는다.
		int Max = Integer.MIN_VALUE;
		for (int i = 0 ;i < land.size(); i++) {
			for (int j = i; j < land.size(); j++) {//내 뒤에꺼랑만 비교하면 된다.
				min = Integer.MAX_VALUE;
				dfs(land.get(i)[0],land.get(i)[1],land.get(j)[0],land.get(j)[1],0);
				if (min == Integer.MAX_VALUE) min = 0; //못가는 경우도있으니, 이경우는 0으로 친다.
				Max = Math.max(Max,min);
			}
		}
		System.out.println(Max); */
		
		
		
		
		
		br.close();
	}
}
