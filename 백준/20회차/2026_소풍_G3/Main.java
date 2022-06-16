import java.io.*;
import java.util.*;

public class Main {
    static int k,n,f;
    static boolean edge[][];
    static ArrayList<Integer>list = new ArrayList<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());       // 소풍에 보내는 학생의 수
        n = Integer.parseInt(st.nextToken());       // 학생의 번호
        f = Integer.parseInt(st.nextToken());       // 친구 관계수

        edge = new boolean[n+1][n+1];   // 연결 관계
        // k가 모두 친구여야된다.

        for(int i=0; i<f; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[a][b] = true;
            edge[b][a] =true;
        }

        for(int i=1; i<=n; i++){
            list.clear();
            dfs(i);
        }

        System.out.println(-1);
    }
    public static void dfs(int num){

        list.add(num);
        if(list.size() == k){
            Collections.sort(list);
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
            System.exit(0);
        }

        for(int i=num+1; i<=n; i++){
            boolean flag = true;
            for(int a : list){
                if(!edge[i][a]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                dfs(i);
            }
        }
        list.remove(list.size()-1);
    }
}
