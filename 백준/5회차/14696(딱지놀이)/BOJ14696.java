import java.io.*;
import java.util.*;
public class BOJ14696 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] board;
        boolean isSame;
        for(int t = 0 ; t < T ; t++){
            board = new int[2][5];
            for(int i = 0 ; i < 2 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                while (st.hasMoreTokens()) {
                    board[i][Integer.parseInt(st.nextToken())]++;
                }
            }

            isSame = false;
            for(int i = 4 ; i > 0 ; i--){
                if(board[0][i] != board[1][i]){
                    if(board[0][i] > board[1][i]) System.out.println("A");
                    else System.out.println("B");
                    isSame = false;
                    break;
                }else{
                    isSame = true;
                }
            }

            if(isSame) System.out.println("D");
        }
    }
}
