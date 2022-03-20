import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	static int map[][];
	static boolean visited[][];
	static int dx [] = {0,0,1,-1};
	static int dy [] = {1,-1,0,0};
	static int max =0;
	static Node arr[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		arr = new Node[4];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[0] = new Node(i,j);
				visited[i][j] = true;
				dfs(1,i,j);
				visited[i][j] = false;
				another(i,j);
			}
		}
		System.out.println(max);
	}
	public static void another(int x ,int y) {
		
		int [] aX = {0,0,-1,0};
		int [] aY = {0,1,1,2};
		
		int [] bX = {0,1,1,1};
		int [] bY = {0,0,1,0};
		
		int [] cX = {0,0,1,0};
		int [] cY = {0,1,1,2};
		
		int [] dX = {0,1,1,2};
		int [] dY = {0,0,-1,0};
		
		
		
		ArrayList<Node>list = new ArrayList<>();
		for(int i=0; i<4; i++) {
			int nx = x+aX[i];
			int ny = y+aY[i];
			
			if(isRange(nx,ny)) {
				list.add(new Node(nx,ny));
			}
		}
		
		int tmp = 0;
		if(list.size() ==4) {
			for(int i=0; i<4; i++) {
				int nx = list.get(i).x;
				int ny = list.get(i).y;
				tmp+=map[nx][ny];
			}
			max = Math.max(max, tmp);
		}

		
		list.clear();
		for(int i=0; i<4; i++) {
			int nx = x+bX[i];
			int ny = y+bY[i];
			
			if(isRange(nx,ny)) {
				list.add(new Node(nx,ny));
			}
		}
		
		tmp = 0;
		if(list.size() ==4) {
			for(int i=0; i<4; i++) {
				int nx = list.get(i).x;
				int ny = list.get(i).y;
				tmp+=map[nx][ny];
			}
			max = Math.max(max, tmp);
		}
		
		list.clear();
		for(int i=0; i<4; i++) {
			int nx = x+cX[i];
			int ny = y+cY[i];
			
			if(isRange(nx,ny)) {
				list.add(new Node(nx,ny));
			}
		}
		
		tmp = 0;
		if(list.size() ==4) {
			for(int i=0; i<4; i++) {
				int nx = list.get(i).x;
				int ny = list.get(i).y;
				tmp+=map[nx][ny];
			}
			max = Math.max(max, tmp);
		}
		
		list.clear();
		for(int i=0; i<4; i++) {
			int nx = x+dX[i];
			int ny = y+dY[i];
			
			if(isRange(nx,ny)) {
				list.add(new Node(nx,ny));
			}
		}
		
		tmp = 0;
		if(list.size() ==4) {
			for(int i=0; i<4; i++) {
				int nx = list.get(i).x;
				int ny = list.get(i).y;
				tmp+=map[nx][ny];
			}
			max = Math.max(max, tmp);
		}
	}
	public static void dfs(int level, int x, int y) {
		if(level ==4) {
			int tmp = 0;
			for(int i=0; i<arr.length; i++) {
				Node a = arr[i];
				
				tmp+=map[a.x][a.y];
			}
			max = Math.max(max, tmp);
			return ;
		}
		
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(isRange(nx,ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				arr[level] = new Node(nx,ny);
				dfs(level+1,nx,ny);
				visited[nx][ny] = false;
			}
		}
		
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
