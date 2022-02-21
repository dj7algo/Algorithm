import java.util.*;
import java.io.*;
public class BOJ14889 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] S = new int[N][N];
        boolean[] select = new boolean[N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N ; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0, select, N, S);
        System.out.println(min);
        br.close();
    }

    static void comb(int cnt, int start, boolean[] select, int N, int[][] S){
        if(cnt == N/2){
            int teamS = 0;
            int teamL = 0;

            int[] tS = new int[N/2];
            int[] tL = new int[N/2];

            int si = 0;
            int li = 0;
            for(int i = 0 ; i < N ; i++){
                if(select[i])
                    tS[si++] = i;
                else
                    tL[li++] = i;
            }

            for(int i = 0 ; i < N / 2 - 1 ; i++){
                for(int j = i ; j < N/2 ; j++){
                    teamS += S[tS[i]][tS[j]];
                    teamS += S[tS[j]][tS[i]];
                    teamL += S[tL[i]][tL[j]];
                    teamL += S[tL[j]][tL[i]];
                }
            }
            int dif = Math.abs(teamS - teamL);
            min = Math.min(min, dif);
            return;
        }


        for(int i = start ; i < N ; i++){
            select[i] = true;
            comb(cnt+1, i+1, select, N, S);
            select[i] = false;
        }
    }
}