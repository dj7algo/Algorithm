import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	static int dp[][];
	static int map[][];
	static int dx [] = {0,0,1,-1};
	static int dy [] = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int [n][m];
        dp = new int[n][m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        // dp[x][y]  x,y좌표에서 목적지까지 갈 수 있는 경우의 수
        for(int i=0; i<n; i++) {
        	Arrays.fill(dp[i], -1);
        }
        

        System.out.println(dfs(0,0));
        

	}
	public static int dfs(int x, int y) {
		if(x== n-1 && y == m-1) {
			return 1;	// 목적지에 도착 경우의 수 
		}
		
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(isRange(nx,ny) && map[x][y] > map[nx][ny]) {
				dp[x][y] += dfs(nx,ny);
			}
		}
		return dp[x][y];
	}
	public static boolean isRange(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<m) return true;
		return false;
	}
}
