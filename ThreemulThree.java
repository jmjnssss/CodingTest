package com.fiirst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ThreemulThree {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		String xStr = bufferedReader.readLine();
		String yStr = bufferedReader.readLine();
		
		int x = Integer.parseInt(xStr);
		
		for(int i = yStr.length()-1; i>=0; i--) {
			int result = x * Integer.parseInt(String.valueOf(yStr.charAt(i)));
			bufferedWriter.write(result + "");
			bufferedWriter.newLine();
			
		}
		
		
		int y = Integer.parseInt(yStr);
		int lastResult = x * y;
		bufferedWriter.write(lastResult + "");
		
		bufferedWriter.flush();
		bufferedWriter.close();
		
	}
}
