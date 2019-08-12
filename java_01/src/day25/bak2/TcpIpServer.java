package day25.bak2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7777); // 포트넘버 저장  // new 하면 7777로 연결시도
			System.out.println("서버가 준비 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while (true) { // 들어오는 클라이언트한테 서비스 하고 싶어서 루프돌림
			try {
				System.out.println("Client 요청을 기다립니다.");
//				serverSocket.accept();  // 클라이언트 요청이 올때까지 기다리는것 // 클라이언트가 들어오면 소켓이 만들어짐
				Socket socket = serverSocket.accept();  // 어떤 아이피가 들어왔는지 확인가능함 // 기다리고 있는 구문
				//System.out.println(socket.getInetAddress()+" 와 연결중입니다."); // 나에게 요청한 사람의 아이피주소
				new ServerThread(socket).start();
				
			} catch (Exception e) {
				e.printStackTrace();
			}  finally {
			}
		}
	}
}



class ServerThread extends Thread { 
	BufferedReader br = null;
	BufferedWriter bw = null;
	Socket socket = null;
	String name = null;
	
	
	public ServerThread(Socket socket) {
		this.socket = socket;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			name = br.readLine(); 
			bw.write("Hello ~~~"+name +"님 \n"); 
			bw.flush(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}

	@Override
	public void run() {
		String msg = null; 
		try {
			while ((msg = br.readLine()) != null) { // 계속 동작하는 메소드는 run에옴
				bw.write(name+" : "+msg+"\n");
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) socket.close();
				if(br != null) br.close();
				if(bw != null) bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}



