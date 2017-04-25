package sshe.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame {
	
	private static JTextField jtf=null;
	private static JTextArea jta=null;
	private static OutputStream os=null;
	private static InputStream is=null;
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		cJM();
		try {
			Socket s=new Socket(InetAddress.getByName("localhost"), 654);
			os=s.getOutputStream();
			is=s.getInputStream();
			while (true) {
				byte[] b=new byte[1024];
				int len=is.read(b);
				String string=new String(b,0,len);
				
				jta.append("服务器说："+string+"\n");
				if (string.equals("拜拜")) {
					break;
				}
			}
		} catch (Exception e) {
		}
		System.exit(0);
	}
	
	public static void cJM() {
		
		JFrame jf=new JFrame("客户端");
		jtf=new JTextField();
		jta=new JTextArea();
		
		jf.add(jtf,BorderLayout.NORTH);
		jf.add(jta,BorderLayout.CENTER);
		
		jtf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String string=jtf.getText();
				jtf.setText("");
				
				try {
					os.write(string.getBytes());
					
				} catch (Exception e2) {
				}
				
			}
			
		});
		jf.setSize(250, 250);
		jf.setLocation(100, 100);
		jf.setVisible(true);
	}
	
}
