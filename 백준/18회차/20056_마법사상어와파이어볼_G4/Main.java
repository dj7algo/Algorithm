import java.io.*;
import java.util.*;
public class Main {
	static int n,m,k;
	static ArrayList<Node>map[][];
	static int dx [] = {-1,-1,0,1,1,1,0,-1};
	static int dy [] = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new ArrayList[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]= new ArrayList<>();
			}
		}
		
		
	
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[x-1][y-1].add(new Node(w, s, d)); 
		}
		
		while(k-->0) {
			move();
			divide();
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++){
				
				for(int k=0; k<map[i][j].size(); k++) {
					ans+=map[i][j].get(k).w;
				}
			}
		}
		System.out.println(ans);
	}
	public static void print() {
		System.out.println(">>>>>>>>>");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j].size() ==0) {
					System.out.print(0+" ");
				}
				else {
					System.out.print(map[i][j].size()+" ");
				}
			}
			System.out.println();
		}
	}
	public static void divide() {
		ArrayList<Node>tmp[][] = set();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ArrayList<Node>list = map[i][j];
				if(list.size() <2) {
					for(int k=0; k<list.size(); k++) {
						Node a = map[i][j].get(k);
						tmp[i][j].add(new Node(a.w, a.s, a.d));
					}
					continue;
				}
				
				boolean flag = true;
				
				if(list.get(0).d%2==0) {
					for(int k=1; k<list.size(); k++) {
						if(list.get(k).d%2!=0) flag = false;
					}
				}
				else {
					for(int k=1; k<list.size(); k++) {
						if(list.get(k).d%2==0) flag = false;
					}
				}
				int dir[] = new int[4];
				
				if(flag) {
					dir[0] = 0;
					dir[1] = 2;
					dir[2] = 4;
					dir[3] = 6;
				}
				else {
					dir[0] = 1;
					dir[1] = 3;
					dir[2] = 5;
					dir[3] = 7;
				}
				
				int cnt = list.size();
				int total_w = 0;
				int total_s = 0;
				for(Node a : list) {
					total_w+=a.w;
					total_s+=a.s;
				}
				if(total_w/5 ==0) continue;
				
				for(int k=0; k<4; k++) {
					int w = total_w/5;
					int s = total_s/cnt;
					tmp[i][j].add(new Node(w, s, dir[k]));
				}
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j].clear();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ArrayList<Node>list = tmp[i][j];
				
				for(int k=0; k<list.size(); k++) {
					Node a = list.get(k);
					map[i][j].add(new Node(a.w, a.s, a.d));
				}
			}
		}
		
	}
	public static void move() {
		ArrayList<Node>tmp[][] = set();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ArrayList<Node> list = map[i][j];
				
				if(list.size()==0) continue;
				
				for(Node a: list) {
					int step = (a.s)%n;
					int nx = i+(dx[a.d]*step);
					int ny = j+(dy[a.d]*step);
					nx = change(nx);
					ny = change(ny);
					tmp[nx][ny].add(new Node(a.w, a.s, a.d));
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j].clear();
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ArrayList<Node> list = tmp[i][j];
				for(Node a :list) {
					map[i][j].add(new Node(a.w, a.s, a.d));
				}
			}
		}
		
		
	}
	public static int change(int x) {
		if(x<0) return x+n;
		if(x>=n) return x-n;
		return x;
	}
	public static ArrayList<Node>[][] set(){
		ArrayList<Node>tmp[][];
		tmp = new ArrayList[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tmp[i][j]= new ArrayList<>(); 
			}
		}
		return tmp;
	}
}
class Node{
	int w,s,d;

	public Node(int w, int s, int d) {
		this.w = w;
		this.s = s;
		this.d = d;
	}
	
}
