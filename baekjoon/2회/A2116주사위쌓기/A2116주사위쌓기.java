package h2;

import java.io.*;
import java.util.*;

public class A2116주사위쌓기 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][6];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," "); //ABCDEF => ABCFDE (내위치+3%6 마주보는값)
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
            arr[i][4]=Integer.parseInt(st.nextToken());
            arr[i][5]=Integer.parseInt(st.nextToken());
            arr[i][3]=Integer.parseInt(st.nextToken());
        }
        
        int max=0;
        for(int i=0;i<N;i++){
            // 0번째 주사위
            int bottomIdx = i;
            int topIdx=(i+3)%6;
            int value=arr[0][topIdx]; // 윗면 값
            int sum=0;
            for(int idx=0;idx<6;idx++){
                if(idx!=bottomIdx&&idx!=topIdx){
                    if(sum<arr[0][idx]) sum=arr[0][idx];
                }
            }
            // 1~N번째 주사위
            for(int j=1;j<N;j++){
                for(int k=0;k<6;k++){
                    if(arr[j][k]==value){
                        bottomIdx=k;
                        topIdx=(k+3)%6;
                        value=arr[j][topIdx];
                        break;
                    }
                }
                int maxSide=0;
                for(int idx=0;idx<6;idx++){
                    if(idx!=bottomIdx&&idx!=topIdx){
                        if(maxSide<arr[j][idx]) maxSide=arr[j][idx];
                    }
                }
                sum+=maxSide;
            }
            if(max<sum){
                max=sum;
            }
        }
        System.out.println(max);
    }
}
