import java.io.*;
import java.util.*;

public class BOJ2477 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numMelon = Integer.parseInt(br.readLine());
        int[] dir = new int[6];         //변의 방향
        int[] len = new int[6];         //변의 길이
        int max_width = 0;
        int max_height = 0;
        int small_square = 1;           //뺄 작은 사각형의 넓이

        for(int i = 0 ; i < 6 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            if(dir[i] == 1 || dir[i] == 2){     //방향이 1, 2인 경우 가로 방향
                max_width = Math.max(max_width, len[i]);    //가장 큰 가로변 찾기
            }
            if(dir[i] == 3 || dir[i] == 4){     //방향이 3, 4인 경우 세로 방향
                max_height = Math.max(max_height, len[i]);  //가장 큰 세로변 찾기
            }


            if(i >= 1){
                if((dir[i-1] == 4 && dir[i]==1) || (dir[i-1] == 1 && dir[i] == 3) || (dir[i-1] == 2 && dir[i] == 4) || (dir[i-1]==3 && dir[i]==2)){
                    small_square *= len[i]*len[i-1];
                }
            }

            //시작 변이 작은 사각형의 한 변이었던 경우 (맨 처음과 맨 끝의 변이 작은 사각형의 변인 경우)
            if(i == 5){
                if((dir[0] == 1 && dir[i] == 4) || (dir[0] == 3 && dir[i] == 1) || (dir[0] == 4 && dir[i] == 2) || (dir[0] == 2 && dir[i] == 3)){
                    small_square *= len[0] * len[i];
                }
            }
        }
        bw.write(String.valueOf(((max_height*max_width)-small_square)*numMelon));
        bw.flush();
        bw.close();
        br.close();
    }
}