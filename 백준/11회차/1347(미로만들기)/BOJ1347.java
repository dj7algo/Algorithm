package BaekJoon;
import java.io.*;
import java.util.*;
public class BOJ1347 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int row = 1, col = 1;
        char[][] board = new char[101][101];
        for(int i =0 ; i < board.length ; i++){
            Arrays.fill(board[i], '#');
        }

        int[] start = {50, 50};
        int[] min = {50, 50};
        int[] max = {50, 50};

        int d = 2;

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        board[start[0]][start[1]] = '.';

        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == 'F') {
                start[0] += di[d];
                start[1] += dj[d];
                board[start[0]][start[1]] = '.';
                max[0] = Math.max(max[0], start[0]);
                max[1] = Math.max(max[1], start[1]);
                min[0] = Math.min(min[0], start[0]);
                min[1] = Math.min(min[1], start[1]);
            }
            else if(str.charAt(i) == 'L'){
                if(d == 0) d = 3;
                else d--;
            }else{
                if(d==3) d = 0;
                else d++;
            }
        }

        for(int i = min[0] ; i <= max[0] ; i++){
            for(int j = min[1] ; j <= max[1] ; j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
