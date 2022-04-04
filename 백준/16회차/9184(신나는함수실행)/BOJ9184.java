import java.io.*;
import java.util.*;
public class BOJ9184 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][][] dp = new int[21][21][21];
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b == -1 && c==-1) break;
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c, dp)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int w(int a, int b, int c, int[][][] dp){

        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            return dp[20][20][20]=w(20, 20, 20, dp);
        }

        if(dp[a][b][c] != 0) return dp[a][b][c];

        if(a < b && b < c){
            return dp[a][b][c] = w(a, b, c-1, dp) + w(a, b-1, c-1, dp) - w(a, b-1, c, dp);
        }

        return dp[a][b][c] = w(a-1, b, c, dp) + w(a-1, b-1, c, dp) + w(a-1, b, c-1, dp) - w(a-1, b-1, c-1, dp);

    }
}