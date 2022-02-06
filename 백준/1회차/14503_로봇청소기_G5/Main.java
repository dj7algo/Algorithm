import java.io.*;
import java.util.*;
public class Main {
	static int map[][];
	static boolean visited[][];
	static int n,m;
	static int dx[] = {-1,0,1,0};
	static int dy [] = {0,1,0,-1};
	static Node robot;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
			
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] t = br.readLine().split(" ");
		
		n = Integer.parseInt(t[0]);
		m = Integer.parseInt(t[1]);
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		t = br.readLine().split(" ");
		robot = new Node(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]));
		
		for(int i=0; i<n; i++) {
			t = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(t[j]);
			}
		}
		// input end
		clean();
		System.out.println(ans);
	}
	
	// 1. 현재 위치를 청소
	public static void clean() {
		visited[robot.x][robot.y] = true;
		ans++;
		dfs();
	}
	public static void dfs() {
		
		//2. 현재위치에서 현재 방향을 기준으로 왼쪽 방향부터 탐색
		// a. 왼쪽 방향에 아직청소하지 않은 공간이 존재한다면 그 방향으로 회전 후 1번부터
		int tmp_dir = robot.dir;
		
		for(int i=0; i<4; i++) {	// b 왼쪽에 청소할공간이 없다면 2번으로 돌아간다
			tmp_dir = change_dir(tmp_dir);
			int nx = robot.x+dx[tmp_dir];
			int ny = robot.y+dy[tmp_dir];
			
			if(isRange(nx,ny) && map[nx][ny]==0 && !visited[nx][ny]) {
				robot.x= nx;
				robot.y= ny;
				robot.dir = tmp_dir;
				visited[robot.x][robot.y] = true;
				ans++;
				dfs();
				return;
			}
		}

			if(backMove()) {
				dfs();
			}
			else {
				System.out.println(ans);
				System.exit(0);
			}
		
		
	}
	public static boolean backMove() {
		int nx=0;
		int ny=0;
		
		switch (robot.dir) {
		case 0:
			// 북쪽방향에서 후진해야 하니 남쪽으로 한칸
			nx = robot.x+1;
			ny = robot.y;
			if(isRange(nx,ny) && map[nx][ny]!=1) {
				robot.x = nx;
				return true;
			}
			return false;
		case 1:
			// 동쪽방향에서 후진해야 하니 서쪽으로 한칸
			nx = robot.x;
			ny = robot.y-1;
			if(isRange(nx,ny) && map[nx][ny]!=1) {
				robot.y = ny;
				return true;
			}
			return false;
		case 2:
			// 남쪽방향에서 후진해야하니 북쪽으로 한칸
			nx = robot.x-1;
			ny = robot.y;
			if(isRange(nx,ny) && map[nx][ny]!=1) {
				robot.x = nx;
				return true;
			}
			return false;
		case 3:
			// 서쪽방향에서 후진해야하니 동쪽으로 ㅎ나칸
			nx = robot.x;
			ny = robot.y+1;
			if(isRange(nx,ny) && map[nx][ny]!=1) {
				robot.y = ny;
				return true;
			}
			return false;
		}
		return false;
	}
	public static int change_dir(int dir) {
		dir--;
		if(dir==-1) return 3;
		return dir;
	}
	public static boolean isRange(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<m) return true;
		return false;
	}
 }
class Node{
	int x,y,dir;
	Node(int x, int y, int dir){
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
}