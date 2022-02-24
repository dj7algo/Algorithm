package S1859백만장자프로젝트;

import java.io.*;
import java.util.*;

public class S1859백만장자프로젝트 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/S1859.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[][] max = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max[i][0] = i;              // 최대값 위치를 알기 위해 받음
                max[i][1] = arr[i];         // 최대값 비교를 위해 값을 받음
            }
            Arrays.sort(max, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) { // 내림차순
                    if (o1[1] == o2[1]) {   // 값이 같을 경우 index값이 더 큰 기준으로
                        return o2[0] - o1[0];
                    } else {
                        return o2[1] - o1[1];
                    }
                }
            });

            long sum = 0;   // N이 1,000,000 이하, 매매가 10,000이하 이므로 최대 10,000,000,000,000 (int 벗어남)
            int m = 0; // 최대값 인덱스 순서대로 가르킬 것
            int idx = 0;    // 입력받은 매매가 인덱스를 가르킬것
            loop: while (true) {
                while (idx < max[m][0]) {
                    sum += max[m][1] - arr[idx];
                    idx++;
                }
                idx++;  // 이익을 얻은 다음 날
                if (idx == N) break;
                while (idx - 1 >= max[m][0]) { // m이 더 크거나 같을 때 까지 반복 // 같은 날에는 위 반복문이 실행안되므로 idx++될 것.
                    m++;
                    if (m == N) break loop; // 다음으로 큰 값이 마지막날까지 없으면 break;
                }
            }
            sb.append("#" + tc + " " + sum + "\n");
        }
        System.out.print(sb.toString().trim());
        br.close();
    }
}