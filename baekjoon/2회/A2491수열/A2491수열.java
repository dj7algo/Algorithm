package h2;

import java.io.*;

public class A2491수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(str[i]);

        int max = 1, count = 1;
        for (int i = 1; i < N; i++) {
            // 증가할 때
            if (arr[i - 1] <= arr[i]) count++;
            else count = 1;
            if (max < count) max = count;
        }

         // 감소할 때
         count = 1;
         for (int i = 1; i < N; i++) {
            if (arr[i - 1] >= arr[i]) count++;
            else  count = 1;
            if (max < count) max = count;
         }

        System.out.println(max);

        br.close();
    }
}
