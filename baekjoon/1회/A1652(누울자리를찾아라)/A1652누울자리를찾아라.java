import java.io.*;

public class A1652누울자리를찾아라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String arr[][] = new String[T][T];
        for (int i = 0; i < T; i++)
            arr[i] = br.readLine().split("");

        int x = 0, y = 0;
        int countX=0, countY = 0;
        
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                if (".".equals(arr[i][j])) x++;
                if (arr[i][j].equals("X") || j == (T - 1)) {
                    if(x>=2) countX++;
                    x = 0;
                }
                if (".".equals(arr[j][i])) y++;
                if (arr[j][i].equals("X") || j == (T - 1)) {
                    if(y>=2) countY++;
                    y = 0;
                }
            }
        }
        System.out.print(countX+" "+countY);
    }
}
