package A14888연산자끼워넣기;

import java.io.*;
import java.util.*;

public class A14888연산자끼워넣기 {
    static int N, max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
    static int[] calculation, numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        numbers = new int[N];
        calculation = new int[4];

        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) numbers[i]=Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<4;i++) calculation[i]=Integer.parseInt(st.nextToken());
        
        dfs(1,numbers[0]);
        System.out.print(max+"\n"+min);
    }
    private static void dfs(int cnt, int start) {
        if(cnt==N){
            max=Math.max(max, start);
            min=Math.min(min, start);
            return;
        }
        for(int i=0;i<4;i++){
            if(calculation[i]>0){
                calculation[i]--;
                if(i==0) dfs(cnt+1,start+numbers[cnt]);
                else if(i==1) dfs(cnt+1,start-numbers[cnt]);
                else if(i==2) dfs(cnt+1,start*numbers[cnt]);
                else if(i==3) dfs(cnt+1,start/numbers[cnt]);
                calculation[i]++;
            }
        }
    }
}
