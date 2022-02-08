import java.io.*;
import java.util.*;

public class BOJ2491 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        //수열 입력
        for(int i = 0 ; i < N ; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int count = 1;          //수열 길이
        int same = 1;           //똑같은 수 길이
        boolean direction = true; //false : 감소 방향, true : 증가 방향
        int max_count = 0;      //가장 긴 수열 길이

        for(int i = 1 ; i < N ; i++){
            if(sequence[i-1] < sequence[i]){
                //1. 수열 증가 방향 & i-1보다 i 값이 큰 경우
                if(direction) {
                    count++;
                }
                //2. 수열 감소 방향 & i-1 보다 i 값이 큰 경우 -> 방향 전환
                else{
                    if(count > max_count) max_count = count;    //이전까지의 수열 길이 비교 후 큰 값 저장
                    count = same + 1;                           //같은 수 연속된 길이에 자기 자신 길이 더함
                    direction = true;                           //증가 방향으로 전환
                }
                same = 1;                                       //이전 값과 다른 값의 수열이므로 같은 수 연속 길이 = 1
            }else if(sequence[i-1] > sequence[i]){
                //3. 수열 증가 방향 & i-1이 i 값보다 큰 경우 -> 방향 전환
                if(direction){
                    if(count > max_count) max_count = count;
                    count = same + 1;
                    direction = false;                          //감소 방향으로 전환
                }
                //4. 수열 감소 방향 && i-1이 i값보다 작은 경우
                else{
                    count++;
                }
                same = 1;
            }
            //5. i-1값 == i값
            else{
                same++;
                count++;
            }
        }
        System.out.println(max_count > count ? max_count : count);
    }
}