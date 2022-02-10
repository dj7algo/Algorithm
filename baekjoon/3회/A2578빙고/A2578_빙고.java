import java.io.*;
import java.util.*;

public class A2578_빙고 {
    static int[][] bingo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];
        Queue<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                if (i < 5) bingo[i][j] = Integer.parseInt(st.nextToken());
                else list.add(Integer.parseInt(st.nextToken()));
            }
        }

        int sayCount = 1;
        int num = list.poll();
        while (!list.isEmpty()) {
            loop: for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (num==bingo[i][j]) {
                        bingo[i][j] = 0;
                        break loop;
                    }
                }
            }
            if (sayCount >= 5 && check()) break;
            num = list.poll();
            sayCount++;
        }
        System.out.println(sayCount);
    }

    private static boolean check() {
        int total = 0;

        // 가로, 세로
        int[] count = { 0, 0 };
        for (int i = 0; i < 5; i++) {
            count[0] = 0;
            count[1] = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j]==0)
                    count[0]++;
                if (bingo[j][i]==0)
                    count[1]++;
            }
            if (count[0] == 5) total++;
            if (count[1] == 5) total++;
        }

        // 우대각선
        if ((bingo[0][0]==bingo[1][1])&&(bingo[2][2]==bingo[3][3])&&(bingo[4][4]==0)) total++;
        // 좌대각선
        if ((bingo[4][0]==bingo[3][1])&&(bingo[2][2]==bingo[1][3])&&(bingo[0][4]==0)) total++;

        return (total >= 3);
    }
}
