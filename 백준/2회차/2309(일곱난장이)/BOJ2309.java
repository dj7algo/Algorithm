import java.util.*;
import java.io.*;

public class BOJ2309 {
    static int[] total_dwarfs;  //전체 난쟁이 배열(9)
    static int[] real_dwarfs;   //진짜 난쟁이 배열
    static int[] tmp_dwarfs;    //임시 난쟁이 배열
    static boolean isStop = false;  //재귀 멈추는 조건

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total_dwarfs = new int[9];
        real_dwarfs = new int[7];
        tmp_dwarfs = new int[7];

        //전체 난쟁이 담기
        for(int i = 0 ; i < total_dwarfs.length ; i++){
            total_dwarfs[i] = Integer.parseInt(br.readLine());
        }

        //전체 난쟁이 9명 중 7명 조합의 키 합 계산
        combination(0, 0);

        //진짜 난쟁이 배열 정렬 후 출력
        Arrays.sort(real_dwarfs);
        for(int n : real_dwarfs){
            System.out.println(n);
        }

    }

    //키의 합이 100인 7명의 난쟁이 조합 탐색
    static void combination(int cnt, int start){
        //난쟁이 수가 7인 경우 키 합 계산해 100 만족하는 지 확인
        if (cnt == 7){
            int sum = 0;
            for(int i = 0 ; i < tmp_dwarfs.length ; i++){
                sum += tmp_dwarfs[i];
            }
            //키의 합이 100인 경우 종료
            if(sum==100){
                for(int i = 0 ; i < real_dwarfs.length ; i++){
                    real_dwarfs[i] = tmp_dwarfs[i];
                }
                isStop = true;
            }
            return;
        }
        
        //조합 재귀 호출
        for(int i = start ; i < 9 ; i++){
            tmp_dwarfs[cnt] = total_dwarfs[i];
            combination(cnt+1, i+1);
            if(isStop) return;
        }
    }
}