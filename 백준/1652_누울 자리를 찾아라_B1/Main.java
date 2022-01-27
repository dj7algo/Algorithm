import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static boolean visited[][];
	static String map[][];
	static int garo_cnt = 0;
	static int sero_cnt = 0;
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new String[n][n];
		
		
		for(int i=0; i<n; i++) {
			String [] input = br.readLine().split("");
			for(int j=0; j<n; j++) {
				map[i][j] = input[j];
			}
		}
		
		for(int i=0; i<n; i++) {
			visited = new boolean[n][n];
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j].equals(".") && isRange(j+1) && map[i][j+1].equals(".")) {
					bfs(i,j,true);
				}
			}
		}
		
		
		for(int j=0; j<n; j++) {
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				if(!visited[i][j] && map[i][j].equals(".") && isRange(i+1) && map[i+1][j].equals(".")) {
					bfs(i,j,false);
				}
			}
		}
		
		System.out.println(garo_cnt+" "+sero_cnt);
		
	}
	public static void bfs(int x, int y, boolean flag) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visited[x][y] =true;
		// 가로방향 탐색
		if(flag) {
			while(!q.isEmpty()) {
				Node a = q.poll();
				int nx = a.x;
				int ny = a.y+1;
				
				if(isRange(ny) && map[nx][ny].equals(".") && !visited[nx][ny]) {
					q.add(new Node(nx,ny));
					visited[nx][ny] = true;
				}
			}
			garo_cnt++;
		}
		// 세로방향 탐색
		else {
			while(!q.isEmpty()) {
				Node a = q.poll();
				int nx = a.x+1;
				int ny = a.y;
				
				if(isRange(nx) && map[nx][ny].equals(".") && !visited[nx][ny]) {
					q.add(new Node(nx,ny));
					visited[nx][ny] = true;
				}
			}
			sero_cnt++;
		}
	}
	public static boolean isRange(int x) {
		if(x>0 && x<n ) return true;
		return false;
	}
}
class Node{
	int x,y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}