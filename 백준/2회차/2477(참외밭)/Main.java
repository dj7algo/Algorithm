import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] line = new String[6];
		int maxW = 0; //서, 동중에 최대 길이가 가로
		int maxH = 0;//북, 남중에 최대 길이가 세로
		
		// 1. 변의 최대길이를 찾아라.
		for (int i = 0 ; i < 6; i ++) {
			line[i] = br.readLine();
			StringTokenizer st = new StringTokenizer(line[i]," "); 
			// 변 방향
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken()); //변의 길이
			if (dir <= 2) { //1 (동)또는 2 (서)이면 가로길이
				if(length > maxW) {
					maxW = length;
				}
			}else { // 3또는 4이면, 세로길이
				if (length > maxH) {
					maxH = length;
				}
			}
		}
		boolean find = false;
		int index = 0;
		//2. 최대 길이변이 이어서 2개 들어오면 인덱스 가지고 탈출
		while(true) {
			StringTokenizer st = new StringTokenizer(line[index], " ");
			int dir = Integer.parseInt(st.nextToken()); //방향
			int length = Integer.parseInt(st.nextToken()); //변길이
			if ( dir <= 2 && length == maxW) { //방향이 (동 또는 서)일때
				if (find) {
					break;
				}else {
					find = true;
					index = (index + 1) % 6;
					continue; //find true를 유지시키기 위해 continue 
				}
			}
			if ( dir >= 3 && length == maxH) { //방향이 (북또는 남)일때
				if(find) {
					break;
				}else {
					find = true;
					index = (index + 1) % 6;
					continue; //find true를 유지시키기 위해 continue 
				}
			}
			if (find) find=false; 
			index = (index + 1) % 6;
		}
		// [마지막 인덱스에서 +2] [마지막 인덱스에서 +3] 이 두개의 변을 곱하면, 작은사각형이 된다.
		int smallbox = Integer.parseInt(line[((index + 2) % 6)].split(" ")[1]) * Integer.parseInt(line[((index+3) % 6)].split(" ")[1]);
		int result = (maxH*maxW - smallbox)*N; //마지막에 면적당참외수를 곱해준다.
		System.out.println(result);
	}
}
