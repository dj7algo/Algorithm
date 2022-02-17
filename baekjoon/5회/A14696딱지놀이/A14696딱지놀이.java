import java.io.*;
import java.util.*;
/*
- 만약 두 딱지의 별의 개수가 다르다면, 별이 많은 쪽의 딱지가 이긴다.
- 별의 개수가 같고 동그라미의 개수가 다르다면, 동그라미가 많은 쪽의 딱지가 이긴다.
- 별, 동그라미의 개수가 각각 같고 네모의 개수가 다르다면, 네모가 많은 쪽의 딱지가 이긴다.
- 별, 동그라미, 네모의 개수가 각각 같고 세모의 개수가 다르다면, 세모가 많은 쪽의 딱지가 이긴다.
- 별, 동그라미, 네모, 세모의 개수가 각각 모두 같다면 무승부이다.
- ★●■▲ :  4, 3, 2, 1
*/
public class A14696딱지놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt( br.readLine());
        int[] a =new int[4], b =new int[4];  
        for(int r=0;r<N;r++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            for(int i=0;i<num;i++) a[Integer.parseInt(st.nextToken())-1]++; // A카드 입력
            st = new StringTokenizer(br.readLine()," ");
            num = Integer.parseInt(st.nextToken());
            for(int i=0;i<num;i++) b[Integer.parseInt(st.nextToken())-1]++; // B카드 입력
            for(int i=3;i>=0;i--) {
                if(a[i]==b[i]) {
                    if(i==0) sb.append("D\n");
                    continue;
                }
                else {
                    sb.append((a[i]>b[i]?"A":"B")+"\n");
                    break;
                }
            }
            Arrays.fill(a, 0);  // a 배열을 모두 0으로 초기화
            Arrays.fill(b, 0);  // b 배열을 모두 0으로 초기화
        }
        System.out.println(sb.toString().trim());
    }
}
