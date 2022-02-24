import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T ; tc++) {
			sb.append("#").append(tc).append(" ");
			String line = br.readLine();
			List<Integer> S = new ArrayList<Integer>();//space
			List<Integer> D = new ArrayList<Integer>();//dia
			List<Integer> H = new ArrayList<Integer>();//Heart
			List<Integer> C = new ArrayList<Integer>();//Clova
			boolean error = false;
			for (int i = 0 ; i < line.length()-1; i+=3) {
				char card = line.charAt(i);
				int number = Integer.parseInt(line.substring(i+1,i+3));
				switch (card) {
				case 'S':
					if (S.contains(new Integer(number))) {
						error = true;
					}else {
						S.add(number);
					}
					break;
				case 'D':
					if (D.contains(new Integer(number))) {
						error = true;
						break;
					}else {
						D.add(number);
					}
					break;
				case 'H':
					if (H.contains(new Integer(number))) {
						error = true;
						break;
					}else {
						H.add(number);
					}
					break;
				case 'C':
					if (C.contains(new Integer(number))) {
						error = true;
						break;
					}else {
						C.add(number);
					}
					break;
				}
				
			}
			if (error) {
				sb.append("ERROR");
			}else {
				sb.append(13 - S.size()).append(" ");
				sb.append(13 - D.size()).append(" ");
				sb.append(13 - H.size()).append(" ");
				sb.append(13 - C.size());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
