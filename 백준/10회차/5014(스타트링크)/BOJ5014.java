import java.io.*;
import java.util.*;
public class BOJ5014 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        int[] building = new int[Integer.parseInt(st.nextToken())+1];
        Arrays.fill(building, -1);
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        if(bfs(S, G, U, D, 0, building)) System.out.println(building[G]);
        else System.out.println("use the stairs");
    }

    static boolean bfs(int S, int G, int U, int D, int cnt, int[] building){
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        building[S] = cnt;

        while(!q.isEmpty()){
            int currnet = q.poll();
            if(currnet == G) return true;
            if(currnet + U <= building.length-1 && building[currnet+U] == -1){
                q.offer(currnet + U);
                building[currnet+U] = building[currnet] + 1;
            }
            if(currnet - D >= 1 && building[currnet-D] == -1){
                q.offer(currnet - D);
                building[currnet-D] = building[currnet] + 1;
            }
        }
        return false;


    }
}