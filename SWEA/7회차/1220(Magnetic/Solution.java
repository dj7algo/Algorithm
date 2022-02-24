import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1 ; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0 ; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0 ; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for (int i = 0 ; i < N ; i++) {
                List<Integer> list = new LinkedList<Integer>();
                for (int j = 0 ; j < N ; j ++) {
                    list.add(arr[j][i]); //0,0 -> 1,0 -> 2,0 순으로 탐색
                }
                while(list.get(0) != 1) {
                    list.remove(0);
                } 
                //왼쪽부터 1만날때까지 쭉 삭제한다.
                //오른쪽부터 2만날때까지 쭉 삭제한다.
                while(list.get(list.size()-1) != 2) {
                    list.remove(list.size()-1);
                }
                //정리가 끝나면, 왼쪽부터 쭉  가면서, 달라지는 부분을 센다.
                int current = 1;
                for (int index = 0 ; index < list.size(); index++) {
                    if (list.get(index) != current && list.get(index) != 0) {
                        if(list.get(index) == 2){
                            count++;
                        }
                        current= list.get(index);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}