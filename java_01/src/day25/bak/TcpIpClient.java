package day25.bak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpClient {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1"; // 서버의 아이피 주소를 알아와야함 제이펜으로 알수 있다 여기서는 강제로 박음
		//String serverIp = "192.168.0.135"; // 강사님아이피
		BufferedReader br = null;
		BufferedWriter bw = null;
		Socket socket = null;
		Scanner keybord = null;
		
		try {
			System.out.println(serverIp +"연결시도 할게요..");
//			new Socket(serverIp, 7777); // 소켓만들고 서버아이피주소(=포트넘버) 넘겨줌 
			socket = new Socket(serverIp, 7777); // 허락을 해주면 정보를 가지게됨 // new 하면 7777로 연결시도 // 수락이되면 소켓이 만들어짐
			System.out.println("서버와 연결이 되었습니다.");
			
			// 메세지를 주고받고싶으면 인풋아웃풋스트림 필요함.. 소켓.겟(인)아웃풋스트림
			// 약속을 정해야함 라이트한후에 리드하도록
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // byte를 캐릭터로 바꿔야함
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keybord = new Scanner(System.in);
			
			System.out.println("이름을 입력하세요.. ");
			bw.write(keybord.nextLine()+"\n");
			bw.flush();
			System.out.println(br.readLine());
			
			while (true) {
				System.out.println("메세지를 입력하세요.. ");
				String msg = keybord.nextLine();
				bw.write(msg+"\n");
				bw.flush();
				System.out.println(br.readLine());
				if(msg.equals("q")) break;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {
				if(socket != null) socket.close();
				if(br != null) br.close();
				if(bw != null) bw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

	}

}
