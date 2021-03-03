package com.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class forFour {
	
	public static void main(String[] args) {
		
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
 		
		try {
			int T = Integer.parseInt(reader.readLine());
			for (int i=0; i<T; i++) {
				String[] a = reader.readLine().split(" ");
				writer.write(Integer.parseInt(a[0])+Integer.parseInt(a[1])+"\n");
			}
			writer.flush();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
