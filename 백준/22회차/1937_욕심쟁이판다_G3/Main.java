import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int max = 0;
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static int map[][];
    static int dp[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dfs(i,j);
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                max = Math.max(max,dp[i][j]);
            }
        }

        System.out.println(max);
    }
    public static int dfs(int x, int y){

        if(dp[x][y]!=0) return dp[x][y];
        dp[x][y] = 1;
        int cnt = 1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isRange(nx,ny) && map[nx][ny] > map[x][y]){
                dp[x][y] = Math.max(dp[x][y],dfs(nx,ny)+1);
            }
        }

        return dp[x][y];
    }

    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=n && y<=n) return  true;
        return false;
    }
}
