 package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<BufferedWriter> clientList = new ArrayList<BufferedWriter>();
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.println("Client 요청을 기다립니다.");
				Socket socket = serverSocket.accept(); // 기다리고 있는 구문
				new ServerThread(socket, clientList).start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

class ServerThread extends Thread {
	BufferedReader br = null;
	BufferedWriter bw = null;
	Socket socket = null;
	String name = null;
	List<BufferedWriter> clientList = null;

	public ServerThread(Socket socket, List<BufferedWriter> clientList) {
		this.socket = socket;
		this.clientList = clientList;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			clientList.add(bw);
			
			name = br.readLine();
//			System.out.println(name);
			broadcast( "님이 입장하셨습니다");
			
//			bw.write("Hello ~~~" + name + "님 \n");
//			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	@Override
	public synchronized void run() {
		String msg = null;
		try {
			while ((msg = br.readLine()) != null) {
				broadcast(msg);
				if(msg.equals("q")) {
					broadcast(" 님이 퇴장하셨습니다.");
				}
				
			}
		} catch (Exception e) {

		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					clientList.remove(bw);
					bw.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private synchronized void broadcast(String msg) {
		clientList.forEach(bw -> {
			try {
				bw.write(name + " : " + msg + "\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
}
