import java.util.*;

public class A2669직사각형합집합면적구하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean[][] area;
        int count = 0;
        int[] x1=new int[4];
        int[] y1=new int[4];
        int[] x2=new int[4];
        int[] y2=new int[4];

        int X=0, Y=0; // 제일 큰 X,Y 값을 찾아서 배열 크기 결정
        for (int i = 0; i < 4; i++) {
            x1[i] = scan.nextInt();
            y1[i] = scan.nextInt();
            x2[i] = scan.nextInt();
            y2[i] = scan.nextInt();
            X = Math.max(X, x2[i]);
            Y = Math.max(Y, y2[i]);
        }
        area = new boolean[Y][X]; // 사각형
        for (int i = 0; i < 4; i++) {
            for (int y = y1[i]; y < y2[i]; y++) {
                for (int x = x1[i]; x < x2[i]; x++){
                    if (area[y][x]) continue;
                    area[y][x] = true;
                    count++;
                }   
            }
        }
        System.out.print(count);
        scan.close();
    }
}
