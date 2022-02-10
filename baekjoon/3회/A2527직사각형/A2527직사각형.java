import java.io.*;
import java.util.*;
/**
3 10 50 60 100 100 200 300
45 50 600 600 400 450 500 543
11 120 120 230 50 40 60 440
35 56 67 90 67 80 500 600

d
a
a
b
 */
public class A2527직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][][] box = new int[2][2][2]; // box[0] : 1번 상자, box[1]: 2번 상자
        for (int tc = 0; tc < 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++)
                        box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
            char c;
            // 겹치지 않을 때 - 1상자 오른쪽 2상자, 2상자 오른쪽 1상자, 1상자 위에 2상자, 2상자 위에 1상자
            if (box[0][1][0] < box[1][0][0]
                    || box[1][1][0] < box[0][0][0]
                    || box[0][1][1] < box[1][0][1]
                    || box[1][1][1] < box[0][0][1]) c = 'd';
            // 점 - 위왼, 위오, 아왼, 아오
            else if ((box[0][0][0] == box[1][1][0] && box[0][1][1] == box[1][0][1])
                    || (box[0][1][0] == box[1][0][0] && box[0][1][1] == box[1][0][1])
                    || (box[0][0][0] == box[1][1][0] && box[0][0][1] == box[1][1][1])
                    || (box[0][1][0] == box[1][0][0] && box[0][0][1] == box[1][1][1])) c = 'c';
            // 선분 - 왼, 오, 아래, 위
            else if (box[0][0][0] == box[1][1][0]
                    || box[0][1][0] == box[1][0][0]
                    || box[0][0][1] == box[1][1][1]
                    || box[0][1][1] == box[1][0][1]) c = 'b';
            // 직사각형
            else c = 'a';

            System.out.println(c);
        }
    }
}
