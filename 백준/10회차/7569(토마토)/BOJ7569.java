import java.io.*;
import java.util.*;
public class BOJ7569 {
    static int count;
    static int[][][] tomato;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();
        count = H * N * M;


        for(int h = 0 ; h < H ; h++){
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < M ; j++){
                    tomato[h][i][j] = Integer.parseInt(st.nextToken());
                    if(tomato[h][i][j] == 1){
                        q.offer(new int[]{h, i, j});
                        count -= 1;
                    }
                    if(tomato[h][i][j] == -1) count -= 1;
                }
            }
        }

        int[] dh = {1, -1, 0, 0, 0, 0};
        int[] di = {0, 0, -1, 0, 1, 0};
        int[] dj = {0, 0, 0, 1, 0, -1};

        int[] current = null;
        while(!q.isEmpty()){
            current = q.poll();
            for(int d = 0 ; d < 6 ; d++){
                int nh = current[0] + dh[d];
                int ni = current[1] + di[d];
                int nj = current[2] + dj[d];
                if(0 <= nh && nh < H && 0 <= ni && ni < N && 0 <= nj && nj < M && tomato[nh][ni][nj] == 0){
                    tomato[nh][ni][nj] = tomato[current[0]][current[1]][current[2]] + 1;
                    count -= 1;
                    q.offer(new int[] {nh, ni, nj});
                }
            }
        }

        if(count == 0) System.out.println(tomato[current[0]][current[1]][current[2]] - 1);
        else System.out.println(-1);
    }
}