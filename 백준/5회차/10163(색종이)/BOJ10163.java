import java.io.*;
import java.util.*;
public class BOJ10163 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[1001][1001];

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startJ = Integer.parseInt(st.nextToken());
            int startI = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for(int i = startI ; i < startI+height ; i++) {
                for (int j = startJ; j < startJ+width; j++) {
                    board[i][j] = t;
                }
            }
        }
        int[] count = new int[T + 1];
        for(int i = 0; i < 1001; i++){
            for(int j = 0; j < 1001 ; j++){
                for(int t = 1 ; t <= T ; t++){
                    if(board[i][j] == t) count[t]++;
                }
            }
        }

        for(int i = 1 ; i < count.length ; i++){
            System.out.println(count[i]);
        }
    }
}
