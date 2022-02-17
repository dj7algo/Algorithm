import java.io.*;
import java.util.*;
/**
 * 배열크기를 1001로 고정 => 간단함 but, 메모리 비효율적
*/
public class A10163색종이_방법1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[1001][1001];
        int X=0,Y=0;
        int N = Integer.parseInt( br.readLine());
        for(int i=1;i<=N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            int x1=Integer.parseInt(st.nextToken());    // 색종이 가장 왼쪽 아래 x좌표
            int y1=Integer.parseInt(st.nextToken());    // 색종이 가장 왼쪽 아래 y좌표
            int x2=Integer.parseInt(st.nextToken())+x1;  // 색종이 가장 오른쪽 위 x좌표 = 컬럼길이 + x1
            int y2=Integer.parseInt(st.nextToken())+y1;  // 색종이 가장 오른쪽 위 y좌표 = 컬럼길이 + y1
            X=Math.max(X, x2);  // 가장 큰 종이 x좌표
            Y=Math.max(Y, y2);  // 가장 큰 종이 y좌표
            for(int x=x1;x<x2;x++){
                for(int y=y1;y<y2;y++) arr[x][y]=i; // 색종이(i) 놓인 자리에 입력
            }
        }
        int[] count =new int[N];
        for(int n=1;n<=N;n++){
            for(int x=0;x<X;x++){
                for(int y=0;y<Y;y++) {
                    if(arr[x][y]==n)  count[n-1]++;
                }
            }
            sb.append(count[n-1]+"\n");
        }
        System.out.print(sb.toString().trim());
        br.close();
    }
}