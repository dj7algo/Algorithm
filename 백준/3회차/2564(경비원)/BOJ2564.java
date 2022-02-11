package BaekJoon.Implement;
import java.io.*;
import java.util.*;

public class BOJ2564 {

    static int width;   //블록의 가로
    static int height;  //블록의 세로
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        int[][] storeAd;
        int sum = 0;
        int T = Integer.parseInt(br.readLine());

        //가게 + 경비원 위치, 마지막[T]은 경비원 위치
        //[0] : 1(북),2(남),3(서),4(동), [1] : 위치
        storeAd = new int[T+1][2];
        for(int t = 0 ; t < T+1 ; t++){
            st = new StringTokenizer(br.readLine());
            storeAd[t][0] = Integer.parseInt(st.nextToken());
            storeAd[t][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < T ; i++){
            //경비원과 가게가 같은 line일 때
            if(storeAd[T][0] == storeAd[i][0]) {
                sum += Math.abs(storeAd[T][1] - storeAd[i][1]);
            }
            //경비원의 line 3, 4 인 경우
            else if (storeAd[T][0] > 2) {
                    sum += calcDistance(storeAd[i][0], storeAd[i][1], storeAd[T][0], storeAd[T][1]);
            }
            //경비원의 line 1, 2인 경우
            else{
                sum += calcDistance(storeAd[T][0], storeAd[T][1], storeAd[i][0], storeAd[i][1]);
            }
        }
        System.out.println(sum);

    }

    static int calcDistance(int baseLine,  int baseIdx, int storeLine, int storeIdx){
        int distance = 0;
        if(baseLine == 1){
            //경비원 - 가게 위치 반대(가로 라인)
            if(storeLine == 2){
                distance += calcOpposite(baseIdx, storeIdx, true);
            }
            //가게가 서쪽에 위치하는 경우
            else if(storeLine == 3){
                distance += baseIdx + storeIdx;
            }
            //가게가 동쪽에 위치하는 경우
            else{
                distance+= (width - baseIdx) + storeIdx;
            }
        }else if(baseLine == 2){
            //경비원 - 가게 위치 반대(가로 라인)
            if(storeLine == 1){
                distance += calcOpposite(baseIdx, storeIdx, true);
            }
            //가게가 서쪽에 위치하는 경우
            else if(storeLine == 3){
                distance += baseIdx + (height - storeIdx);
            }
            //가게가 동쪽에 위치하는 경우
            else{
                distance += (width - baseIdx) + (height - storeIdx);
            }
        }
        //경비원 - 가게 위치 반대 (세로 라인)
        else{
            distance += calcOpposite(baseIdx, storeIdx, false);
        }
        return distance;
    }

    static int calcOpposite(int i, int j, boolean isA){
        //isA : 둘 다 가로 line에 위치 - true / 세로 line에 위치 - false
        if(isA)
            return height + Math.min(i + j, (width - i + width - j));
        else
            return width + Math.min(i+j, (height - i + height - j));

    }
}
