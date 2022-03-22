import java.io.*;
import java.util.*;


public class BOJ14502 {
    static int[][] map = new int[9][9];
    static int[][] copy_map = new int[9][9];
    static int[][] spread_map = new int[9][9];
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int max_safe = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int safe = 0;

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copy_map[i][j] = map[i][j];
                if(map[i][j] == 0) safe++;
            }
        }

        makeWall(0, safe);
        System.out.println(max_safe);
    }

    static void makeWall(int cnt, int safe){
        if(cnt == 3){
            spreadVirus(safe);
            return;
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                if(copy_map[i][j] == 0){
                    copy_map[i][j] = 1;
                    makeWall(cnt+1, safe-1);
                    copy_map[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus(int safe){
        Queue<int[]> q = new LinkedList<>();
        for(int i =1 ;i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                spread_map[i][j] = copy_map[i][j];
                if(spread_map[i][j] == 2) q.add(new int[] {i, j});
            }
        }

        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();

            for(int k = 0 ; k < 4 ; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(0 < nr && nr <= N && 0 < nc && nc <= M && spread_map[nr][nc] == 0){
                    if(spread_map[nr][nc] == 0){
                        spread_map[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        safe--;
                    }
                }
            }
        }

        max_safe = Math.max(max_safe, safe);
    }
}