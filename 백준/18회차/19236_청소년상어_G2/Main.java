import java.io.*;
import java.util.*;
public class Main {
	static int dx [] = {10000,-1,-1,0,1,1,1,0,-1};
	static int dy [] = {10000,0,-1,-1,-1,0,1,1,1};
	static int map[][];
	static Node fish[];
	static Node shark;
	static final int SHARK = -1;
	static int max = 0;
	
	static int test = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		fish = new Node[17];
		
		map = new int[4][4];
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int fishNum = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j]= fishNum;
				fish[fishNum] = new Node(i, j, dir,true);
				
			}
		}
		
		int eatFishNum = map[0][0];	// 맨 처음 상어한테 잡아먹힐 물고기
		map[0][0] = SHARK;
		fish[eatFishNum].flag = false;
		
		dfs(0, 0, fish[eatFishNum].dir,eatFishNum);
		System.out.println(max);
		
	}
	public static void print() {
		System.out.println(">>>>>>>>>>>>>");
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int x, int y,int dir,int sum) {
		max = Math.max(max, sum);
		int copy_map[][] = copyMap();
		Node copy_fish[] = copyFish();
		
		move_fish();
		int nx = x;
		int ny = y;
		
		while(isRange(nx, ny)) {
			if(map[nx][ny]==0 || map[nx][ny]==SHARK) {
				nx+=dx[dir];
				ny+=dy[dir];
				continue;
			}
			int eat_fish = map[nx][ny];
			map[x][y]= 0; 
			map[nx][ny] = SHARK;
			fish[eat_fish].flag = false;
			
			dfs(nx,ny,fish[eat_fish].dir,sum+eat_fish);
			// 되돌리기
			map[nx][ny] = eat_fish;
			fish[eat_fish].flag = true;
			map[x][y]= SHARK; 
			nx+=dx[dir];
			ny+=dy[dir];
		}
		rollback_fish(copy_map,copy_fish);
	}
	public static Node[] copyFish() {
		Node [] copyFish = new Node[17];
		
		for(int i=1; i<=16; i++) {
			Node a=  fish[i];
			copyFish[i] = new Node(a.x, a.y, a.dir,a.flag);
		}
		return copyFish;
	}
	public static void rollback_fish(int [][] copy_map, Node[] copy_fish) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				map[i][j] = copy_map[i][j]; 
			}
		}
		
		for(int i=1; i<=16; i++) {
			Node a = copy_fish[i];
			fish[i] = new Node(a.x, a.y, a.dir,a.flag);
		}
		
	}
	public static int[][] copyMap() {
		int [][] copy_map = new int[4][4];
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				copy_map[i][j]= map[i][j];  
			}
		}
		return copy_map;
	}
	public static void move_fish() {
		for(int i=1; i<=16; i++) {
			Node a = fish[i];
			if(!a.flag) {
				continue;		// 잡아먹힌 물고기
			}
			int dir = a.dir;
			for(int j=1; j<=8; j++) {
				// 8방향으로 이동 가능한 곳 찾기
				int nx = a.x+dx[dir];
				int ny = a.y+dy[dir];
				
				// 범위 밖으로 벗어나는 경우
				if(!isRange(nx, ny)) {
					dir = change_dir(dir);
				}
				
				// 해당칸에 상어가 있는 경우
				else if(map[nx][ny]==SHARK) {
					dir = change_dir(dir);
				}
				
				// 빈칸 인 경우
				else if(map[nx][ny]==0) {
					map[nx][ny]= i;
					map[a.x][a.y] = 0;
					fish[i] = new Node(nx, ny, dir,a.flag);
					break;
				}
				// 해당 칸에 물고기가 있는 경우
				else {
					int originFishNum = map[nx][ny];	// 원래 칸에 있던 물고기
					
					// 물고기 위치부터 바꾸기
					Node origin = fish[originFishNum];
					int origin_dir = origin.dir;
					
					fish[i] = new Node(nx, ny, dir,a.flag);
					fish[originFishNum] = new Node(a.x, a.y, origin_dir,origin.flag);
					
					
					map[a.x][a.y] = originFishNum;
					map[nx][ny] = i;
					break;
				}
			}
		}
	}
	public static int change_dir(int dir) {
		dir++;
		if(dir==9) return 1;
		return dir;
	}
	public static boolean isRange(int x, int y) {
		if(x>=0 && y>=0 && x<4 && y<4) return true;
		return false;
			
	}
}
class Node{
	int x,y,dir;
	boolean flag;
	public Node(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Node(int x, int y, int dir,boolean flag) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.flag = flag;
	}
	
}
