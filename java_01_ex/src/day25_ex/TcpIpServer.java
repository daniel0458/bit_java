package day25_ex;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		RunServer rs = null;
		List<BufferedWriter> clientList = new ArrayList<BufferedWriter>();
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.println("Client 요청을 기다립니다.");
				Socket socket = serverSocket.accept(); // 기다리고 있는 구문
				rs = new RunServer(socket, clientList);
				rs.start();
//				Thread job1 = new Thread(rs,"서버");
//				job1.start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

class RunServer extends Thread {

	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	String str = "안녕하세요";
	String id = "daniel";
	String pw = "0000";
	String msg = null;
	List<BufferedWriter> clientList = null;
	String[] idPw = null;
	String data;

	public RunServer(Socket socket, List<BufferedWriter> clientList) {
		this.socket = socket;
		this.clientList = clientList;
		System.out.println(socket.getInetAddress());

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			clientList.add(bw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	@Override
	public void run() {
		try {
			data = br.readLine();
			idPw = data.split("/");
			System.out.println("hello : " + idPw[0] + ",   pw : " + idPw[1]);

			if (idPw[0].equals(id) && idPw[1].equals(pw)) {
				bw.write("ok\n");
				bw.flush();
			} else {
				bw.write("다시 입력해 주세요\n");
				bw.flush();
				run();
			}

			bw.write(str + " " + idPw[0] + "\n");
			bw.flush();
			while ((msg = br.readLine()) != null) {
				if (msg.equals("quit")) {
					System.out.println("종료");
					bw.write("중지\n");
					bw.flush();
					break;
				}
				System.out.println(msg);
				bw.write("정상작동\n");
				bw.flush();
			}
			data = null;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void broadcast(String msg) {
		
	}
}
