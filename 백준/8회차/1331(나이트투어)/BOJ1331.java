import java.io.*;
import java.util.*;
public class BOJ1331 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] di = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dj = {-1, 1, -2, 2, -2, 2, -1, 1};
        int[][] moves = new int[37][2];
        for(int i = 0 ; i < 36 ; i++){
            String move = br.readLine();
            moves[i][0] = move.charAt(0) - 'A';
            moves[i][1] = move.charAt(1) - '1';
        }
        moves[36] = moves[0];

        int idx = 0;
        boolean[][] visit = new boolean[6][6];

        while(idx < 36){
            int[] cur = moves[idx];
            int[] next = moves[idx+1];

            visit[cur[0]][cur[1]] = true;
            int dif_x = cur[0] - next[0];
            int dif_y = cur[1] - next[1];
            boolean isPos = false;
            for(int d = 0 ; d < 8 ; d++){
                if(di[d] == dif_x && dj[d] == dif_y){
                    isPos = true;
                    break;
                }
            }

            if(!isPos){
                System.out.println("Invalid");
                return;
            }
            if(visit[next[0]][next[1]] && idx != 35){
                System.out.println("Invalid");
                return;
            }
            idx++;
        }

        System.out.println("Valid");
    }
}