import java.io.*;
import java.util.*;
public class Main {
	static int n,m,k;
	static Node map[][];
	static Shark shark[];
	static int dx []= {100,-1,1,0,0};
	static int dy [] = {100,0,0,-1,1};
	static int priority[][][];
	static int end = 0;
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		priority = new int[m+1][5][5];
		map = new Node[n][n];
		shark = new Shark[m+1];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = new Node(0, 0); 
			}
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num!=0) {
					shark[num] = new Shark(i, j, 0,true);
					map[i][j] = new Node(k, num);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=m; i++) {
			shark[i].dir = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=1; k<=4; k++) {
					priority[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		
		
		
		while(end != m-1) {
			if(ans==1001) {
				System.out.println(-1);
				System.exit(0);
			}
			ans++;
			// 상어들이 들어갈 칸에 대한 정보를 담는 리스트
			ArrayList<Info> list = new ArrayList<>();
			
			for(int i=1; i<=m; i++) {
				Shark a = shark[i];
				if(!a.flag) continue;	// 죽은 상어
				
				boolean bl = true;
				
				// 1. 아무 냄새가 없는 방향 찾아보기
				for(int j=1; j<=4; j++) {
					int dir = priority[i][a.dir][j];
					int nx = a.x+dx[dir];
					int ny = a.y+dy[dir];
					
					if(!isRange(nx, ny)) continue;
					// 냄새가 없는 칸
					if(map[nx][ny].cnt==0) {
						list.add(new Info(nx, ny, i,dir));
						bl = false;
						break;
					}
				}
				// 냄새가 없는 칸을 못찾았을 경우
				if(bl) {
					for(int j=1; j<=4; j++) {
						int dir = priority[i][a.dir][j];
						int nx = a.x+dx[dir];
						int ny = a.y+dy[dir];
						if(!isRange(nx, ny)) continue;
						
						// 자기 자신 냄새 있는 칸
						if(map[nx][ny].num ==i) {
							list.add(new Info(nx, ny, i,dir));
							break;
						}
					}
				}
			}
			
			
			// 상어 이동
			
			for(int i=0; i<list.size(); i++) {
				Info a = list.get(i);
				
				int x = a.x;
				int y = a.y;
				int dir = a.dir;
				int shark_num = a.num;
				// 해당 칸에 상어가 없는 경우
				if(map[x][y].num ==0) {
					map[x][y] = new Node(k+1, shark_num);
					shark[shark_num].x = x;
					shark[shark_num].y = y;
					shark[shark_num].dir = dir;
				}
				// 해당 칸에 상어가 있는 경우
				else {
					// 내가 잡아 먹히는 경우
					if(map[x][y].num < shark_num) {
						shark[shark_num].flag = false;
						end++;
					}
					// 내가 잡아 먹는 경우
					if(map[x][y].num > shark_num){
						map[x][y] = new Node(k+1, shark_num);
						// 잡아 먹힌 상어 죽음 처리
						shark[map[x][y].num].flag = false;
						
						shark[shark_num].x = x;
						shark[shark_num].y = y;
						shark[shark_num].dir = dir;
						end++;
					}
					if(map[x][y].num == shark_num) {
						map[x][y] = new Node(k+1, shark_num);
						shark[shark_num].x = x;
						shark[shark_num].y = y;
						shark[shark_num].dir = dir;
						
					}
				}
			}
			
			// 냄새 -1
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j].cnt==0) continue;
					if(map[i][j].cnt ==1) {
						map[i][j] = new Node(0, 0);
					}
					else {
						map[i][j].cnt--;
					}
				}
			}
		}
		System.out.println(ans);
	}
	public static void print() {
		System.out.println(">>>>>>>>>>>>");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j].num+" ");
			}
			System.out.println();
		}
	}
	public static boolean isRange(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<n) return true;
		return false;
	}
}
class Node{
	int cnt,num;
	public Node(int cnt, int num) {
		this.cnt = cnt;
		this.num = num;
	}
}
class Shark{
	int x,y,dir;
	boolean flag;
	public Shark(int x, int y, int dir,boolean flag) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.flag = flag;
	}
}
class Info{
	int x,y,num,dir;
	public Info(int x, int y, int num, int dir) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.dir = dir;
	}
	
}