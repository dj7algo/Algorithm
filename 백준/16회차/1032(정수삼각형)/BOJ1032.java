import java.io.*;
import java.util.*;
public class BOJ1032 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] rec = new int[N][N];

        for(int i =0 ; i < N ; i++) {
            Arrays.fill(rec[i], -1);
        }

        for(int i = 0 ;i  < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                rec[i][j] = Integer.parseInt(st.nextToken());
                if(!st.hasMoreTokens()) break;

            }
        }

        for(int i = N-2 ; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                rec[i][j] = Math.max(rec[i][j] + rec[i+1][j], rec[i][j] + rec[i+1][j+1]);
            }
        }

        System.out.println(rec[0][0]);
    }
}