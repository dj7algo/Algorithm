package BaekJoon.Implement;
import java.io.*;
import java.util.*;

public class BOJ2578 {
    static int[][] bingo;
    static boolean[][] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];
        check = new boolean[5][5];
        StringTokenizer st;
        for(int i = 0 ; i < 5 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 5 ; j++) bingo[i][j] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        boolean isbingo = false;
        for(int i = 0 ; i < 5 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 5 ; j++){
                check_correct(Integer.parseInt(st.nextToken()));
                count++;
                isbingo = checkBingo();
                if(count >= 5 && isbingo){
                    System.out.println(count);
                    return;
                }
            }

        }

    }

    static void check_correct(int c){
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(bingo[i][j] == c)
                    check[i][j] = true;
            }
        }
    }

    static boolean checkBingo(){
        int count = 0;
        for(int i = 0 ; i < 5 ; i++){
            count += checkLine(0, i, 0);
            count += checkLine(i, 0, 1);
            if(i == 0) count += checkLine(0, 0, 2);
            if(i == 4) count += checkLine(0, 4, 3);
            if (count == 3) return true;
        }
        return false;
    }

    static int checkLine(int xi, int xj, int dir){
        int[] di = {1, 0, 1, 1}; //세로 탐색, 가로 탐색, 대각선 탐색(오른쪽 아래 방향), 대각선 탐색(왼쪽 아래)
        int[] dj = {0, 1, 1, -1};
        if(check[xi][xj]) {
            for (int i = 0; i < 4; i++) {
                xi += di[dir];
                xj += dj[dir];
                if(!check[xi][xj])
                    return 0;
            }
        }else{
            return 0;
        }
        return 1;
    }
}
