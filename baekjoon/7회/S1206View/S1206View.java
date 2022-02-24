package S1206View;

import java.io.*;
import java.util.*;

public class S1206View {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/S1206.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr= new int[N];
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++)arr[i]=Integer.parseInt(st.nextToken());
            int[] dx = {-2,-1,1,2};
            int[] x = new int[4] ;
            int count=0;
            loop: for(int i=2;i<N-2;i++){
                if(arr[i]==0) continue;
                int min=255;
                for(int j=0;j<4;j++){
                    if(arr[i]-arr[i+dx[j]]>0) min=Integer.min(min,x[j]=arr[i]-arr[i+dx[j]]);
                    else continue loop;
                }
                count+=min;
            }
            sb.append("#" + tc + " " + count + "\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}