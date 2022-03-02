import java.util.*;
import java.io.*;

class Main{
	static int n,m;
	static int map[][];
	static int dx [] = {0,0,1,-1};
	static int dy [] = {1,-1,0,0};
	static boolean visited[][];
	static ArrayList<Node>list = new ArrayList<>();
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time =0;
		int cheese_cnt = 0;
		
		
		while(isPossible()) {
			cheese_cnt = get_cnt();
			time++;
			visited = new boolean[n][m];
			list.clear();
		
			bfs();
	
			for(Node a : list) {
				map[a.x][a.y] =0;
			}
		}
		
		System.out.println(time);
		System.out.println(cheese_cnt);
		
	}
	public static int get_cnt() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1) cnt++;
			}
		}
		return cnt;
	}
	public static void print() {
		System.out.println("==========");
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		visited = new boolean[n][m];
		q.add(new Node(0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node a = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
				
				if(isRange(nx,ny) && !visited[nx][ny]) {
					if(map[nx][ny]==0) {
						q.add(new Node(nx,ny));
						visited[nx][ny] = true;	
					}
					else {
						list.add(new Node(nx,ny));
					}
				}
			}
			
			
			
		}
	}
	public static boolean isPossible() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1) return true;
			}
		}
		return false;
	}
	public static boolean isRange(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<m) return true;
		return false;
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