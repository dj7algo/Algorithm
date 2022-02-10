import java.io.*;
import java.util.*;

public class A2559수열 {
    static int N, K, max = Integer.MIN_VALUE;   // 최대값이 음수일 경우도 있음
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

        // N개 입력 받음 - 순차적으로 K개씩 합계를 구함(N-K까지 반복문으로) - 합계 중 Max 찾음
        arraySum(0);

        System.out.print(max);
    }

    private static void arraySum(int idx) {
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum +=num[idx+i];
        }
        max = Math.max(max, sum);
        if ((idx +1 + K) > N) return;
        arraySum(idx + 1);
    }

}
