import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1652 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int row_count = 0;
        int col_count = 0;

        int size = Integer.parseInt(br.readLine());

        char[][] room = new char[size][size];
        for(int i = 0 ; i < size ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < line.length() ; j++){
                room[i][j] = line.charAt(j);
            }
        }

        //가로탐색
        for(int i = 0 ; i < size ; i++){
            int tmp_col = 0;
            int tmp_row = 0;
            int move = -1;
            for(int j = 0 ; j < size ; j++){
                move += 1;
                if(room[i][move] == '.'){
                    tmp_col++;
                }else{
                    if(tmp_col >= 2){
                        col_count++;
                    }
                    tmp_col = 0;
                }
                if(room[move][i] == '.'){
                    tmp_row++;
                }else{
                    if(tmp_row >= 2){
                        row_count++;
                    }
                    tmp_row = 0;
                }
            }
            if(tmp_col >= 2){
                col_count++;
            }
            if(tmp_row >= 2){
                row_count++;
            }
        }

        StringBuilder sb = new StringBuilder("");
        sb.append(col_count).append(" ").append(row_count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
