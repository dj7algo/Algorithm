import java.io.*;
import java.util.*;

public class BOJ3190 {

    static class Snake {
        int i;
        int j;
        int d;
        Snake body;

        Snake(int i, int j, int d, Snake s) {
            this.i = i;
            this.j = j;
            this.d = d;
            this.body = s;
        }

        boolean isTail() {
            return this.body == null;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[] di = {0, 1, 0, -1}; //우 하 좌 상
        int[] dj = {1, 0, -1, 0};

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        int[][] inst;


        for (int n = 0; n < K; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            board[i][j] = 1;
        }

        Snake s = new Snake(1, 1, 0, null);
        board[1][1] = -1;

        int L = Integer.parseInt(br.readLine());
        inst = new int[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            inst[i][0] = Integer.parseInt(st.nextToken());
            if (st.nextToken().charAt(0) == 'L') {
                inst[i][1] = 0;
            } else {
                inst[i][1] = 1;
            }
        }
        int count = 0;
        boolean isExit = false;
        while (!isExit) {
            for (int i = 0; i < L; i++) {
                int time = inst[i][0] - count;
                for (int j = 0; j < time; j++) {
                    count++;
                    int ni = s.i + di[s.d];
                    int nj = s.j + dj[s.d];
                    if (1 <= ni && ni <= N && 1 <= nj && nj <= N && board[ni][nj] != -1) {
                        s = new Snake(ni, nj, s.d, s);
                        if (board[ni][nj] != 1) {
                            Snake tmp = s;
                            Snake tmph = s;
                            while (true) {
                                if (!tmp.isTail()) {
                                    tmph = tmp;
                                    tmp = tmp.body;
                                } else {
                                    board[tmp.i][tmp.j] = 0;
                                    tmph.body = null;
                                    break;
                                }
                            }
                        }
                        board[ni][nj] = -1;
                    } else {
                        isExit = true;
                        break;
                    }
                }
                if (isExit) break;
                if (inst[i][1] == 0) {
                    s.d = (s.d + 3) % 4;
                } else {
                    s.d = (s.d + 1) % 4;
                }
            }
            if (isExit) break;
            while (true) {
                int ni = s.i + di[s.d];
                int nj = s.j + dj[s.d];
                count++;
                if (1 <= ni && ni <= N && 1 <= nj && nj <= N && board[ni][nj] != -1) {
                    s = new Snake(ni, nj, s.d, s);
                    if (board[ni][nj] != 1) {
                        Snake tmp = s;
                        Snake tmph = s;
                        while (true) {
                            if (!tmp.isTail()) {
                                tmph = tmp;
                                tmp = tmp.body;
                            } else {
                                board[tmp.i][tmp.j] = 0;
                                tmph.body = null;
                                break;
                            }
                        }
                    }
                    board[ni][nj] = -1;
                } else {
                    isExit = true;
                    break;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}