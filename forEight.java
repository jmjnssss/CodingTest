package com.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class forEight {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int number = Integer.parseInt(br.readLine());
			int[] A = new int[number];
			int[] B = new int[number];
			for (int i = 0; i < number; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < number; i++) {
				bw.write("Case #" + (i + 1) + ": " + A[i] + " + " + B[i] + " = " + (A[i] + B[i]));
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}

				if (bw != null) {
					bw.flush();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
