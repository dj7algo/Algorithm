import java.io.*;
import java.util.*;

/*
#1 1
#2 12
#3 0
#4 31
#5 0
#6 2
#7 15
*/
public class A1018체스판다시칠하기 {
    static int min = 64;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/1018.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++)
                map[i][j] = (line[j] == 'B') ? true : false;
        }
        for (int i = 0; i < N - 7; i++) { // 8*8을 검사 할 수 있어야 함으로.
            for (int j = 0; j < M - 7; j++)
                check(i, j, map);
        }

        System.out.println(min);
    }

    private static void check(int x, int y, boolean[][] map) {
        boolean color = map[x][y]; // 첫번째 컬러를 기준으로
        int count = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != color)
                    count++; // 색이 올바르지 않으면 count
                color = (!color); // 다음 컬러 지정
            }
            color = (!color);
        }
        count = Math.min(count, 64 - count);
        min = Integer.min(min, count);
    }
}
