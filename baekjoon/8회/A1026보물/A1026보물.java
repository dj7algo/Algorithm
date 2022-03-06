
import java.io.*;
import java.util.*;

public class A1026보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++)
            result += A[i] * B[i];
        System.out.println(result);

        br.close();
    }
}
