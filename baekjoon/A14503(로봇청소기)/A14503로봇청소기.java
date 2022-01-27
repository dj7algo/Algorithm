import java.io.*;
import java.util.*;

public class A14503로봇청소기 {
    static final int[] di = { 0, -1, 0, 1 }; // 좌상우하 { 0, 1, 0, -1 };
    static final int[] dj = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 좌표(y) 세로
        int c = Integer.parseInt(st.nextToken()); // 좌표(x) 가로
        int d = Integer.parseInt(st.nextToken()); // 방향 : 0(북),1(동),2(남),3(서)

        String[][] room = new String[M][N];
        for (int i = 0; i < room.length; i++)
            room[i] = br.readLine().split(" ");

        while (true) {
            room[r][c] = "2";
            a: for (int y = 0; y < M; y++) {
                for (int x = 0; x < N; x++) {
                    if (room[y][x].equals(room[r][c])) {
                        int ny = y + di[d];
                        int nx = x + dj[d];
                        if (0 < ny && ny < M - 1 && 0 < nx && nx < N - 1) { // 벽 안쪽이면 
                            if (room[ny][nx] == "0") {
                                if (d == 0) d = 3;
                                else d--;
                                // 다시 청소 시작;
                            } else {

                            }
                        } else {    // b. 청소할 공간이 없다면, 방향 회전 2번
                            if(d<2)d+=2;
                            else d-=2;
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (room[r][c].equals("2"))
                    count++;
            }
        }
        System.out.println(count);
    }
}
