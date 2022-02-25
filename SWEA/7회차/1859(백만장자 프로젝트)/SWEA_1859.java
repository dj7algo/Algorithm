package SWEA.D2;
import java.io.*;
import java.util.*;
public class SWEA_1859 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= T ; tc++){
            int[] price = new int[Integer.parseInt(br.readLine())];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < price.length ; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            long profit = 0;
            for(int i = price.length - 1 ; i >= 0 ; i--){
                if(max < price[i]) max = price[i];
                profit += max - price[i];
            }
            System.out.println("#" + tc + " " + profit);
        }
    }
}