package a0313;

import java.util.*;
import java.io.*;

public class B9372상근이의여행 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tc; i++) {
			StringTokenizer ST = new StringTokenizer(br.readLine());
			int countrynum = Integer.parseInt(ST.nextToken());
			int planenum = Integer.parseInt(ST.nextToken());
			
			for(int j=1; j<=planenum; j++)br.readLine();
			System.out.println(countrynum-1);
		}
		
	}

}
