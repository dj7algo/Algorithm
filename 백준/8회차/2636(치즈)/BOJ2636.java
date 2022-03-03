import java.io.*;
import java.util.*;
public class BOJ2636 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] cheeses = new int[N][M];
        int cheese = 0;
        int hour = 0;
        int cheese_b1 = 0;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                cheeses[i][j] = Integer.parseInt(st.nextToken());
                if(cheeses[i][j] == 1){
                    cheese+=1;
                }
            }
        }


        while(cheese != 0){
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visit = new boolean[N][M];
            visit[0][0] = true;
            q.offer(new int[] {0, 0});
            cheese_b1 = cheese;
            while(!q.isEmpty()){
                int[] p = q.poll();
                for(int d = 0; d < 4 ; d++){
                    int ni = p[0] + di[d];
                    int nj = p[1] + dj[d];
                    if(0 <= ni && ni < N && 0 <= nj && nj < M && !visit[ni][nj]){
                        visit[ni][nj] = true;
                        if(cheeses[ni][nj]==1) {
                            cheeses[ni][nj] = 0;
                            cheese--;
                        }else{
                            q.offer(new int[]{ni, nj});
                        }
                    }
                }
            }
            hour++;
        }
        System.out.println(hour + "\n" + cheese_b1);
    }
}