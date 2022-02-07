package h2;

import java.io.*;
import java.util.*;

public class A2477참외밭 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        boolean[] dir = new boolean[4]; // 방향 - 동서남북 순서
        int[] key = new int[6];
        int[] length = new int[6];

        int K = sc.nextInt();
        for (int i = 0; i < 6; i++) {
            key[i] = sc.nextInt();
            length[i] = sc.nextInt();
            dir[key[i] - 1] = (dir[key[i] - 1]) ? false : true; // 같은 방향에 값이 존재하면 false
        }
        int bigBox = 1;
        int smallBox = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (dir[j] && (key[i] == j + 1)) {
                    bigBox *= length[i];
                    smallBox *= length[(i + 3) % 6];
                }
            }
        }
        System.out.println((bigBox - smallBox) * K);

        sc.close();
    }
}
