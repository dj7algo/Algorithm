import java.io.*;
import java.util.*;
public class BOJ14500 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        max = 0;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ;i < N ; i++){
            for(int j = 0 ; j < M ;j++){
                dfs(i, j, 0, 0);
                exception(i, j);
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int depth, int sum){
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            int ni = x + di[i];
            int nj = y + dj[i];

            if(0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]){
                visited[ni][nj] = true;
                dfs(ni, nj, depth+1, sum+arr[ni][nj]);
                visited[ni][nj] = false;
            }
        }
    }

    static void exception(int x, int y){
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = arr[x][y];

        for(int i = 0 ; i < 4 ; i++){
            int ni = x + di[i];
            int nj = y + dj[i];

            if(wing <= 2) return;
            if(ni < 0 || N <= ni || nj < 0 || M <= nj){
                wing--;
                continue;
            }
            min = Math.min(min, arr[ni][nj]);
            sum += arr[ni][nj];
        }

        if(wing == 4){
            sum = sum - min;
        }
        max= Math.max(max, sum);
    }
}