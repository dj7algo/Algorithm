import java.io.*;
import java.util.*;

/**
 * 첫째 줄에 블록의 가로의 길이와 세로의 길이가 차례로 주어진다.
 * 둘째 줄에 상점의 개수가 주어진다. 블록의 가로의 길이와 세로의 길이, 상점의 개수는 모두 100이하의 자연수이다.
 * 이어 한 줄에 하나씩 상점의 위치가 주어진다. 상점의 위치는 두 개의 자연수로 표시된다.
 * 첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을
 * 의미한다.
 * 둘째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고,
 * 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다.
 * 마지막 줄에는 동근이의 위치가 상점의 위치와 같은 방식으로 주어진다.
 * 상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.
 */

public class A2564경비원 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("A2564.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(st.nextToken()); // 블록 가로 길이
        int H = Integer.parseInt(st.nextToken()); // 블록 세로 길이
        int N = Integer.parseInt(br.readLine()); // 상점 개수

        int[][] pos = new int[N + 1][2];
        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken()); // 북서남동(1324)=>북서남동(1234)로 저장
            if (p == 2)  pos[i][0] = 3;
            else if (p == 3) pos[i][0] = 2;
            else pos[i][0] = p;
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        // 동근이 위치 pos[N][0], pos[N][1];
        int aaa = pos[N][0]; // 기존 동근이 방향
        while (pos[N][0] != 3) {
            int k = ((3 - pos[N][0]) == -1) ? 3 : 3 - pos[N][0]; // 방향바꿔줄 값
            for (int i = 0; i < N + 1; i++) {
                int a = pos[i][0]; // 바뀌기 전 방향
                pos[i][0] = (pos[i][0] + k > 4) ? (pos[i][0] + k) % 4 : (pos[i][0] + k);
                if ((a == 2 || a == 3) && (pos[i][0] == 1 || pos[i][0] == 4)) {
                    if (a == 2)  pos[i][1] = H - pos[i][1];
                    else pos[i][1] = W - pos[i][1];
                }
                if ((a == 1 || a == 4) && (pos[i][0] == 2 || pos[i][0] == 3)) {
                    if (a == 4) pos[i][1] = H - pos[i][1];
                    else  pos[i][1] = W - pos[i][1];
                }
            }
        }

        int sum = 0;
        int x = (aaa == 1 || aaa == 3) ? W : H;
        int y = (x == W) ? H : W;
        for (int i = 0; i < N; i++) {
            if (pos[i][0] == 3)
                sum += Math.abs(pos[i][1] - pos[N][1]); // 방향이 같을 때
            else if (pos[i][0] == 4)
                sum += (x - pos[N][1]) + (y - pos[i][1]); // 오른쪽
            else if (pos[i][0] == 2)
                sum += pos[N][1] + (y - pos[i][1]); // 왼쪽
            else { // 마주볼 때
                sum += Math.min(pos[N][1] + pos[i][1], (x - pos[N][1]) + (x - pos[i][1])) + y;
            }
        }
        System.out.println(sum);
    }
}