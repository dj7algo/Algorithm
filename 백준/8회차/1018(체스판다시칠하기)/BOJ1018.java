import java.io.*;
import java.util.*;
public class BOJ1018 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][];

        for(int i = 0; i < N ; i++){
            board[i] = br.readLine().toCharArray();
        }
        boolean check = false;  //true : W, false : B
        int min = 64;
        for(int i = 0 ; i <= N-8; i++){
            for(int j = 0 ; j <= M-8 ; j++){
                int count = 0;
                for(int ni = i ; ni < i+8 ; ni++){
                    check = !check;
                    for(int nj = j ; nj < j+8 ; nj++){
                        if(board[ni][nj] == 'W' && !check) count++;
                        else if (board[ni][nj] == 'B' && check) count++;
                        check = !check;
                    }
                }
                count = (count > (64 - count)) ? 64 - count : count;
                min = min > count ? count : min;
            }
        }
        System.out.println(min);


    }
}