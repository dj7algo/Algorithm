import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20058 {

    static int[][] ices; //얼음판
    static int maxcount = 0; //최대덩어리
    //4방탐색 (인접 칸 탐색 용)
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int S = (int) Math.pow(2, N); //얼음판 크기 : 2^N * 2^N

        //얼음판 초기화
        ices = new int[S][S];
        for(int i = 0 ; i < S ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < S ; j++){
                ices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //단계별 연습
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < Q ; i++){
            //입력된 L값에 대해 회전
            rotation(Integer.parseInt(st.nextToken()));
            //인접한 칸 계산 후 얼음 양 조정
            calc();
        }

        int sum = 0; //남아있는 얼음 양의 합
        for(int i = 0 ; i < ices.length ; i++){
            for(int j = 0 ; j < ices.length ; j++){
                sum += ices[i][j];
            }
        }
        //bfs 통해서 큰 덩어리 크기 계산
        bfs();

        System.out.println(sum);
        System.out.println(maxcount);
        br.close();
    }

    static void rotation(int Q){
        //입력된 값에 대해 격자 나누기
        int L = (int)Math.pow(2, Q); // 부분 격자의 크기(한변) : 2^Q * 2*Q => L : 2^Q
        int t = ices.length / L;     // 부분 격자의 개수(한 변에 대해) -> 한 변 당 몇 번 탐색하며 회전해야하는가

        for(int i = 0 ; i < t ; i++){
            int r = i * L; //시작행
            for(int j = 0 ; j < t ; j++){
                int c = j * L; //시작열

                //회전 값 담을 임시배열
                int[][] tmp = new int[L][L];

                //시계방향 90도 회전 => i행 -> (N-i-1)열
                for(int w = 0 ; w < L ; w++){
                    for(int h = 0 ; h < L ; h++){
                        tmp[h][L-1-w] = ices[r+w][c+h];
                    }
                }

                //회전 결과를 얼음판에 다시 저장
                for(int w = 0 ; w < L ; w++){
                    for(int h = 0 ; h < L ; h++){
                        ices[r+w][c+h] = tmp[w][h];
                    }
                }
            }
        }
    }

    static void calc(){
        //감소값 담을 임시 배열
        int[][] tmp = new int[ices.length][ices[0].length];
        //전체 탐색하면서 감소해야하는 얼음 감소시킴
        for(int i = 0 ; i < tmp.length ; i++){
            for(int j = 0 ; j < tmp.length ; j++){
                // 얼음이 0인 칸은 계산 필요 없음
                if(ices[i][j]==0) continue;
                //감소 조건 만족하는 칸은 1씩 감소
                if(reduce(i, j)) {
                    tmp[i][j] = ices[i][j] - 1;
                }
                //감소 조건 만족하지 않으면 값 유지
                else{
                    tmp[i][j] = ices[i][j];
                }
            }
        }
        //얼음판에 감소 결과 저장
        ices = tmp;
    }

    //현재 칸에 있는 얼음 감소 여부 판단
    static boolean reduce(int i, int j){
        int count = 0; //인접칸의 얼음 유무 확인 용
        //4방 탐색 하면서
        for(int d = 0 ; d < 4 ; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            //인접한 칸이 범위를 벗어나거나, 얼음양이 0인 경우를 계산
            if(0 > ni || ni >= ices.length || 0 > nj || nj >= ices.length || ices[ni][nj]==0){
                count++;
            }
        }
        //인접칸 4칸 중 3~4개의 칸에 얼음이 있어야 감소하지 않음 => count값이 0, 1이어야 조건 만족
        //=> count가 2 이상인 경우 얼음 양 감소 조건 충족
        return count>=2 ? true : false;
    }

    //너비우선탐색 통한 큰 덩어리 계산
    static void bfs(){
        boolean[][] visited = new boolean[ices.length][ices.length];

        for(int i = 0 ; i < ices.length ; i++){
            for(int j = 0 ; j < ices.length ; j++){
                //이미 덩어리에 포함된 칸이나 얼음이 0인 칸은 고려 대상 아님
                if(visited[i][j] || ices[i][j]==0) continue;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {i, j});
                int count = 0;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int d = 0 ; d < 4 ; d++){
                        int ni = cur[0] + di[d];
                        int nj = cur[1] + dj[d];
                        if(0 <= ni && ni < ices.length && 0 <= nj && nj < ices.length && ices[ni][nj]!=0 && !visited[ni][nj]){
                            q.add(new int[] {ni, nj});
                            visited[ni][nj] = true;
                            count++;
                        }
                    }
                }
                //탐색 종료 후, 계산된 덩어리 크기와 최대 덩어리 크기 비교
                maxcount = Math.max(count, maxcount);
            }
        }
    }
}
