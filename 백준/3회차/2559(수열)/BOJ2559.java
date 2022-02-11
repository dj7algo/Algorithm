import java.io.*;
import java.util.*;
public class BOJ2559 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temperature = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for(int i = 0 ; i < N ; i++){
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N-K+1 ; i++){
            int sum = 0;
            for(int j = i ; j < i+K ; j++){
                sum += temperature[j];
            }
            if(sum > max) max = sum;
        }
        System.out.println(max);
    }
}
