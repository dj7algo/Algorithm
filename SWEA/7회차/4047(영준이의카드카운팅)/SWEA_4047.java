package SWEA.D3;
import java.io.*;
import java.util.*;
public class SWEA_4047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[][] card;
        StringBuilder sb = new StringBuilder();
        er : for(int tc = 1 ; tc <= T ; tc++){
            sb.append("#").append(tc);
            card = new boolean[4][14]; //0:스페이드, 1:다이아몬드, 2:하트, 3:클로버, 1~13 번호 카드
            String group = br.readLine();

            for(int i = 0 ; i < group.length() ; i += 3){
                String tmp = group.substring(i, i+3);
                int label = 0;
                int num = Integer.parseInt(tmp.substring(1,3));
                if(tmp.charAt(0) == 'D') label = 1;
                else if(tmp.charAt(0) == 'H') label = 2;
                else if(tmp.charAt(0) == 'C') label = 3;

                if(card[label][num]){
                    sb.append(" ERROR\n");
                    continue er;
                }
                card[label][num] = true;
            }

            for(int i = 0 ; i < 4 ; i++){
                int lack = 0;
                for(int j = 1 ; j <= 13 ; j++){
                    if(!card[i][j])lack++;
                }
                sb.append(" ").append(lack);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
