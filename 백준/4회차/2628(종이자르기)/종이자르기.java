package week4;
import java.util.*;
import java.io.*;
public class 종이자르기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		List<Integer> rowList = new ArrayList<Integer>();
		List<Integer> colList = new ArrayList<Integer>();
		rowList.add(0); //0부터 시작
		colList.add(0); //0부터 시작
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if (st.nextToken().equals("0")) {
				rowList.add(Integer.parseInt(st.nextToken()));
			}else {
				colList.add(Integer.parseInt(st.nextToken()));
			}
		}
		rowList.add(row); //마지막 row 추가
		colList.add(col); //마지막 col 추가
		Collections.sort(rowList); //가로 정렬
		Collections.sort(colList); //세로 정렬
		int max = -1;
		for (int i = 1 ; i < rowList.size(); i++) {
			//가로길이 
			int width = rowList.get(i) - rowList.get(i-1);
			for (int j = 1; j < colList.size(); j++) {
				//세로길이
				int height = colList.get(j) - colList.get(j-1);
				int area = width*height;
				if (area > max) {
					max = area;
				}
			}
		}
		System.out.println(max);
	}
}
