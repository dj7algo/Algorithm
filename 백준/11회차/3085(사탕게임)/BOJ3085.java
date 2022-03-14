package BaekJoon;
import java.io.*;
import java.util.*;
public class BOJ3085 {
    static int maxCandy = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] candy = new char[N][N];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                candy[i][j] = str.charAt(j);
            }
        }

        for(int i =0 ;  i< N ;i++){
            for(int j = 0 ; j < N ;j++){
                change(candy, i, j);
            }
        }

        System.out.println(maxCandy);

    }

    static void change(char[][] candy, int idxI, int idxJ){
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        for(int i = 0 ; i < 4 ; i++){
            int ni = idxI + di[i];
            int nj = idxJ + dj[i];
            if(0 <= ni && ni < candy.length && 0 <= nj && nj < candy.length && candy[idxI][idxJ] != candy[ni][nj]){
                char tmp = candy[ni][nj];
                candy[ni][nj] = candy[idxI][idxJ];
                candy[idxI][idxJ] = tmp;
                calc(candy);
                tmp = candy[ni][nj];
                candy[ni][nj] = candy[idxI][idxJ];
                candy[idxI][idxJ] = tmp;
            }
        }
    }

    static void calc(char[][] candy){
        int max = 0;
        for(int i = 0 ; i < candy.length ; i++){
            int candyI = 0;
            int candyJ = 0;
            char baseI = candy[i][0];
            char baseJ = candy[0][i];
            for(int j = 0 ; j < candy.length ; j++){
                if(candy[i][j] == baseI){
                    candyI++;
                }else{
                    baseI = candy[i][j];
                    max = Math.max(max, candyI);
                    candyI=1;
                }

                if(candy[j][i] == baseJ){
                    candyJ++;
                }else{
                    baseJ = candy[j][i];
                    max = Math.max(max, candyJ);
                    candyJ=1;
                }
            }
            max = Math.max(max, candyI);
            max = Math.max(max, candyJ);
        }
        maxCandy = Math.max(maxCandy, max);
    }
}
