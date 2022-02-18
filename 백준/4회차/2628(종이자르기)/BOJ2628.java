import java.io.*;
import java.util.*;
/*
종이자르기
점선을 따라 종이를 잘라 여러 개의 종이 조각으로 나누고 그 중 가장 큰 종이 조각의 넓이를 출력

입력
W H : 가로, 세로
N   : 자르는 점선 갯수
A B : 세로/가로, 점선 번호

종이를 자를 때에는 점선을 따라 종이 전체를 자르기 때문에 잘린 마디를 계산 -> 가장 긴 가로 마디 x 가장 긴 세로 마디 = 가장 넓은 종이 조각
 */
public class BOJ2628 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[] Is = new int[N];  // 가로선 점선 배열 -> 가로선 마디 구하면 세로 길이 나옴
        int[] Js = new int[N];  // 세로선 점선 배열 -> 세로선 마디 구하면 가로 길이 나옴
        int i_idx = 0;
        int j_idx = 0;
        int max_x = 0;          //가장 긴 가로 길이
        int max_y = 0;          //가장 긴 세로 마디

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 0){
                Is[i_idx++] = Integer.parseInt(st.nextToken());
            }else{
                Js[j_idx++] = Integer.parseInt(st.nextToken());
            }
        }

        //순서 무작위로 들어온 점선 정렬
        Is = Arrays.copyOf(Is, i_idx);
        Js = Arrays.copyOf(Js, j_idx);
        Arrays.sort(Is);
        Arrays.sort(Js);

        //가장 긴 가로 마디 길이 계산
        for(int i = 0 ; i < j_idx ; i++){
            if(i == 0) max_x = Math.max(Js[i], max_x);
            else max_x = Math.max(max_x, Js[i] - Js[i-1]);
        }
        if(j_idx != 0) max_x = Math.max(max_x, width - Js[j_idx-1]);
        else max_x = width;


        //가장 긴 세로 마디 계산
        for(int i = 0 ; i < i_idx ; i++){
            if(i==0) max_y = Math.max(Is[i], max_y);
            else max_y = Math.max(max_y, Is[i] - Is[i-1]);
        }
        if(i_idx != 0) max_y = Math.max(max_y, height - Is[i_idx-1]);
        else max_y = height;

        System.out.println(max_x * max_y);


    }
}
