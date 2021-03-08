package com.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class forNine {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int number = Integer.parseInt(br.readLine());
			for (int i = 1; i <= number; i++) {
				for (int j = 1; j <= i; j++) {
					bw.write("*");
				}
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.flush(); // close하기전에 flush를 해야합니다.
					bw.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
