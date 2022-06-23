import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,e;
    static int first,second;    // 꼭 방문 해야 되는 위치
    static int dist[][];
    static boolean visited[][];
    static ArrayList<Node>list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());       // 정점개수
        e = Integer.parseInt(st.nextToken());       // 간선개수
        visited = new boolean[n+1][n+1];
        list = new ArrayList[n+1];
        dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i],987654321);
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,dist));
            list[b].add(new Node(a,dist));
        }

        st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());

        dijkstra(1);
        dijkstra(first);
        dijkstra(second);
        dijkstra(n);

        int ans = 0;
        // 무조건 지나야 하는 정점을 못 지나는 경우
        if(dist[1][first]==987654321 || dist[1][second]==987654321|| dist[1][n]==987654321){
            System.out.println(-1);
            System.exit(0);
        }


        int min = Integer.MAX_VALUE;
        // 1->first->second->n
        min = Math.min(min,dist[1][first]+dist[first][second]+dist[second][n]);
        // 1->second->first->n
        min = Math.min(min,dist[1][second]+dist[second][first]+dist[first][n]);
        // 1->first->1->second->n
        min = Math.min(min,dist[1][first]*2+dist[1][second]+dist[second][n]);

        // 1->first->1->second->1->n
        min = Math.min(min,dist[1][first]*2+dist[1][second]*2+dist[second][n]);
        // 1->second->1->first->n
        min = Math.min(min,dist[1][second]*2+dist[1][first]+dist[first][n]);
        // 1->second->1->first->1->n
        min = Math.min(min,dist[1][second]*2+dist[1][first]*2+dist[first][n]);

        System.out.println(min);

    }
    public static void dijkstra(int idx){
        PriorityQueue<Node>pq = new PriorityQueue<>();
        pq.add(new Node(idx,0));
        dist[idx][idx] = 0;

        while(!pq.isEmpty()){
            Node a = pq.poll();
            if(visited[idx][a.city]) continue;
            visited[idx][a.city] = true;
            for(Node next : list[a.city]){
                if(!visited[idx][next.city] && dist[idx][next.city] > dist[idx][a.city]+ next.dist){
                    dist[idx][next.city] = dist[idx][a.city]+ next.dist;
                    pq.add(new Node(next.city,dist[idx][next.city]));
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