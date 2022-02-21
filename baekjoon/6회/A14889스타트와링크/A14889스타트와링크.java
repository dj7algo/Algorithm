package A14889스타트와링크;

import java.io.*;
import java.util.*;

public class A14889스타트와링크 {
    static int N, min;
    static int[][] player;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 플레이어 수

        player = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++)
                player[i][j] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        comb(0, 0);
        sb.append(min);

        System.out.print(sb.toString().trim());
        br.close();
    }

    private static void comb(int cnt, int start) {
        if (cnt == N / 2) {
            int A = 0, B = 0, result = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] && visit[j]) {
                        A += player[i][j] + player[j][i];
                    } else if (!visit[i] && !visit[j]) {
                        B += player[i][j] + player[j][i];
                    }
                }
            }
            result = Math.abs(A - B);
            min = Math.min(result, min);
            return;
        }

        for (int i = start; i < N; i++) {
            visit[i] = true;
            comb(cnt + 1, i + 1);
            visit[i] = false;
        }
    }
}
