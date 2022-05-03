import java.io.*;
import java.util.*;

//파이어볼 초기화
//파이어볼 이동
//피이어볼 쪼개기
// -> 각 자리마다 Queue로 파이어볼 저장하기 => 큐 배열 필요
//격자의 번호는 (i-1)*N+j로 함
//-> 행과 열의 시작이 1이기 때문에
public class BOJ20056 {

    static int N; //정사각 격자 크기
    static Queue<FiraBall>[] list; //N*N 크기의 큐 배열
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1}; //파이어볼 방향 0, 1, 2, 3, 4, 5, 6, 7
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] nD = {
            {0, 2, 4, 6},
            {1, 3, 5, 7}
    };//여러개의 파이어볼 쪼개기 할 때 전부 홀수/짝수인 경우 0, 다른 경우 1

    //파이어볼 객체
    static class FiraBall{
        int r, c, m, s, d;

        FiraBall(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //큐 배열 초기화
        list = new Queue[N*N+1];
        for(int i = 1 ; i <= N*N ; i++){
            list[i] = new LinkedList<>();
        }

        //파이어볼 초기화
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //파이어볼이 위치하는 격자번호의 큐에 추기
            list[(r-1)*N+c].add(new FiraBall(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        //이동 횟수 K만큼 파이어볼 옮기고 쪼개기 반복
        for(int i = 0 ; i < K ; i++){
            move();
            spread();
        }


        int sum = 0;
        //1번 격자 부터 N*N번 격자까지 큐에 들어가있는 요소 확인하면서 질량 더하기
        for(int i = 1 ; i <= N*N ; i++){
            if(list[i].size() == 0) continue;
            while(!list[i].isEmpty()){
                FiraBall f = list[i].poll();
                sum += f.m;
            }
        }

        System.out.println(sum);
    }

    //파이어볼 옮기기
    static void move(){
        //옮겨진 파이어볼리스트 임시로 저장하기 위한 큐 배열 초기화
        Queue<FiraBall>[] tmp = new Queue[N*N+1];
        for(int i = 1 ; i <= N*N ; i++){
            tmp[i] = new LinkedList<>();
        }

        //1번 격자부터 돌아가면서 파이어볼 옮기기
        for(int i = 1 ; i <= N*N ; i++){
            //빈 격자는 탐색하지 X
            if(list[i].isEmpty()) continue;
            //헤당 격자의 큐 배열이 비어질때까지 탐색 (한 격자에 여러개의 파이어볼 존재할 수 있음 -> 언제? 쪼개져서 4개의 파이어볼 위치할 때)
            while(!list[i].isEmpty()){
                FiraBall f = list[i].poll();
                int nr = f.r;
                int nc = f.c;
                //속도가 N보다 클 경우 계속해서 회전하기 때문에 나머지 값으로 계산
                int speed = f.s % N;
                //nr, nc 위치 계산

                nr = nr + di[f.d] * speed;
                //범위 벗어나는 경우 계산
                if(nr>N) nr -= N;
                else if(nr <= 0) nr = N + nr;
                nc = nc + dj[f.d] * speed;
                //범위 벗어나는 경우 계산
                if(nc>N) nc -= N;
                else if(nc <= 0) nc = N + nc;

                f.r = nr;
                f.c = nc;

                //옮겨진 격자에 대한 임시 큐에 저장
                tmp[(nr-1)*N+nc].add(f);
            }
        }
        //list 큐 배열에 임시 큐 배열 값 덮어쓰기
        list = tmp;
    }

    //4개로 쪼개기
    static void spread(){
        for(int i = 1 ; i <= N*N ; i++){
            //1개 이하 존재하는 경우 쪼갤 필요 X
            if(list[i].size() <= 1) continue;
            //현재 격자의 r, c,값 초기화
            int r= list[i].peek().r;
            int c = list[i].peek().c;

            int Speed = 0; //새로운 속력값
            int Mount = 0; //새로운 질량값
            int count = 0;
            //각 파이어볼의 방향이 짝수/홀수인지 확인하기 위한 배열
            boolean[] check = new boolean[list[i].size()];

            //해당 격자의 큐에 있는 파이어볼 모두 계산
            while(!list[i].isEmpty()){
                FiraBall f = list[i].poll();
                Mount += f.m;
                Speed += f.s;
                //방향이 짝수이면 true, 홀수면 false
                if(f.d % 2 == 0) check[count] = true;
                count++;
            }

            //check 함수 통해서 모두 짝수/홀수있지 다 다른지 확인 후 [0,2,4,6] / [1, 3, 5, 7] 중 하나 결정
            int newDir = check(check)? 0 : 1;

            //속력은 더한 파이어볼의 개수로 나눔
            Speed = Speed / count;
            //질량은 5로 나눔
            Mount = Mount / 5;
            //질량이 0이면 고려대상 X
            if(Mount == 0) continue;

            //해당 격자에 새로운 파이어볼 4개 저장
            for(int j = 0 ; j < 4 ; j++){
                list[i].add(new FiraBall(r, c, Mount, Speed, nD[newDir][j]));
            }
        }
    }

    //새로운 파이어볼 방향 결정
    static boolean check(boolean[] dir){
        boolean initDir = dir[0]; //첫번째 파이어볼 방향 확인
        for(int i = 1 ;i < dir.length ; i++){
            //initDir과 다른 방향 있으면 모두 짝수/홀수 라는 가정이 성립하지 X
            if(initDir != dir[i]) return false;
        }
        return true;
    }
}
