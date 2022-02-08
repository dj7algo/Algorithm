import java.util.*;
import java.io.*;

public class BOJ2116 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    //주사위 수
        int[][] dice = new int[N][6];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 6 ; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;                                        //가장 큰 합
        for(int i = 0 ; i < 6 ; i++){                       //첫번째 주사위 각 면별로 top인 경우를 계산
            int bottom = dice[0][i];
            int top = dice[0][face(i)];                     // 0-5 1-3 2-4
            int sum = side(bottom, top);                    // 옆면 중 가장 큰값을 더함
            for(int j = 1 ; j < N ; j++){                   //그 뒤로의 주사위에서 top과 bottom이 같은 경우 옆면 게산
                for(int k = 0 ; k < 6 ; k++){
                    if(dice[j][k] == top){
                        bottom = dice[j][k];
                        top = dice[j][face(k)];
                        break;
                    }
                }
                sum += side(bottom, top);
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    static int side(int bottom, int top){                   // 옆면에서 큰 값 계산
        if(bottom+top == 11)                                //윗면, 아랫면이 5,6인 경우 가장 큰 값은 4
            return 4;
        else if(bottom == 6 || top == 6)                    //윗면, 아랫면 중 한 면이 6인 경우 가장 큰 값은 5
            return 5;
        else                                                //윗면, 아랫면 중 한면이 5인 경우 가장 큰 값은 6
            return 6;
    }

    static int face(int facet){
        int face = 0;
        if(facet == 0) face = 5;                            //A-F
        else if(facet == 5) face = 0;
        else if(facet == 1) face = 3;                       //B-D
        else if(facet == 3) face = 1;
        else if(facet == 2) face = 4;                       //C-E
        else if(facet == 4) face = 2;

        return face;
    }
}