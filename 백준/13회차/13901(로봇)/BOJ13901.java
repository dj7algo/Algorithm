import java.io.*;
import java.util.*;

public class BOJ13901 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] room = new int[R][C];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            room[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int si = Integer.parseInt(st.nextToken());
        int sj = Integer.parseInt(st.nextToken());
        room[si][sj] = 1;

        int[] seq = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            seq[i] = Integer.parseInt(st.nextToken())-1;
        }

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        int d = 0;
        int count = 4;
        while (true) {

            if (count == 0) break;

            int ni = si + di[d];
            int nj = sj + dj[d];

            if (0 <= ni && ni < R && 0 <= nj && nj < C && room[ni][nj] == 0) {
                room[ni][nj] = 1;
                si = ni;
                sj = nj;
                count = 4;
            } else {
                d = ((d + 1) % 4);
                count--;
            }

        }

        System.out.println(si + " " + sj);
    }
}