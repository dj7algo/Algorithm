import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class BOJ10250 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < tc ; i++){
            String[] line = br.readLine().split(" ");
            int H= Integer.parseInt(line[0]);
            int T = Integer.parseInt(line[2]);

            int room = T / H;
            int floor = T % H;

            if(floor == 0){
                floor = H;

            }else{
                room += 1;
            }

            DecimalFormat df = new DecimalFormat("00");
            StringBuilder sb = new StringBuilder("");
            sb.append(floor).append(df.format(room)).append("\n");
            bw.write(sb.toString());
            bw.flush();
        }
        br.close();
        bw.close();


    }
}
