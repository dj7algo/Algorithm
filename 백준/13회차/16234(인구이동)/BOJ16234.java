import java.io.*;
import java.util.*;
public class BOJ16234 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ;j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //연합 List 배열 -> 몇개의 연합이 존재할지 모르기때문에
        List<List<int[]>> unions = new LinkedList<>();
        boolean[][] visit = null;
        int time = 0;
        while(true){
            visit = new boolean[N][N];

            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!visit[i][j]) {
                        find(unions, ground, visit, i, j, N, L, R);
                    }
                }
            }

            if(unions.isEmpty()) break;

            for(int i = 0 ; i < unions.size() ; i++){
                List<int[]> union = unions.get(i);
                int sum = 0;
                for(int j = 0 ; j < union.size() ; j++){
                    sum += ground[union.get(j)[0]][union.get(j)[1]];
                }
                sum = sum / union.size();

                for(int j = 0 ; j < union.size() ; j++){
                    ground[union.get(j)[0]][union.get(j)[1]] = sum;
                }
            }

            unions.clear();
            time++;

        }

        System.out.println(time);
    }

    static void find(List<List<int[]>> unions, int[][] ground, boolean[][] visit, int si, int sj, int N, int L, int R){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {si, sj});
        visit[si][sj] = true;
        List<int[]> union = new LinkedList<>();
        union.add(new int[] {si, sj});



        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};


        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0 ; d < 4 ; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if(0 <= ni && ni < N && 0 <= nj && nj < N && !visit[ni][nj]){
                    int thr = Math.abs(ground[cur[0]][cur[1]] - ground[ni][nj]);
                    if(L <= thr && thr <= R){
                        q.offer(new int[] {ni, nj});
                        visit[ni][nj] = true;
                        union.add(new int[] {ni, nj});
                    }
                }
            }
        }

        if(union.size() > 1){
            unions.add(union);
        }

        return;
    }

}