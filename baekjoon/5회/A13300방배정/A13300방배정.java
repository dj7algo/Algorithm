import java.io.*;
import java.util.*;

/*
 * 한 방에 배정할 수 있는 최대 인원 수 K가 주어졌을 때, 조건에 맞게 모든 학생을 배정하기 위해 필요한 방의 최소 개수를 구하기
 * 한 방에 같은 학년으로만 남학생은 남학생끼리, 여학생은 여학생 끼리. 
 * 한방에 한명만도 가능.
 */

public class A13300방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] student = new int[2][6]; // 성별(0:여자,1:남자)|학년(1~6)
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());
            student[s][y-1]+=1;
        }
        int count=0;
        for(int i =0;i<2;i++){
            for(int j=0;j<6;j++) {
                if(student[i][j]==0) continue;
                count+=student[i][j]/K;
                if(student[i][j]%K !=0) count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}