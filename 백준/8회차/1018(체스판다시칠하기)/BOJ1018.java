import java.io.*;
import java.util.*;
public class BOJ1018 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][]; //체스판

        for(int i = 0; i < N ; i++){
            board[i] = br.readLine().toCharArray();
        }
        boolean check = false;  //true : W, false : B -> 시작값은 false(B)
        int min = 64;           //체스판 가장 적게 칠하는 수 : 초기값 64는 전부다 다시 칠해야하는 경우
        //NxM의 보드에서 8x8크기의 체스판 탐색하려면 시작점을 찾아야함 => 시작점이 될 수 있는 곳은 (0~N-8, 0~M-8)
        //예 : 8x8 보드에서 가능한 시작점은 (0,0)
        //   :10x10보드에서 가능한 시작점은 (0,0) (0,1) (0,2)
        //                            (1,0) (1,1) (1,2)
        //                            (2,0) (2,1) (2,2)
        for(int i = 0 ; i <= N-8; i++){
            for(int j = 0 ; j <= M-8 ; j++){
                //시작점 i,j로부터 체스판 8x8 탐색

                int count = 0; //다시 칠해야하는 칸 수
                for(int ni = i ; ni < i+8 ; ni++){
                    //check값 반전
                    // WBWBWBWB -> W (W로 시작해서 아래 for문에서 8번 다 돈 경우 다시 W로 돌아옴)
                    // BWBWBWBW
                    // -> 줄이 바뀌면 W에서 B로 반전되기 떄문
                    // 뒤집어서
                    // BWBWBWBW -> B (B로 시작해서 아래 for문에서 8번 다 돈 경우 다시 B로 돌아옴)
                    // WBWBWBWB
                    // 줄이 바뀌면 B에서 W로 반전됨
                    // 여기서는 시작점(i,j) 가 W로 시작한다고 가정하고 계산
                    check = !check;
                    for(int nj = j ; nj < j+8 ; nj++){
                        // 현재 위치의 check가 false(B)인 경우
                        // 현재 위치의 board값이 W면 다시 칠해야함 -> count 증가
                        if(board[ni][nj] == 'W' && !check) count++;

                        // 현재 위치의 check가 true(W)인 경우
                        // 현재 위치의 board값이 B면 다시 칠해야함 -> count 증가
                        else if (board[ni][nj] == 'B' && check) count++;
                        // 다음 칸 탐색을 위해 체스판 상태 반전 (W->B / B->W)
                        check = !check;
                    }
                }
                // BBBBBBBW에서 WBWBWBWB과 비교하면 다시 칠해야하는 칸의 수 = 5
                //             BWBWBWBW와 비교하면 다시 칠해야하는 칸의 수 = 3
                // count의 값은 W부터 시작하는 체스판의 다시 칠해야하는 칸의 수
                // -> 반대로 B부터 시작하는 체스판의 다시 칠해야하는 칸의 수 = (비교하는 칸의 전체 수) 8 - count = 3
                // => 전체 체스판의 칸 수 64 - count = B로 시작하는 체스판의 다시 칠해야하는 칸의 수가 됨
                // count와 64-count를 비교하면 시작점 i,j 부터의 체스판에서 다시 칠해야하는 칸의 최솟값 게산
                count = (count > (64 - count)) ? 64 - count : count;

                //min값과 시작점 i,j 부터의 최소값을 계산해 더 적게 칠할 수 있는 체스칸의 수를 비교
                min = min > count ? count : min;
            }
        }
        System.out.println(min);


    }
}