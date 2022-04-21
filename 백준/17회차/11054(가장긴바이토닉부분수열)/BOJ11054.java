import java.io.*;
import java.util.*;

public class BOJ11054 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dpI = new int[N + 1];
        int[] dpD = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dpI[1] = 1;
        dpD[N] = 1;

        for (int i = 2; i <= N; i++) {
            dpI[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dpI[i] = Math.max(dpI[i], dpI[j]+1);
                }
            }
        }

        for(int i = N-1 ; i > 0 ; i--){
            dpD[i] = 1;
            for(int j = i+1 ; j <= N ; j++){
                if(arr[i] > arr[j]){
                    dpD[i] = Math.max(dpD[i], dpD[j]+1);
                }
            }
        }

        int max = 1;
        for(int i = 0 ; i <= N ; i++){
            if(i==0){
                max = Math.max(max, dpD[i+1]);
            }else if(i==N){
                max = Math.max(max, dpI[i]);
            }else{
                if(arr[i]==arr[i+1]){
                    max = Math.max(max, Math.max(dpI[i],dpD[i]));
                }else{
                    max = Math.max(max, dpI[i]+dpD[i]-1);
                }
            }
        }
        System.out.println(max);
    }


}
