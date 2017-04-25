package sshe.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Service {

	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(456);
			Socket s=ss.accept();
			
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			
			boolean r=true;
			while (r) {
				byte[] b=new byte[1000];
				int len=is.read(b);
				String s1=new String(b,0,len);
				System.out.println("客户端："+s1);
				Scanner scanner=new Scanner(System.in);
				String str=scanner.nextLine();
				os.write(str.getBytes());
				if (s1.equals("拜拜"))
					break;
			}
			s.close();
			ss.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
