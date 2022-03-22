import java.io.*;
import java.util.*;
public class BOJ9372 {
    public static void main(String[] args) throws Exception{
        int N, M, cnt;
        ArrayList<Integer>[] list;
        boolean[] visit;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        for(int tc = 0 ; tc < t ; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N+1];
            visit = new boolean[N+1];

            for(int i =0 ; i <= N ; i++){
                list[i] = new ArrayList<>();
            }

            for(int i =0 ; i < M ; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            System.out.println(bfs(visit, list));
        }
    }

    static int bfs(boolean[] visit, ArrayList<Integer>[] list){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        int result = 0;

        while(!q.isEmpty()){
            result++;
            int val = q.poll();
            for(int i = 0 ; i < list[val].size() ; i++){
                if(!visit[list[val].get(i)]){
                    visit[list[val].get(i)] = true;
                    q.add(list[val].get(i));
                }
            }
        }

        return result -1;
    }
}