import java.io.*;
import java.util.*;
public class BOJ1520 {
    static int counts = 0;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //bfs(map, M, N);
        dfs(map, new boolean[M][N], 0,0, M, N);
        System.out.println(counts);
    }

    static void dfs(int[][] map, boolean[][] visited, int i, int j, int M, int N){
        if(i == M-1 && j == N-1){
            counts++;
            return;
        }
        for(int d = 0; d < 4 ; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            if(0 <= ni && ni < M && 0 <= nj && nj < N && map[ni][nj] < map[i][j]){
                dfs(map, visited, ni, nj, M, N);
            }
        }
    }

    static void bfs(int[][] map, int M, int N){
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == M-1 && cur[1] == N-1){
                counts++;
                continue;
            }
            int count = 0;
            for(int d = 0 ; d < 4 ; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(0 <= ni && ni < M && 0 <= nj && nj < N && map[cur[0]][cur[1]] > map[ni][nj]){
                    if(count == 0){
                        q.add(new int[]{ni, nj});
                    }else{
                        q.add(new int[]{ni, nj});
                    }
                    count++;
                }
            }
        }

    }
}