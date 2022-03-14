package BaekJoon;
import java.io.*;
import java.util.*;
public class BOJ1063 {
    public static void main(String[] args) throws Exception{
        int[] di = {0, 0, 1, -1, -1, -1, 1, 1}; //R, L, B, T, RT, LT, RB, LB
        int[] dj = {1, -1, 0, 0, 1, -1, 1, -1};
        int[][] board = new int[8][8];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] king = calcInit(st.nextToken());
        int[] stone = calcInit(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int n = 0 ; n < N ; n++){
            String dir = br.readLine();
            int d = 0;
            switch (dir){
                case "R":
                    d = 0;
                    break;
                case "L":
                    d = 1;
                    break;
                case "B":
                    d = 2;
                    break;
                case "T":
                    d = 3;
                    break;
                case "RT":
                    d = 4;
                    break;
                case "LT":
                    d = 5;
                    break;
                case "RB":
                    d = 6;
                    break;
                case "LB":
                    d = 7;
                    break;
            }
            int ni = king[0] + di[d];
            int nj = king[1] + dj[d];
            if(0 <= ni && ni < 8 && 0 <= nj && nj < 8){
                if(ni == stone[0] && nj == stone[1]){
                    int si = stone[0] + di[d];
                    int sj = stone[1] + dj[d];
                    if(0 <= si && si < 8 && 0 <= sj && sj < 8){
                        stone[0] = si;
                        stone[1] = sj;
                        king[0] = ni;
                        king[1] = nj;
                    }
                }else{
                    king[0] = ni;
                    king[1] = nj;
                }
            }
        }
        System.out.println(calcFinal(king));
        System.out.println(calcFinal(stone));

    }
    static int[] calcInit(String str){
        int j = (int)str.charAt(0) - 'A';
        int i = 8 - ((int)str.charAt(1) - '0');
        return new int[] {i, j};
    }
    static String calcFinal(int[] loc){
        String str = "";
        str += String.valueOf((char)('A'+loc[1]));
        str += String.valueOf(8 - loc[0]);
        return str;
    }
}
