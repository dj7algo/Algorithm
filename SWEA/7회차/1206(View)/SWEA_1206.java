package SWEA.D3;
import java.io.*;
import java.util.*;

public class SWEA_1206 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int tc = 1 ; tc <= 10 ; tc++){
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            int result = 0;
            int[] buildings = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < N ; i++) buildings[i] = Integer.parseInt(st.nextToken());

            for(int i = 2 ; i < N-2 ; i++){
                int possible = 255;
                for(int j = i - 2 ; j <= i+2 ; j++){
                    if(j==i) continue;
                    if(buildings[i] - buildings[j] > 0)
                        possible = Math.min(possible, buildings[i]-buildings[j]);
                    else{
                        possible = 0;
                        break;
                    }
                }
                result += possible;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
