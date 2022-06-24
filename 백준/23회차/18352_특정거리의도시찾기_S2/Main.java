import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k,x;
    static int dist[];
    static boolean visited[];
    static ArrayList<Node>list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        dist = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist,987654321);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,0));
        }
        dijkstra();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(i==x) continue;
            if(dist[i] ==k){
                sb.append(i+"\n");
            }
        }
        if(sb.length()==0) System.out.println(-1);
        else System.out.println(sb);
    }
    public static void dijkstra(){
        PriorityQueue<Node>pq = new PriorityQueue<>();
        pq.add(new Node(x,0));
;
        dist[x] = 0;
        while(!pq.isEmpty()){
            Node a = pq.poll();

            if(visited[a.city]) continue;
            visited[a.city] = true;
            for(Node next : list[a.city]){
                if(!visited[next.city] && dist[next.city] > dist[a.city]+1){
                    dist[next.city] = dist[a.city]+1;
                    pq.add(new Node(next.city,dist[next.city]));
                }
            }
        }
    }

}
class Node implements Comparable<Node>{

    int city,dist;

    public Node(int city, int dist) {
        this.city = city;
        this.dist = dist;
    }

    public int compareTo(Node o){
        return this.dist - o.dist;
    }
}