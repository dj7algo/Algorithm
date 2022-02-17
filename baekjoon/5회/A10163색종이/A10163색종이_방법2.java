import java.io.*;
import java.util.*;
/**
 * 배열크기를 색종이가 있는 크기만큼만 선언 => but, 반복문 많아짐
*/
public class A10163색종이_방법2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
     
        int N = Integer.parseInt( br.readLine());
        int[] x1=new int[N],y1=new int[N],x2=new int[N],y2=new int[N];
        int minX=0,minY=1001;
        int maxX=0,maxY=1001;

        for(int i=1;i<=N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            x1[i-1]=Integer.parseInt(st.nextToken());    // 색종이 가장 왼쪽 아래 x좌표
            y1[i-1]=Integer.parseInt(st.nextToken());    // 색종이 가장 왼쪽 아래 y좌표
            x2[i-1]=Integer.parseInt(st.nextToken())+x1[i-1];  // 색종이 가장 오른쪽 위 x좌표 = 컬럼길이 + x1
            y2[i-1]=Integer.parseInt(st.nextToken())+y1[i-1];  // 색종이 가장 오른쪽 위 y좌표 = 컬럼길이 + y1
            minX=Math.min(minX, x1[i-1]);  // 가장 왼쪽 아래에 있는 종이 x 좌표
            minY=Math.min(minX, y1[i-1]);  // 가장 왼쪽 아래에 있는 종이 y 좌표
            maxX=Math.max(maxX, x2[i-1]);  // 가장 오른족 위 종이 x좌표
            maxY=Math.max(maxY, y2[i-1]);  // 가장 오른쪽 위 종이 y좌표
        }
        int[][] arr=new int[maxX-minX][maxY-minY];  // 색종이가 위치한 크기만큼만 선언
        for(int i=1;i<=N;i++){
            for(int x=x1[i-1];x<x2[i-1];x++){
                for(int y=y1[i-1];y<y2[i-1];y++) arr[x-minX][y-minY]=i; // 색종이(i) 놓인 자리에 입력
            }
        }
        int[] count =new int[N];
        for(int n=1;n<=N;n++){
            for(int x=0;x<arr.length;x++){
                for(int y=0;y<arr[0].length;y++) {
                    if(arr[x][y]==n)  count[n-1]++;
                }
            }
            sb.append(count[n-1]+"\n");
        }
        System.out.print(sb.toString().trim());
        br.close();
    }
}
