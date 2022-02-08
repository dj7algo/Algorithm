import java.io.*;
import java.util.*;

public class BOJ2304 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //막대기 수
        int[] height = new int[1001];               //막대 높이 담을 배열

        int maxIdx = 1;                             //막대 높이 가장 큰 인덱스
        int startIdx = 1002;                        //배열 인덱스 가장 앞인 막대 인덱스
        int endIdx = -1;                            //배열 인덱스 가장 마지막인 막대 인덱스
        int sum = 0;                                //공장 크기

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());//막대 인덱스(위치)
            int y = Integer.parseInt(st.nextToken());//막대 높이

            startIdx = Math.min(startIdx, x);
            endIdx = Math.max(endIdx, x);
            height[x] = y;                           //막대 높이 배열에 담기
            if(height[maxIdx] < height[x]) maxIdx = x;  //막대 높이 가장 큰 인덱스 탐색
        }

        sum += left(startIdx, maxIdx, height);      //가장 높은 막대 기준 왼쪽 넓이 계산
        sum += height[maxIdx];                      //가장 높은 막대 더하기
        sum += right(endIdx, maxIdx, height);       //가장 높은 막대 기준 오른쪽 넓이 계산

        System.out.println(sum);
    }

    static int right(int startIdx, int endIdx, int[] height){   //오른쪽 계산
        // 오른쪽에서 왼쪽으로 갈 수록 높이 증가
        int sum = 0;
        int h = 0;
        for(int i = startIdx ; i > endIdx ; i--){
            h = Math.max(h, height[i]);
            sum+=h;
        }
        return sum;
    }

    static int left(int startIdx, int endIdx, int[] height){
        // 왼쪽에서 오른쪽으로 갈 수록 높이 증가
        int sum = 0;
        int h = 0;
        for(int i = startIdx ; i < endIdx ; i++){
            h = Math.max(h, height[i]);
            sum += h;
        }
        return sum;
    }
}