import java.io.*;
import java.util.*;

class Main{
	static int map[][];
	static int n,l,r;
	static int dx [] = {0,0,1,-1};
	static int dy [] = {1,-1,0,0};
	static boolean visited[][];
	static boolean flag = false;
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while(true) {
			visited = new boolean[n][n];
			flag = false;
			for(int i=0;i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
					
				}
			}
			

			
			if(!flag) break;
			day++;
		}
		System.out.println(day);
	}
	public static void bfs(int x, int y) {
		Queue<Node>q = new LinkedList<>();
		ArrayList<Node>list = new ArrayList<>();
		q.add(new Node(x,y));
		visited[x][y] = true;
		list.add(new Node(x,y));
		while(!q.isEmpty()) {
			Node a=  q.poll();
			for(int i=0; i<4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
				
				if(isRange(nx,ny) && !visited[nx][ny]) {
					int diff = Math.abs(map[a.x][a.y] - map[nx][ny]);	// 두 국경사이의 인구차
					if(diff>=l && diff<=r) {
						flag = true;
						visited[nx][ny] = true;
						q.add(new Node(nx,ny));
						list.add(new Node(nx,ny));
					}
				}
			}
		}
		
		if(list.size() > 1) {
			
			int sum = 0;
			for(int i=0; i<list.size(); i++) {
				Node a = list.get(i);
				sum+=map[a.x][a.y];
			}
			
			sum/=list.size();
			for(int i=0; i<list.size(); i++) {
				Node a = list.get(i);
				map[a.x][a.y] = sum; 
			}
		}
		
	}
	public static boolean isRange(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<n) return true;
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
