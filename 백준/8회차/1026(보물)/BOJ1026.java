import java.util.*;
import java.io.*;
public class BOJ1026 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int[] A = new int[N];
        int[] B = new int[N];
        Integer[] C = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0 ;i  < N ;i++){
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
            C[i] = B[i];
        }

        Arrays.sort(A);
        Arrays.sort(C, Collections.reverseOrder());
        int sum = 0;
        for(int i = 0 ; i < N ; i++) sum += A[i]*C[i];
        System.out.println(sum);
    }

}