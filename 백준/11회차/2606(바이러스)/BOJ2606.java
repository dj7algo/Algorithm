package BaekJoon;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
public class BOJ2606 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer>[] list = new List[N];
        boolean[] check = new boolean[N];
        for(int i = 0 ; i < N ; i++) list[i] = new ArrayList<>();
        StringTokenizer st = null;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            list[a].add(b);
            list[b].add(a);
        }

        System.out.println(bfs(list, check));
        //for(List<Integer> lists : list) System.out.println(lists);
    }

    static int bfs(List<Integer>[] list, boolean[] check){
        Queue<Integer> q = new LinkedList<>();
        check[0] = true;
        q.offer(0);

        int count = 0;
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i = 0 ; i < list[current].size() ; i++){
                int next = list[current].get(i);
                if(!check[next]){
                    count++;
                    check[next] = true;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}
