import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> line = new LinkedList<Integer>(); //줄세우기위한 라인 리스트
		line.add(1); // 첫줄 넣기
		st.nextToken(); // input 첫줄 버리기
		for (int i = 2 ; i <= N; i++) {	
			int index = (line.size())-Integer.parseInt(st.nextToken()); //2부터 넣는데, 인덱스는 현재 리스트의 사이즈 - 뽑은카드의 수 이다.
			line.add(index,i); //인덱스에 원하는 수를 넣는다.
		}
		//출력
		for (int i = 0 ; i < line.size(); i++) {
			System.out.print(line.get(i)+ " ");
		}
		
		
		br.close();
	}
}
