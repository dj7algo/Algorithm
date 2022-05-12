import java.io.*;
import java.util.*;

public class BOJ17779 {

    static int[][] city;
    static boolean[][] isContain;
    static int N;
    static int min_ = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        city = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0;
        int y = 0;
        int d1 = 0;
        int d2 = 0;
        for (int i = 1; i <= N; i++) {
            x = i;
            for (int j = 1; j <= N; j++) {
                y = j;

                for (int k1 = 1; k1 <= N; k1++) {
                    d1 = k1;
                    for (int k2 = 1; k2 <= N; k2++) {
                        d2 = k2;
                        if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {
                            System.out.println(x + ", " + y + ", " + d1 + ", " + d2);
                            calc(x, y, d1, d2);
                        }
                    }
                }
            }
        }

        System.out.println(min_);
    }

    static void calc(int x, int y, int d1, int d2) {
        isContain = new boolean[N + 1][N + 1];
        int max = 0;
        int min = Integer.MAX_VALUE;
        int region5 = region5_border(x, y, d1, d2);

        int region = region1(x, y, d1);
        max = Math.max(max, region);
        min = Math.min(min, region);

        region = region2(x, y, d2);
        max = Math.max(max, region);
        min = Math.min(min, region);

        region = region3(x, y, d1, d2);
        max = Math.max(max, region);
        min = Math.min(min, region);

        region = region4(x, y, d1, d2);
        max = Math.max(max, region);
        min = Math.min(min, region);

        region5 += region5_inner();
        max = Math.max(max, region5);
        min = Math.min(min, region5);

        min_ = Math.min(min_, max - min);


    }

    static int region1(int x, int y, int d1) {
        int sum = 0;
        for (int i = 1; i < x + d1; i++) {
            if(isContain[i][y]) y--;
            for (int j = y; j >= 1; j--) {
                isContain[i][j] = true;
                sum += city[i][j];
            }
        }
        return sum;
    }

    static int region2(int x, int y, int d2) {
        int sum = 0;
        for (int i = 1; i <= x + d2; i++) {
            if(isContain[i][y]) y++;
            for (int j = y; j <= N; j++) {
                isContain[i][j] = true;
                sum += city[i][j];
            }
        }
        return sum;
    }

    static int region3(int x, int y, int d1, int d2) {
        x = x + d1;
        y = y - d1 + d2;
        int sum = 0;
        for (int i = N; i >= x; i--) {
            if (isContain[i][y-1]) y--;
            for (int j = 1; j < y; j++) {
                isContain[i][j] = true;
                sum += city[i][j];
            }
        }
        return sum;
    }

    static int region4(int x, int y, int d1, int d2){
        x = x + d2;
        y = y - d1 + d2;

        int sum = 0;

        for(int i = N ; i > x ; i--){
            if(isContain[i][y]) y++;
            for(int j = y ; j <= N ; j++){
                isContain[i][j] = true;
                sum += city[i][j];
            }
        }
        return sum;
    }

    static int region5_border(int x, int y, int d1, int d2) {
        int sum = 0;
        for(int i = 0; i <= d1 ; i++){
            isContain[x+i][y-i] = true;
            sum += city[x+i][y-i];
        }
        for(int i = 1 ; i <= d2 ; i++){
            isContain[x+i][y+i] = true;
            sum += city[x+i][y+i];
        }
        for(int i = 1 ; i <= d2 ; i++){
            isContain[x+d1+i][y-d1+i] = true;
            sum += city[x+d1+i][y-d1+i];
        }
        for(int i = 1; i < d1 ; i++){
            isContain[x+d2+i][y+d2-i] = true;
            sum += city[x+d2+i][y+d2-i];
        }
        return sum;
    }

    static int region5_inner() {
        int sum = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ;j++){
                if(isContain[i][j]) continue;
                sum += city[i][j];
            }
        }
        return sum;
    }
}
