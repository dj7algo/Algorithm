package SWEA.D3;
import java.io.*;
import java.util.*;
public class SWEA_7964 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T ; tc++){
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            boolean[] cities = new boolean[N+2];
            cities[0] = true;
            cities[N+1] = true;
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1 ; i <= N; i++){
                if(st.nextToken().charAt(0) == '0') cities[i] = false;
                else cities[i] = true;
            }

            int start = 0;
            int cnt = 0;

            while(true){
                boolean isExist = false;
                for(int i = start + 1 ; i <= start+limit ; i++){
                    if(cities[i]){
                        isExist = true;
                        start = i;
                        break;
                    }
                }
                if(!isExist) {
                    cities[start+limit] = true;
                    cnt++;
                }
                if(start == N) break;
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
