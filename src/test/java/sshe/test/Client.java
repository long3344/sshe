package sshe.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s=new Socket(InetAddress.getByName("127.0.0.1"), 456);
			OutputStream os=s.getOutputStream();
			InputStream is=s.getInputStream();
			boolean r=true;
			while (r) {
				Scanner sc=new Scanner(System.in);
				String string=sc.nextLine();
				os.write(string.getBytes());
				byte[] b=new byte[1000];
				int len=is.read(b);
				String s1=new String(b,0,len);
				System.out.println("服务器："+s1);
				if (s1.equals("拜拜"))
					break;
			}
			s.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
