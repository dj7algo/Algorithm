import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int n,k,l;
	static int map[][];
	static int dx [] = {-1,0,1,0};    // 위 오른쪽 아래 왼쪽
	static int dy [] = {0,1,0,-1};
	
	
	static int ans = 0;
	static ArrayList<Node>list = new ArrayList<>();
	
	static boolean visited[][];
	
	// 뱀의 정보
	static ArrayList<Snake>snake = new ArrayList<>();
	static int snake_dir = 1;
	public static void main(String [] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		map = new int [n+1][n+1];
		
		visited = new boolean[n+1][n+1]; 	// 뱀의 위치정보를 저장할 배열
		visited[1][1] =true;
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;
		}
		snake.add(new Snake(1, 1));
		l = Integer.parseInt(br.readLine());
		
		for(int i=0; i<l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());	 // time 초 후에 이동
			String dir = st.nextToken();	
			list.add(new Node(time,dir));
		}
		
		while(true) {
			ans++;
			
			int size = snake.size()-1;
			
			int x = snake.get(size).x;
			int y = snake.get(size).y;

			// 현재 진행방향으로 한칸 전진
			int nx = x+dx[snake_dir];
			int ny = y+dy[snake_dir];
			
			// 종료조건 , 범위 벗어나거나 뱀의 몸 부딪히는경우
			if(!isRange(nx,ny) || visited[nx][ny]) {
				System.out.println(ans);
				return;
			}
			
			// 뱀은 먼저 몸길이를 늘려 머리를 다음칸에 위치
			visited[nx][ny] = true;
			snake.add(new Snake(nx,ny));
			
			// 이동한 칸에 사과가 있는 경우, 사과만 없애고 꼬리는 움직이지 않는다
			if(map[nx][ny]==1) {
				map[nx][ny] = 0;
			}
			else {
				Snake tail = snake.remove(0);
				visited[tail.x][tail.y] = false;
			}
			
			if(list.size()>0 && ans == list.get(0).time) {
				Node tmp = list.remove(0);
				change_dir(tmp.dir);
			}
			
			
		}
			
	}
	public static void change_dir(String order) {
		if(order.equals("L")) {
			snake_dir--;
			
			if(snake_dir==-1) snake_dir=3;
		}
		else {
			snake_dir = (snake_dir+1)%4;
		}
	}
	public static boolean isRange(int x, int y) {
		if(x>=1 && y>=1 && x<=n && y<=n) return true;
		return false;
	}
	
}
class Node{
	int time;
	String dir;
	
	public Node(int time, String dir) {
		this.time = time;
		this.dir = dir;
	}
}
class Snake{
	int x,y;

	public Snake(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}


