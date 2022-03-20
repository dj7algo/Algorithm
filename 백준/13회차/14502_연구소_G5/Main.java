import java.io.*;
import java.util.*;

class Main{
	
	static int map[][];
	static boolean visited[][];
	static int n,m;
	static Node arr[];
	static int dx [] = {0,0,1,-1};
	static int dy [] = {1,-1,0,0};
	static int max = 0;
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		

	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		arr = new Node[3];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		permutation(0);
		System.out.println(max);
	}
	public static boolean isRange(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<m) return true;
		return false;
	}
	public static int bfs(int [][] copy_map) {
		boolean bfs_visited[][] = new boolean[n][m];
		
		Queue<Node> q = new LinkedList<>();
		
//		System.out.println("===========");
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(copy_map[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy_map[i][j]==2) {
					q.add(new Node(i,j));
					bfs_visited[i][j] = true;
				}
			}
		}
		while(!q.isEmpty()) {
			Node a = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
				
				if(isRange(nx,ny) && !bfs_visited[nx][ny] && copy_map[nx][ny] ==0) {
					q.add(new Node(nx,ny));
					bfs_visited[nx][ny] = true;
					copy_map[nx][ny] = 2;
				}
			}
		}
		int ret = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy_map[i][j] ==0) ret++;
			}
		}
		
		return ret;
	}
	public static void permutation(int level) {
		if(level == 3) {
			
			int copy_map[][] = copy();
			max = Math.max(max,bfs(copy_map));
			
			
			return ;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visited[i][j] || map[i][j]!=0) continue;
				visited[i][j] = true;
				arr[level] = new Node(i,j);
				permutation(level+1);
				visited[i][j] = false;
			}
		}
		
		
		
	}
	public static int[][] copy() {
		
		int [][] copy_map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy_map[i][j] = map[i][j];
			}
		}

		for(int i=0; i<3; i++) {
			Node a = arr[i];
			copy_map[a.x][a.y] = 1;
		}
		return copy_map;
	}
}
class Node{
	int x,y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}