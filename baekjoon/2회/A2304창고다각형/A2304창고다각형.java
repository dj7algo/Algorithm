package h2;

import java.io.*;
import java.util.*;

public class A2304창고다각형 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0]=Integer.parseInt(st.nextToken()); // 가로(x)
            arr[i][1]=Integer.parseInt(st.nextToken()); // 세로(y)
        }
        Arrays.sort(arr,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {   //2차원 배열 0번째 열 정렬(x 기준으로 정렬)
                return o1[0]-o2[0];
            } 
        });

        int x = arr[0][0];
        int y = arr[0][1];
        int sum=0;
        for(int i=1;i<N;i++){
            if(i==(N-1) && y>=arr[i][1]){    // 마지막 y길이가 앞에 y 길이보다 작거나 같은 경우
                sum+=(arr[i][0]+1-x)*y;   // (현재 x-이전x 값)*y  (15-8)*10
                sum-=(arr[i][0]+1-(x+1))*(y-arr[i][1]); //((현재x+1)-(이전x+1))*(이전y-현재y)
            }
            else if(y<arr[i][1]) {
                sum+=(arr[i][0]-x)*y;   // y * (현재 x-이전x 값)
                x=arr[i][0];
                y=arr[i][1];
            }       
        }
        System.out.println(sum);
    }
}