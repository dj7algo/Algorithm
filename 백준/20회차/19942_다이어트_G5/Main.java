import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int dest [] = new int[4];
    static int info [][];
    static boolean visited[];
    static ArrayList<String>ans = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        info = new int[n][5];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            dest[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
            Collections.sort(ans);
            System.out.println(ans.get(0));
        }
    }
    // 부분집합
    public static void dfs(int level){

        if(level == n){

            ArrayList<Integer>list = new ArrayList<>();

            int sum [] = new int[4];
            int price = 0;
            for(int i=0; i<n; i++){
                if(visited[i]){
                    list.add(i+1);
                    price += info[i][4];
                    for(int j=0; j<4; j++){
                        sum[j]+=info[i][j];
                    }
                }
            }

            int cnt = 0;
            for(int i=0; i<4; i++){
                if(dest[i] <= sum[i]){
                    cnt++;
                }
            }
            if(cnt ==4 && min >= price){
                if(min > price) ans.clear();
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<list.size(); i++){
                    sb.append(list.get(i)+" ");
                }
                ans.add(sb.toString());
                min = price;
            }

            return;
        }

        visited[level] = true;
        dfs(level+1);
        visited[level] = false;
        dfs(level+1);
    }
}
