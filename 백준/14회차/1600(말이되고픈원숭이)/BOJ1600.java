import java.io.*;
import java.util.*;

public class BOJ1600 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //말 흉내낼 수 있는 횟수
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[c][r];
        //방문여부배열 -> 남은 말 흉내 횟수에 따라 방문 배열 다르게 함
        // -> why? 방문배열을 하나로 하면 말을 흉내낸 횟수가 다른데도 방문이 중복되어 방문하지 못하는 장소가 발생할 수 있기 때문
        // 0 ~ K
        boolean[][][] visited = new boolean[c][r][k+1];
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < r; j++) {
                //장애물이 있는 경우
                if (Integer.parseInt(st.nextToken()) != 0) {
                    map[i][j] = -1;
                }
            }
        }

        //bfs 탐색
        int result = bfs(0, 0, map, visited, k, c, r);

        System.out.println(result);
    }

    static int bfs(int i, int j, int[][] map, boolean[][][] visited, int k, int c, int r) {

        //원숭이가 원래 움직일 수 있는 범위
        int[] diM = {-1, 0, 1, 0};
        int[] djM = {0, 1, 0, -1};

        //원숭이가 말을 흉내냈을 때 움직일 수 있는 범위
        int[] diH = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] djH = {-2, -1, 1, 2, 2, 1, -1, -2};

        //이동 위치 담을 큐 : i, j, 이동거리, 남은 말 흉내 횟수
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, 0, k});
        map[i][j] = 1;

        //bfs 탐색 시작
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            //현재 위치가 마지막 위치인 경우 현재 이동 거리 반환 후 탐색 종료 -> why? : 최단 거리 : 가장 먼저 마지막 위치에 도달한 경우가 최단 이동 횟수
            if(cur[0] == c-1 && cur[1] == r-1) return cur[2];

            //말 먼저 흉내내야한다는 경우 없으므로
            //원숭이대로 움직이고 말도 흉내내며 섞어가며 경우 확인

            //원숭이 움직이기
            for(int d = 0 ; d < 4 ; d++){
                int ni = cur[0] + diM[d];
                int nj = cur[1] + djM[d];
                //현재 남은 말 흉내 횟수에 따른 방문 배열에서 방문하지 않았고, 장애물이 없는 경우
                if(0 <= ni && ni < c && 0 <= nj && nj < r && !visited[ni][nj][cur[3]] && map[ni][nj] == 0){
                    visited[ni][nj][cur[3]] = true;
                    q.add(new int[]{ni, nj, cur[2] + 1, cur[3]});
                }
            }

            //말 흉내내기 (말 흉내내기 횟수 남은 경우에만)
            if(cur[3] > 0){
                for(int d = 0 ; d < 8 ; d++){
                    int ni = cur[0] + diH[d];
                    int nj = cur[1] + djH[d];
                    //말을 흉내낸 경우 남은 말 흉내 횟수에 따른 방문 배열에 방문하지 않았고 장애물이 없는 경우
                    if(0 <= ni && ni < c && 0 <= nj && nj < r && !visited[ni][nj][cur[3]-1] && map[ni][nj] == 0){
                        visited[ni][nj][cur[3]-1] = true;
                        //말 흉내 냈기때문에 말 흉내횟수 1 감소
                        q.add(new int[]{ni, nj, cur[2] + 1, cur[3]-1});
                    }
                }
            }
        }



        //bfs 탐색 종료될 동안 최종 지점에 다다르지 못한 경우
        //-1 값 반환
        return -1;
    }

}