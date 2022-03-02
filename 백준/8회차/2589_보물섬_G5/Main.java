import java.util.*;
import java.io.*;

class Main{
	static int n,m;
	static char map[][];
	static boolean visited[][];
	static int dx [] = {0,0,1,-1};
	static int dy [] = {1,-1,0,0};
	static int max = 0;
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 'L') bfs(i,j);
			}
		}
		
		
		System.out.println(max);
	
	}
	public static void bfs(int x, int y) {
		visited = new boolean[n][m];
		Queue<Node> q= new LinkedList<>();
		q.add(new Node(x,y,0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node a=  q.poll();
			max = Math.max(max, a.dist);
			
			for(int i=0; i<4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
				
				if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny]=='L') {
					q.add(new Node(nx,ny,a.dist+1));
					visited[nx][ny] = true;
				}
						
			}
		}
	}
	public static boolean isRange(int x,int y) {
		if(x>=0 && y>=0 && x<n && y<m) return true;
		return false;
	}
}
class Node{
	int x,y,dist;

	public Node(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist=dist;
	}
}