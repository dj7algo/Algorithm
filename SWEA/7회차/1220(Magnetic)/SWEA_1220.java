package SWEA.D3;

import java.io.*;
import java.util.*;

public class SWEA_1220 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] table = new int[N][N];
            int[] magnetic = new int[N];
            boolean[] isAgg = new boolean[N];
            int agg = 0;


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                    if (table[i][j] == 1 || table[i][j] == 2) magnetic[j]++;
                }
            }
            while (agg != N) {
                for (int j = 0; j < N; j++) {
                    if (isAgg[j]) continue;
                    int count_agg = 0;
                    for (int i = 0; i < N; i++) {
                        if (table[i][j] == 1) {
                            if (i == N - 1) {
                                table[i][j] = 0;
                                magnetic[j]--;
                                if(magnetic[j]==0) break;
                            } else if (table[i + 1][j] == 0) {
                                table[i][j] = 0;
                                table[++i][j] = 1;
                            } else {
                                count_agg++;
                            }
                        } else if (table[i][j] == 2) {
                            if (i == 0) {
                                table[i][j] = 0;
                                magnetic[j]--;
                                if(magnetic[j]==0) break;
                            } else if (table[i - 1][j] == 0) {
                                table[i][j] = 0;
                                table[i-1][j] = 2;
                            } else {
                                count_agg++;
                            }
                        }
                    }

                    if (count_agg == magnetic[j]) {
                        isAgg[j] = true;
                        agg += 1;
                    }
                }
            }

            int aggmag = 0;
            for (int j = 0; j < N; j++) {
                for (int i = N - 1; i >= 1; i--) {
                    if (table[i][j] == 2 && table[i - 1][j] == 1) aggmag++;
                }
            }
            System.out.println("#" + tc + " " + aggmag);
        }
    }
}
