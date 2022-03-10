import java.io.*;
import java.util.*;
public class Main {

    static int f,s,g,u,d;
    static boolean visited[];
    static PriorityQueue<Node>pq = new PriorityQueue<>();
    public static void main(String[] args)  throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());   // 총 건물의 높이
        s = Integer.parseInt(st.nextToken());   // 시작위치
        g = Integer.parseInt(st.nextToken());   // 목적지
        u = Integer.parseInt(st.nextToken());    // 위로 u칸
        d = Integer.parseInt(st.nextToken());   // 아래로 d칸

        visited = new boolean[f+1];
        visited[s] = true;
        pq.add(new Node(s,0));

        while (!pq.isEmpty()){
            Node a = pq.poll();
            if(a.stair == g){
                System.out.println(a.cnt);
                System.exit(0);
            }

            int tmp = a.stair+u;

            if(tmp <=f && !visited[tmp]){
                pq.add(new Node(tmp,a.cnt+1));
                visited[tmp] = true;
            }

            tmp = a.stair-d;

            if(tmp>=1 && !visited[tmp]){
                pq.add(new Node(tmp,a.cnt+1));
                visited[tmp]= true;
            }
        }
        System.out.println("use the stairs");
    }


}
class Node implements Comparable<Node>{

    int stair,cnt;

    Node(int stair, int cnt){
        this.stair = stair;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }
}