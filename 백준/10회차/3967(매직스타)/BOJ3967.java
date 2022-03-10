import java.io.*;
import java.util.*;

public class BOJ3967 {
    int[][][] magicstar = new int[][][]{
            {{0, 4}, {1, 3}, {2, 2}, {3, 2}},
            {{1, 1}, {1, 3}, {1, 5}, {1, 7}},
            {{0, 4}, {1, 5}, {2, 6}, {3, 7}},
            {{1, 1}, {2, 2}, {3, 3}, {4, 4}},
            {{1, 7}, {2, 6}, {3, 5}, {4, 4}},
            {{4, 1}, {4, 3}, {4, 5}, {4, 7}}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] alphabet = new boolean[12];
        char[][] board = new char[5][9];
        br.close();

        for(int i = 0 ; i < 5 ; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0 ; j < line.length ; i++){
                board[i][j] = line[j];
                if('A' <= line[j] && line[j] <= 'L') alphabet[line[j] - 'A'] = true;
            }
        }
    }

    static void check(char[][] board, boolean[] alphabet, int idx){



        for(int i = 0 ; i < 12 ; i++){
            if(!alphabet[i]){
                alphabet[i] = true;

            }
        }
    }




}