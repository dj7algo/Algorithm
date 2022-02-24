package S4047영준이의카드카운팅;

import java.io.*;

public class S4047영준이의카드카운팅 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/S4047.txt"));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        loop: for(int tc=1;tc<=T;tc++){
            sb.append("#"+tc);
            boolean[][] card = new boolean[4][13];
            String S = br.readLine();
            for(int i=0;i<S.length();i+=3){
                char t=S.substring(i).charAt(0);
                int num = Integer.parseInt(S.substring(i+1,i+3));
                int idx=0;
                if(t=='S') idx=0;
                else if(t=='D') idx=1;
                else if(t=='H') idx=2;
                else if(t=='C') idx=3;

                if(card[idx][num-1]) {    // 이미 카드가 존재하면
                    sb.append(" ERROR\n");
                    continue loop;
                }
                else card[idx][num-1]=true;
            }
            for(int i=0;i<4;i++){
                int count=0;
                for(int j=0;j<13;j++) if(card[i][j]) count++;
                sb.append(" "+(13-count));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}