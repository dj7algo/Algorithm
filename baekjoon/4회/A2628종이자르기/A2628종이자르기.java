import java.io.*;
import java.util.*;

public class A2628종이자르기 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st =new StringTokenizer(br.readLine()," ");
       int x= Integer.parseInt(st.nextToken());
       int y= Integer.parseInt(st.nextToken());
       int N = Integer.parseInt(br.readLine()); // 컷 수
       ArrayList<Integer> xList= new ArrayList<>();
       ArrayList<Integer> yList= new ArrayList<>();
       xList.add(0);
       xList.add(y);
       yList.add(0);
       yList.add(x);

       for(int i=0;i<N;i++){
        st =new StringTokenizer(br.readLine()," ");
        int num = Integer.parseInt(st.nextToken());
        if(num==0) xList.add(Integer.parseInt(st.nextToken()));  // 가로 cut
        else yList.add(Integer.parseInt(st.nextToken()));    // 세로 cut
       }

       xList.sort(null);
       yList.sort(null);
       int maxX=0, maxY=0;
       for (int i = 1; i < xList.size(); i++)
           maxX = Math.max(maxX, xList.get(i) - xList.get(i - 1));
       for (int i = 1; i < yList.size(); i++)
           maxY = Math.max(maxY, yList.get(i) - yList.get(i - 1));
       
       System.out.print(maxX*maxY); //컷팅 차이 제일 큰 값으로 넓이 구하기
    }
}
