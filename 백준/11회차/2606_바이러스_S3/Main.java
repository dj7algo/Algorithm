import java.io.*;
import java.util.*;
public class Main {

    static ArrayList<Integer>[] list;
    static int n,m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 인접리스트로 간선 정보
        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무방향 그래프, 양쪽 다 넣어줌
            list[a].add(b);
            list[b].add(a);
        }
        bfs();

    }
    public static void bfs(){
        Queue<Integer>q = new LinkedList<>();
        boolean visited[] = new boolean[n+1];
        int cnt = 0;
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int a = q.poll();
            cnt++;
            for(int b : list[a]){
                if(!visited[b]){
                    visited[b] = true;
                    q.add(b);
                }
            }
        }
        System.out.println(cnt-1);  // 시작점 빼고 갯수 출력
    }
}
