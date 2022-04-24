import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int map[][];
	static int x,y,dir,step;
	static int dx [] = {0,1,0,-1};
	static int dy [] = {-1,0,1,0};
	static int oneX[][] = {{-1,1},{-1,-1},{-1,1},{1,1} };
	static int oneY[][] = {{1,1},{-1,1},{-1,-1},{-1,1} };
	static int twoX[][] = {{-2,2},{0,0},{-2,2},{0,0} };
	static int twoY[][] = {{0,0},{-2,2},{0,0},{-2,2} };
	static int fiveX[][] = {{0},{2},{0},{-2} };
	static int fiveY[][] = {{-2},{0},{2},{0} };
	static int sevenX[][] = {{-1,1},{0,0},{-1,1},{0,0} };
	static int sevenY[][] = {{0,0},{-1,1},{0,0},{-1,1} };
	static int tenX[][] = {{-1,1},{1,1},{-1,1},{-1,-1} };
	static int tenY[][] = {{-1,-1},{-1,1},{1,1},{-1,1} };
	static int aX [][] = {{0}, {1}, {0}, {-1} };
	static int aY [][] = {{-1}, {0}, {1}, {0} };
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		x = n/2+1;
		y = n/2+1;
		dir = 0;
		step = 1;
		
		int dir_cnt = 0;	// 방향전환 몇번 했는지
		loop:while(true) {
			for(int i=0; i<step; i++) {
				x+=dx[dir];
				y+=dy[dir];
				move(dir, x, y);
				if(x==1 && y==1) {
					break loop;
				}
			}
			dir_cnt++;
			dir++;
			if(dir==4) dir=0;
			if(dir_cnt==2) {
				step ++;
				dir_cnt = 0;
			}
		}
		System.out.println(ans);
	}
	public static void move(int dir ,int x,int y) {
		
		int sum = 0;
		int sand = map[x][y];
		
		
		// 1%먼저
		
		for(int i=0; i<oneX[0].length; i++) {
			int nx = x+oneX[dir][i];
			int ny = y+oneY[dir][i];
			
			int divide = (int) (sand*0.01);
			sum+=divide;
			if(isRange(nx, ny)) map[nx][ny]+=divide;
			else ans+=divide;
		}
		
		// 2%
		for(int i=0; i<twoX[0].length; i++) {
			int nx = x+twoX[dir][i];
			int ny = y+twoY[dir][i];
			
			int divide = (int) (sand*0.02);
			sum+=divide;
			
			if(isRange(nx, ny)) map[nx][ny]+=divide;
			else ans+=divide;
		}
		
		// 5%
		for(int i=0; i<fiveX[0].length; i++) {
			int nx = x+fiveX[dir][i];
			int ny = y+fiveY[dir][i];
			
			int divide = (int) (sand*0.05);
			sum+=divide;
			
			if(isRange(nx, ny)) map[nx][ny]+=divide;
			else ans+=divide;
		}
		
		// 7%
		
		for(int i=0; i<sevenX[0].length; i++) {
			int nx = x+sevenX[dir][i];
			int ny = y+sevenY[dir][i];
			
			int divide = (int) (sand*0.07);
			sum+=divide;
			
			if(isRange(nx, ny)) map[nx][ny]+=divide;
			else ans+=divide;
		}
		
		// 10%
		
		for(int i=0; i<tenX[0].length; i++) {
			int nx = x+tenX[dir][i];
			int ny = y+tenY[dir][i];
			
			int divide = (int) (sand*0.1);
			sum+=divide;
			
			if(isRange(nx, ny)) map[nx][ny]+=divide;
			else ans+=divide;
		}
		
		map[x][y]= 0;
		int nx = x+aX[dir][0];
		int ny = y+aY[dir][0];
		
		if(isRange(nx, ny)) {
			map[nx][ny] += sand-sum;
		}
		else ans+=(sand-sum);
	}
	public static boolean isRange(int x, int y) {
		if(x>=1 && y>=1 && x<=n && y<=n) return true;
		return false;
	}
}