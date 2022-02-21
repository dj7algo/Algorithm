package A13458시험감독;

import java.io.*;
import java.util.*;

/**
 * 총 N개의 시험장, i번 시험장에 있는 응시자의 수는 Ai명
 * 한 시험장에 총 감독관 감시 가능 응시자 수 B명, 시험장에 1명만 존재 가능
 * 한 시험장에 부 감독관 감시 가능 응시자 수 C명, 시험장에 여러명 존재 가능
 * 각 시험장마다 응시생들을 모두 감시해야 될 때, 필요한 감독관의 최솟값
 */
public class A13458시험감독 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());
       int[] num=new int[N];

       StringTokenizer st = new StringTokenizer(br.readLine()," ");
       for(int i=0;i<N;i++){
          num[i]=Integer.parseInt(st.nextToken());
       }
       st=new StringTokenizer(br.readLine()," ");
       int B = Integer.parseInt(st.nextToken());
       int C = Integer.parseInt(st.nextToken());

       long count=N; // 감독관은 최소 시험장 수 만큼 존재
       for(int i=0;i<N;i++){
           num[i]-=B;
           if(num[i]>0) count+=num[i]/C+((num[i]%C==0)?0:1);
       }
       System.out.println(count);
    }
}