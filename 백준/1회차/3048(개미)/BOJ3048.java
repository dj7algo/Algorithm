import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ3048 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫번째 라인 읽고 두 그룹의 개미 수 확인
        String line = br.readLine();
        int size1 = Integer.parseInt(line.split(" ")[0]);
        int size2 = Integer.parseInt(line.split(" ")[1]);

        //전체 개미들의 배열 생성
        char[] ants = new char[size1 + size2];

        //두번째 라인 읽고 첫번째 그룹 개미 삽입
        char[] ants1 = br.readLine().toCharArray();

        //세번째 라인 읽고 두번째 그룹 개미 삽입
        char[] ants2 = br.readLine().toCharArray();

        //전체 개미들 중 두번째 그룹 개미들의 인덱스 확인용
        int[] ant2_idx = new int[ants2.length];

        //네번째 라인 읽고 개미 이동 시간 입력
        int time = Integer.parseInt(br.readLine());
        br.close();

        //전체 개미 수만큼 반복하면서 첫번째 그룹 + 두번째 그룹 삽입
        for (int i = 0; i < ants.length; i++) {
            //첫번째 그룹은 입력값의 역순
            if (i < size1) {
                ants[i] = ants1[size1 - 1 - i];
            } else {
                ants[i] = ants2[i - size1];
                ant2_idx[i - size1] = i;
            }
        }

        //time만큼 개미 이동
        for (int i = 0; i < time; i++) {
            //1초단위로 개미들 한칸씩 이동
            for (int j = 0; j <= i; j++) {
                //이동하는 개미의 수는 두번째 그룹의 개미 수보다 클 수 없음
                if (j < size2) {
                    int changeidx = ant2_idx[j];
                    //이동할 개미의 위치 확인, 0번째면 이동 불가능
                    if (changeidx >= 1 && changeidx < ants.length) {
                        char tmp = ants[changeidx - 1];
                        //그 앞의 개미가 두번째 그룹에 속하지 않을 때 개미 이동
                        if (Arrays.binarySearch(ants2, tmp) < 0) {
                            ants[changeidx - 1] = ants[changeidx];
                            ants[changeidx] = tmp;
                            ant2_idx[j] = changeidx - 1;
                        }

                    }
                }
            }
        }


        bw.write(ants);
        bw.flush();
        bw.close();
    }
}
