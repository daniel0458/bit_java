package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URL;

public class Test02 {
	public static void main(String[] args) {
		String address = "https://www.naver.com/index.html";
		String line = null;

		URL url = null;
//		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
//			fw = new FileWriter("a.html");
//			bw = new BufferedWriter(fw);
			bw = new BufferedWriter(new FileWriter("a.html"));
			url = new URL(address);
//			url.openStream(); //input스트림 생성 ,system.in과 비슷함
			br = new BufferedReader(new InputStreamReader(url.openStream()));

			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				bw.write(line+"\n");
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
