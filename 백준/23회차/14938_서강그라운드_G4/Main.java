import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m,r;
    static int dist[][];
    static int item[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];
        dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i], 987654321);
        }


        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            dist[a][b] = len;
            dist[b][a] = len;
        }

        for(int k=1; k<=n; k++){
            for(int j=1; j<=n; j++){
                for(int i=1; i<=n; i++){
                    if(i==j) continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                 }
            }
        }


        int max = 0;

        for(int i=1; i<=n; i++){
            int sum = item[i];
            for(int j=1; j<=n; j++){
                if(dist[i][j] <= m){
                    sum+=item[j];
                }
            }
            max  =Math.max(max,sum);
        }
        System.out.println(max);

//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=n; j++){
//                System.out.print(dist[i][j]+" ");
//            }
//            System.out.println();
//
//        }

    }
}
