import java.io.*;
import java.util.*;
public class BOJ2589 {

    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[][] map = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        List<int[]> lands = new LinkedList<>();
        for(int i = 0 ; i < map.length ; i++){
            map[i] = br.readLine().toCharArray();
        }

        boolean[][] cant = new boolean[map.length][map[0].length];
        for(int i = 0 ; i < map.length ; i++){
            for(int j = 0 ; j < map[i].length ; j++){
                if(map[i][j]=='L') {
                    lands.add(new int[]{i, j});
                    cant[i][j] = true;
                }

            }
        }

        for(int i = 0; i < lands.size() ; i++){
            //System.out.println("Start at " + lands.get(i)[0] + ", " + lands.get(i)[1]);
            bfs(lands.get(i), new int [map.length][map[0].length], cant);
        }

        System.out.println(max-1);
    }

    static void bfs(int[] start, int[][] visit, boolean[][] cant){
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        visit[start[0]][start[1]] = 1;
        q.offer(start);

        while(!q.isEmpty()){
            int[] p = q.poll();
            max = (max < visit[p[0]][p[1]]) ? visit[p[0]][p[1]] : max;
            for(int d = 0 ; d < 4 ; d++){
                int ni = p[0] + di[d];
                int nj = p[1] + dj[d];
                if(0 <= ni && ni < visit.length && 0 <= nj && nj < visit[0].length && visit[ni][nj] == 0 && cant[ni][nj]){
                    visit[ni][nj] = visit[p[0]][p[1]] + 1;
                    q.offer(new int[] {ni, nj});
                }
            }
        }

        //System.out.println("Result of BFS");
        //for(int[] a : visit){
        //    System.out.println(Arrays.toString(a));
        //}
        //System.out.println();


    }

}