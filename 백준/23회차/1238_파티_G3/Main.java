import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int dist[][];
    static int n,m,x;
    static ArrayList<Node>list [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 마을 수
        m = Integer.parseInt(st.nextToken());   // 단방향 도로
        x = Integer.parseInt(st.nextToken());   // x번 마을


        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        dist = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i],987654321);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());


            list[from].add(new Node(to,time));
        }

        for(int i=1; i<=n; i++){
            djistra(i);
        }

        int max = 0;
        for(int i=1; i<=n; i++){
                max = Math.max(max,dist[i][x]+dist[x][i]);

        }

        System.out.println(max);
    }
    public static void djistra(int idx){
        PriorityQueue<Node>pq = new PriorityQueue<>();
        pq.add(new Node(idx,0));
        dist[idx][idx] = 0;
        while(!pq.isEmpty()){
            Node a = pq.poll();
            for(Node next : list[a.city]){
                if(dist[idx][next.city] > dist[idx][a.city]+next.time){
                    dist[idx][next.city] = dist[idx][a.city]+next.time;
                    pq.add(new Node(next.city,dist[idx][next.city]));
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int city,time;

    public Node(int city, int time) {
        this.city = city;
        this.time = time;
    }
    public int compareTo(Node o){
        return this.time - o.time;
    }
}
