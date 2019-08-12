package day25_ex;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TcpIpClient {
	public static void main(String[] args) {

		String serverIp = "127.0.0.1";
//		String serverIp = "192.168.0.112";
//		String serverIp = "192.168.0.135";
		BufferedReader br = null;
		BufferedWriter bw = null;
		String idPw = null;
		Socket socket = null;
		boolean pass = false;
		String ret = null;
		try {
			System.out.println(serverIp + "연결시도할게요...");
			socket = new Socket(serverIp, 7777); // 기다리고 있는 구문
			System.out.println("서버와 연결이 되었습니다.");
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader((socket.getInputStream())));
			idPw = JOptionPane.showInputDialog("id/pw형식으로 입력하세요");
			bw.write(idPw + "\n");
			bw.flush();

			if ((ret = br.readLine()).equals("ok")) {
				pass = true;
				System.out.println(ret);
				System.out.println(br.readLine());
			} else {
				System.out.println(ret);
				TcpIpClient.main(args);
			}
			
			while (pass) {
				String msg = JOptionPane.showInputDialog("메세지 입력하세요.. quit 입력하면 종료");
				bw.write(msg + "\n");
				bw.flush();
				System.out.println(br.readLine());
				if (msg.equals("quit"))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}
				if (socket != null) {
					socket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
