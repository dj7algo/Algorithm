package h2;

import java.io.*;
import java.util.*;

public class A2304창고다각형 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][2];
        int max=0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0]=Integer.parseInt(st.nextToken()); // 가로(x)
            arr[i][1]=Integer.parseInt(st.nextToken()); // 세로(y)
            max = Math.max(max,arr[i][1]);
        }
        Arrays.sort(arr,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int sum = 0;
        int a = 0, b = 0; // max의 첫번째와 마지막 위치

        int x = arr[0][0]; 
        int y = arr[0][1]; 
        for (int i = 0; i < N; i++) { 
            if (arr[i][1] == max) { // max 발견하면 계산하고 끝
                sum += y * (arr[i][0] - x);
                a = arr[i][0];
                break;
            }
            if (arr[i][1] > y) { // 이전보다 높은 기둥을 만나면 여태까지 면적 계산
                sum += y * (arr[i][0] - x);
                x = arr[i][0];
                y = arr[i][1];
            }
        }
        x = arr[N - 1][0]; 
        y = arr[N - 1][1]; 
        for (int i = N - 1; i >= 0; i--) { 
            if (arr[i][1] == max) { // 맨 뒤에서부터 max 발견하면 계산하고 끝
                sum += y * (x - arr[i][0]);
                b = arr[i][0];
                break;
            }
            if (arr[i][1] > y) { // 이전보다 높은 기둥을 만나면 여태까지 면적 계산
                sum += y * (x - arr[i][0]);
                x = arr[i][0];
                y = arr[i][1];
            }
        }
        sum += max * (b - a + 1); // (max 높이 * 너비) 더하기

        System.out.println(sum);
    }
}