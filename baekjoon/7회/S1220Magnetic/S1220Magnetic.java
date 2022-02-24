package S1220Magnetic;

import java.io.*;
import java.util.*;

// 1 = N극 , 2 = S극  // 윗 부분(N극) , 아랫 부분(S극)
public class S1220Magnetic {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/S1220.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=10;tc++){
            br.readLine(); // 첫줄 한변 길이 100으로 고정되어있으므로 버림
            int[][] map=new int[100][100];
            for(int i=0;i<100;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<100;j++) map[i][j]=Integer.parseInt(st.nextToken());
            }
          
            int count = 0;
            for(int i=0;i<100;i++){
                boolean peek=false;
                for(int j=0;j<100;j++) {
                  if(map[j][i]==1) peek=true; // N극을 만났을 때 true
                  if(peek&& map[j][i]==2){  // N극인 상태에서 S극을 만났을 때
                      count++;
                      peek=false;
                  }
                }
            }
            sb.append("#"+tc+" "+count+"\n");
        }
       System.out.print(sb.toString());
       br.close();
    }
}