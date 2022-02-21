import java.io.*;
import java.util.*;
public class BOJ14501 {
    static int max = 0;
    static int N = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }


        calc(1, T, P, new boolean[N+1]);
        System.out.println(max);
        br.close();
    }

    static void calc(int cnt, int T[], int P[], boolean[] selected){
        if(cnt == N+1){
            boolean[] work = new boolean[cnt];
            int money = 0;
            for(int i = 1 ; i < cnt ; i++){
                if(selected[i] && !work[i] && i + T[i] <= cnt){
                    for(int j = i ; j < i + T[i] ; j++){
                        work[j] = true;
                    }
                    //System.out.println(i + " : " + Arrays.toString(work));
                    money += P[i];
                }
            }

            if(max < money){
                max = money;
            }
            return;
        }

        selected[cnt] = true;
        calc(cnt+1, T, P, selected);
        selected[cnt] = false;
        calc(cnt+1, T, P, selected);
    }
}